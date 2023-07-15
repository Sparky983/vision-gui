package me.sparky983.vision.paper;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

import me.sparky983.vision.Click;
import me.sparky983.vision.Gui;
import me.sparky983.vision.Slot;

@NullMarked
final class InventoryListener implements Listener {

    private final PaperVision vision;

    InventoryListener(final PaperVision vision) {

        Objects.requireNonNull(vision, "vision cannot be null");

        this.vision = vision;
    }

    @EventHandler
    void onInventoryClick(final InventoryClickEvent event) {

        Objects.requireNonNull(event, "event cannot be null");

        if (!(event.getInventory().getHolder() instanceof final GuiInventoryHolder guiInventoryHolder)) {
            return;
        }

        event.setCancelled(true);

        if (!Objects.equals(event.getInventory(), event.getClickedInventory())) {
            return;
        }

        if (!(event.getWhoClicked() instanceof final Player player)) {
            return;
        }

        final Gui gui = guiInventoryHolder.gui();
        final Slot slot = gui.slots().get(event.getSlot());

        gui.button(slot).ifPresent((button) -> {
            final Click.Type type = switch (event.getClick()) {
                case LEFT -> Click.Type.LEFT;
                case SHIFT_LEFT -> Click.Type.SHIFT_LEFT;
                case RIGHT -> Click.Type.RIGHT;
                case SHIFT_RIGHT -> Click.Type.SHIFT_RIGHT;
                case MIDDLE -> Click.Type.MIDDLE;
                case DROP -> Click.Type.DROP;
                case CONTROL_DROP -> Click.Type.CONTROL_DROP;
                case DOUBLE_CLICK -> Click.Type.DOUBLE_CLICK;
                case NUMBER_KEY -> Click.Type.NUMBER_KEY;
                default -> null;
            };

            if (type == null) {
                return;
            }

            button.click(new PaperClick(player, button, slot, type, vision));
        });
    }
}

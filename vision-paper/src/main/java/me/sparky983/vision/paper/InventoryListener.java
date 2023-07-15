package me.sparky983.vision.paper;

import me.sparky983.vision.ClickType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

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
        final Slot slot = Slot.of(event.getSlot() / gui.columns(), event.getSlot() % gui.columns());

        gui.button(slot).ifPresent((button) -> {
            final ClickType type = switch (event.getClick()) {
                case LEFT -> ClickType.LEFT;
                case SHIFT_LEFT -> ClickType.SHIFT_LEFT;
                case RIGHT -> ClickType.RIGHT;
                case SHIFT_RIGHT -> ClickType.SHIFT_RIGHT;
                case MIDDLE -> ClickType.MIDDLE;
                case DROP -> ClickType.DROP;
                case CONTROL_DROP -> ClickType.CONTROL_DROP;
                case DOUBLE_CLICK -> ClickType.DOUBLE_CLICK;
                case NUMBER_KEY -> ClickType.NUMBER_KEY;
                default -> null;
            };

            if (type == null) {
                return;
            }

            button.click(new PaperClick(player, button, slot, type, vision));
        });
    }
}

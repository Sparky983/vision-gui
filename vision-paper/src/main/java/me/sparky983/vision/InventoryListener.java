package me.sparky983.vision;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

@NullMarked
final class InventoryListener implements Listener {

    @EventHandler
    void onInventoryClick(final InventoryClickEvent event) {

        Objects.requireNonNull(event, "event cannot be null");

        if (!(event.getInventory().getHolder() instanceof GuiInventoryHolder guiInventoryHolder)) {
            return;
        }

        event.setCancelled(true);

        if (!Objects.equals(event.getInventory(), event.getClickedInventory())) {
            return;
        }

        final Slot slot = Slot.of(event.getSlot() / Chest.COLUMNS, event.getSlot() % Chest.COLUMNS);
        guiInventoryHolder.gui().button(slot).ifPresent((button) -> {
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

            button.click(Click.of(event.getWhoClicked(), button, slot, type));
        });
    }
}

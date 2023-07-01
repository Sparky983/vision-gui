package me.sparky983.vision;

import org.bukkit.Server;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Objects;
import java.util.function.Function;

@NullMarked
final class SubscribingPaperInventoryMirror implements PaperInventoryMirror {

    private static final String UNABLE_TO_MIRROR_MESSAGE = """
            Unable to converter item type "%s". Possible causes:
            - The item is not available in this version of Minecraft
            - Legacy materials are enabled
            """;

    private final Server server;
    private final PaperConverter paperConverter;
    private final PaperButtonMirror buttonMirror;

    SubscribingPaperInventoryMirror(final Server server,
                                    final PaperConverter paperConverter,
                                    final PaperButtonMirror buttonMirror) {

        Objects.requireNonNull(server, "server cannot be null");
        Objects.requireNonNull(paperConverter, "paperConverter cannot be null");
        Objects.requireNonNull(buttonMirror, "buttonMirror cannot be null");

        this.server = server;
        this.paperConverter = paperConverter;
        this.buttonMirror = buttonMirror;
    }

    @Override
    public Inventory mirror(final Gui gui) {

        Objects.requireNonNull(gui, "gui cannot be null");

        final Function<InventoryHolder, Inventory> inventoryFactory = (inventoryHolder) -> {
            if (gui instanceof Chest) {
                return server.createInventory(inventoryHolder, gui.rows() * gui.columns(), gui.title());
            } else if (gui instanceof Hopper) {
                return server.createInventory(inventoryHolder, InventoryType.HOPPER, gui.title());
            } else if (gui instanceof Dropper) {
                return server.createInventory(inventoryHolder, InventoryType.DROPPER, gui.title());
            } else {
                throw new AssertionError("Unknown gui type: " + gui.getClass().getName());
            }
        };

        final Inventory inventory = new GuiInventoryHolder(gui, inventoryFactory).getInventory();

        final Gui.Subscriber subscriber = new Gui.Subscriber() {
            @Override
            public void exception(final RuntimeException thrown) {

            }

            @Override
            public void button(final Slot slot, final @Nullable Button button) {
                if (button == null) {
                    return;
                }
                final ItemStack item = paperConverter.convert(button).orElseThrow(() ->
                        new IllegalStateException(UNABLE_TO_MIRROR_MESSAGE.formatted(button.type())));
                final int rawSlot = slot.column() + (slot.row() * gui.columns());
                inventory.setItem(rawSlot, item);

                final ItemStack craftItem = inventory.getItem(rawSlot);
                // We need to get the item from the inventory because the item is cloned
                assert craftItem != null;
                buttonMirror.mirror(button, craftItem);
            }
        };

        for (int row = 0; row < gui.rows(); row++) {
            for (int column = 0; column < gui.columns(); column++) {
                final Slot slot = Slot.of(row, column);
                gui.button(slot).ifPresent((button) -> {
                    // Essentially replaying the button sets
                    subscriber.button(slot, button);
                });
            }
        }

        gui.subscribe(subscriber);

        return inventory;
    }
}

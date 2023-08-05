package me.sparky983.vision.paper;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.GlobalTranslator;
import org.bukkit.Server;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;

import me.sparky983.vision.Button;
import me.sparky983.vision.Gui;
import me.sparky983.vision.Slot;

@NullMarked
final class SubscribingPaperInventoryMirror implements PaperInventoryMirror {

    private static final String UNABLE_TO_MIRROR_MESSAGE = """
            Unable to converter item type "%s". Possible causes:
            - The item is not available in this version of Minecraft
            - Legacy materials are enabled
            """;

    private final Server server;
    private final PaperItemTypeConverter itemTypeConverter;
    private final PaperButtonMirror buttonMirror;

    SubscribingPaperInventoryMirror(final Server server,
                                    final PaperItemTypeConverter itemTypeConverter,
                                    final PaperButtonMirror buttonMirror) {

        Objects.requireNonNull(server, "server cannot be null");
        Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");
        Objects.requireNonNull(buttonMirror, "buttonMirror cannot be null");

        this.server = server;
        this.itemTypeConverter = itemTypeConverter;
        this.buttonMirror = buttonMirror;
    }

    @Override
    public Inventory mirror(final Gui gui, final Locale locale) {

        Objects.requireNonNull(gui, "gui cannot be null");
        Objects.requireNonNull(locale, "locale cannot be null");

        final Component title = GlobalTranslator.render(gui.title(), locale);

        final Function<InventoryHolder, Inventory> inventoryFactory = (inventoryHolder) ->
                switch (gui.type()) {
                    case CHEST ->
                            server.createInventory(inventoryHolder, gui.rows() * gui.columns(),title);
                    case HOPPER ->
                            server.createInventory(inventoryHolder, InventoryType.HOPPER, title);
                    case DROPPER ->
                            server.createInventory(inventoryHolder, InventoryType.DROPPER, title);
                };

        final Inventory inventory = new GuiInventoryHolder(gui, inventoryFactory).getInventory();

        final Gui.Subscriber subscriber = new Gui.Subscriber() {
            @Override
            public void button(final Slot slot, final @Nullable Button button) {

                final int rawSlot = slot.column() + (slot.row() * gui.columns());
                if (button == null) {
                    inventory.setItem(rawSlot, null);
                    return;
                }
                final ItemStack item = itemTypeConverter.convert(button.type())
                        .map(ItemStack::new)
                        .orElseThrow(() -> new IllegalStateException(
                                String.format(UNABLE_TO_MIRROR_MESSAGE, button.type())));
                inventory.setItem(rawSlot, item);

                final ItemStack craftItem = inventory.getItem(rawSlot);
                // We need to get the item from the inventory because the item is cloned
                assert craftItem != null;
                buttonMirror.mirror(button, craftItem, locale);
            }
        };

        for (final Slot slot : gui.slots()) {
            gui.button(slot).ifPresent((button) -> {
                // Essentially replaying the button sets
                subscriber.button(slot, button);
            });
        }

        gui.subscribe(subscriber);

        return inventory;
    }
}

package me.sparky983.vision.paper;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.renderer.TranslatableComponentRenderer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.Translator;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.List;
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
            public void exception(final RuntimeException thrown) {

            }

            @Override
            public void button(final Slot slot, final @Nullable Button button) {

                if (button == null) {
                    return;
                }
                final ItemStack item = paperConverter.convert(button.type())
                        .map(ItemStack::new)
                        .orElseThrow(() -> new IllegalStateException(
                                String.format(UNABLE_TO_MIRROR_MESSAGE, button.type())));
                final int rawSlot = slot.column() + (slot.row() * gui.columns());
                inventory.setItem(rawSlot, item);

                final ItemStack craftItem = inventory.getItem(rawSlot);
                // We need to get the item from the inventory because the item is cloned
                assert craftItem != null;
                buttonMirror.mirror(button, craftItem, locale);
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

package me.sparky983.vision;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;

@NullMarked
final class PaperVisionImpl implements PaperVision {

    private final Plugin plugin;
    private final PluginManager pluginManager;
    private final PaperItemFactory paperItemFactory;
    final PaperButtonMirror paperButtonMirror;

    PaperVisionImpl(final Plugin plugin,
                    final PluginManager pluginManager,
                    final PaperItemFactory paperItemFactory,
                    final PaperButtonMirror paperButtonMirror) {

        Objects.requireNonNull(plugin, "plugin cannot be null");
        Objects.requireNonNull(pluginManager, "pluginManager cannot be null");
        Objects.requireNonNull(paperItemFactory, "paperItemFactory cannot be null");
        Objects.requireNonNull(paperButtonMirror, "paperButtonMirror cannot be null");

        this.plugin = plugin;
        this.pluginManager = pluginManager;
        this.paperItemFactory = paperItemFactory;
        this.paperButtonMirror = paperButtonMirror;
    }

    @Override
    public void open(final Player player, final Gui gui) {

        Objects.requireNonNull(player, "player cannot be null");
        Objects.requireNonNull(gui, "gui cannot be null");

        final Inventory inventory = Bukkit.createInventory(null, gui.rows() * 9, gui.title());

        IntStream.range(0, gui.rows())
                .mapToObj((row) -> IntStream.range(0, 9).mapToObj((column) -> Slot.of(row, column)))
                .flatMap(Function.identity())
                .forEach((slot) -> gui.button(slot)
                        .ifPresent((button) -> {
                            final ItemStack item = paperItemFactory.create(button);
                            final int rawSlot = slot.column() + (slot.row() * 9);
                            inventory.setItem(rawSlot, item);

                            final ItemStack craftItem = inventory.getItem(rawSlot);
                            // We need to get the item from the inventory because the item is cloned
                            assert craftItem != null;
                            paperButtonMirror.mirror(button, craftItem);
                        }));

        pluginManager.registerEvents(new InventoryListener(inventory, gui), plugin);

        player.openInventory(inventory);
    }
}

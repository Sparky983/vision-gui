package me.sparky983.vision.paper;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

import me.sparky983.vision.Gui;

@NullMarked
final class PaperVisionImpl implements PaperVision {

    private final Plugin plugin;
    private final PluginManager pluginManager;
    private final PaperInventoryMirror inventoryMirror;
    private @Nullable InventoryListener inventoryListener;

    PaperVisionImpl(final Plugin plugin,
                    final PluginManager pluginManager,
                    final PaperInventoryMirror inventoryMirror) {

        Objects.requireNonNull(plugin, "plugin cannot be null");
        Objects.requireNonNull(pluginManager, "pluginManager cannot be null");
        Objects.requireNonNull(inventoryMirror, "inventoryMirror cannot be null");

        this.plugin = plugin;
        this.pluginManager = pluginManager;
        this.inventoryMirror = inventoryMirror;
    }

    @Override
    public void open(final Player player, final Gui gui) {

        Objects.requireNonNull(player, "player cannot be null");
        Objects.requireNonNull(gui, "gui cannot be null");

        if (inventoryListener == null) {
            inventoryListener = new InventoryListener(this);
            pluginManager.registerEvents(inventoryListener, plugin);
        }

        final Inventory inventory = inventoryMirror.mirror(gui, player.locale());

        player.openInventory(inventory);
    }
}

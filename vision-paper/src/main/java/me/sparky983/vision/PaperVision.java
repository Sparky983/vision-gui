package me.sparky983.vision;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

/**
 * The paper gui manager.
 *
 * @since 0.1
 */
@NullMarked
public interface PaperVision extends Vision {

    /**
     * Creates a new paper gui manager.
     *
     * @return the newly created paper gui manager
     * @param plugin the plugin
     * @throws NullPointerException if the plugin is {@code null}.
     * @since 0.1
     */
    static PaperVision create(final Plugin plugin) {

        Objects.requireNonNull(plugin, "plugin cannot be null");

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        return new PaperVisionImpl(
                plugin,
                plugin.getServer().getPluginManager(),
                new CloningPaperItemFactory(itemTypeConverter),
                new PaperButtonMirrorImpl(itemTypeConverter)
        );
    }

    /**
     * Opens the specified GUI for the specified player.
     *
     * @param player the player
     * @param gui the GUI
     * @throws NullPointerException if the player or the GUI is {@code null}.
     * @since 0.1
     */
    void open(Player player, Gui gui);
}

package me.sparky983.vision;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

/**
 * The paper GUI manager.
 *
 * @since 0.1
 */
@NullMarked
public interface PaperVision extends Vision {

    /**
     * Creates a new paper GUI manager.
     *
     * @return the newly created paper GUI manager
     * @param plugin the plugin
     * @throws NullPointerException if the plugin is {@code null}.
     * @since 0.1
     */
    static PaperVision create(final Plugin plugin) {

        Objects.requireNonNull(plugin, "plugin cannot be null");

        final PaperConverter converter = new PaperConverterImpl(new ModernPaperItemTypeConverter());

        return new PaperVisionImpl(
                plugin,
                plugin.getServer().getPluginManager(),
                new SubscribingPaperInventoryMirror(
                        plugin.getServer(),
                        converter,
                        new SubscribingPaperButtonMirror(converter)
                )
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

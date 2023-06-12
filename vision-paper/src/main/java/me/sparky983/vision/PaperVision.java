package me.sparky983.vision;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

/**
 * The Paper {@link Gui} manager.
 *
 * @since 0.1
 */
@NullMarked
public interface PaperVision {

    /**
     * Creates a new Paper {@link Gui} manager.
     *
     * @return the newly created Paper {@link Gui} manager
     * @param plugin the plugin
     * @throws NullPointerException if the plugin is {@code null}.
     * @since 0.1
     * @vision.apiNote This method is pure since {@code Listener} registration is done lazily.
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
     * Opens the specified {@link Gui} for the specified player.
     *
     * @param player the player
     * @param gui the {@link Gui}
     * @throws NullPointerException if the player or the GUI is {@code null}.
     * @since 0.1
     */
    void open(Player player, Gui gui);
}

package me.sparky983.vision.paper;

import java.util.Objects;
import me.sparky983.vision.Gui;
import me.sparky983.vision.GuiLike;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

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

    final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

    return new PaperVisionImpl(
        plugin,
        plugin.getServer().getPluginManager(),
        new SubscribingPaperInventoryMirror(
            plugin.getServer(),
            itemTypeConverter,
            new SubscribingPaperButtonMirror(new PaperComponentFixerImpl(), itemTypeConverter)));
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

  /**
   * Converts specified {@link GuiLike} to a {@link Gui} and opens it for the specified player.
   *
   * @param player the player
   * @param gui the {@link GuiLike}
   * @throws NullPointerException if the player or the GUI is {@code null}.
   * @since 1/1
   */
  @ApiStatus.Experimental
  default void open(final Player player, final GuiLike gui) {
    Objects.requireNonNull(player, "player cannot be null");
    Objects.requireNonNull(gui, "gui cannot be null");

    open(player, gui.asGui());
  }
}

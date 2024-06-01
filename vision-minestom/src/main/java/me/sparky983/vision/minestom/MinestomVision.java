package me.sparky983.vision.minestom;

import me.sparky983.vision.Gui;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

/**
 * The Minestom {@link Gui} manager.
 *
 * @since 1.1
 */
@ApiStatus.NonExtendable
@NullMarked
public interface MinestomVision {
  /**
   * Creates a new Minestom {@link Gui} manager.
   *
   * @return the newly created Minestom {@link Gui} manager
   * @throws NullPointerException if the plugin is {@code null}.
   * @since 1.1
   */
  static MinestomVision create() {
    return new MinestomVisionImpl();
  }

  /**
   * Opens the specified {@link Gui} for the specified player.
   *
   * @param player the player
   * @param gui the {@link Gui}
   * @throws NullPointerException if the player or the GUI is {@code null}.
   * @since 1.1
   */
  void open(Player player, Gui gui);
}

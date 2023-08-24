package me.sparky983.vision;

import org.jetbrains.annotations.ApiStatus;

/**
 * Represents the a {@link Gui} variant.
 *
 * @since 1.0
 * @vision.experimental because this will be removed after Java 21 is released.
 * @vision.apiNote This is intended to be used so {@code switch} statements can be used to determine
 * the type of {@link Gui} without having to use {@code instanceof}.
 */
@ApiStatus.Experimental
public enum GuiType {
  /**
   * The {@link Chest} variant.
   *
   * @since 1.0
   */
  CHEST,

  /**
   * The {@link Dropper} variant.
   *
   * @since 1.0
   */
  DROPPER,

  /**
   * The {@link Hopper} variant.
   *
   * @since 1.0
   */
  HOPPER
}

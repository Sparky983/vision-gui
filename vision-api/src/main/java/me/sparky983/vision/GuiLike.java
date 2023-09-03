package me.sparky983.vision;

import org.jetbrains.annotations.ApiStatus;

/**
 * Something that can be converted to a {@link Gui}.
 *
 * @see Gui
 * @since 1.1
 * @vision.experimental as this may be deleted or renamed.
 */
@ApiStatus.Experimental
public interface GuiLike {
  /**
   * Converts this to a {@link Gui}.
   *
   * @return the gui
   * @since 1.11
   */
  Gui asGui();
}

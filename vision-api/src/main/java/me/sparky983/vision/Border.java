package me.sparky983.vision;

import java.util.Set;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

/**
 * Represents a {@link Gui} border.
 *
 * @since 1.0
 * @deprecated use vision-elements instead.
 */
@Deprecated(forRemoval = true)
@ApiStatus.ScheduledForRemoval(inVersion = "1.3.0")
@NullMarked
public enum Border {
  /**
   * The top border.
   * <p>
   * This border covers all slots in the topmost row.
   *
   * @since 1.0
   */
  TOP,

  /**
   * The bottom border.
   * <p>
   * This border covers all slots in the bottom-most row.
   *
   * @since 1.0
   */
  BOTTOM,

  /**
   * The left border.
   * <p>
   * This border covers all slots in the leftmost column.
   *
   * @since 1.0
   */
  LEFT,

  /**
   * The right border.
   * <p>
   * This border covers all slots in the rightmost column.
   *
   * @since 1.0
   */
  RIGHT;

  private static final Set<Border> ALL = Set.of(Border.values());

  /**
   * Returns an unmodifiable set containing all {@code Borders}.
   *
   * @return an unmodifiable set containing all {@code Borders}
   * @since 1.0
   * @vision.implNote The returned set is cached.
   */
  // TODO(Sparky983): Does this really need to be public? Users shouldn't need to use this because
  //  of Gui.Builder.border(Button).
  public static Set<Border> all() {
    return ALL;
  }
}

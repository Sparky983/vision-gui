package me.sparky983.vision;

import java.util.Set;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents the {@link Hopper} variant of a {@link Gui}.
 *
 * @see #hopper()
 * @since 1.0
 * @vision.examples {@snippet :
 * Gui gui = Gui.hopper()
 *         .title(Component.text("My GUI"))
 *         .button(Slot.of(0, 2), Button.of(ItemType.STONE))
 *         .build();
 * }
 */
@NullMarked
public non-sealed interface Hopper extends Gui {
  /**
   * The number of columns {@code Hopper}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental
  int ROWS = 1;

  /**
   * The number of columns {@code Hopper}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental
  int COLUMNS = 5;

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException {@inheritDoc}
   * @throws NullPointerException {@inheritDoc}
   * @since 1.0
   */
  @Override
  Hopper button(Slot slot, @Nullable Button button);

  /**
   * A {@link Hopper} builder.
   *
   * @see #hopper()
   * @since 1.0
   * @vision.examples {@snippet :
   * Gui gui = Gui.hopper()
   *         .title(Component.text("My GUI"))
   *         .button(Slot.of(0, 2), Button.of(ItemType.STONE))
   *         .build();
   * }
   */
  non-sealed interface Builder extends Gui.Builder {
    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException {@inheritDoc}
     * @since 1.0
     * @vision.apiNote {@inheritDoc}
     */
    @Override
    Builder title(Component title);

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException {@inheritDoc}
     * @since 1.0
     */
    @Override
    Builder button(Slot slot, Button button);

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException {@inheritDoc}
     * @since 1.0
     * @vision.experimental {@inheritDoc}
     */
    @Override
    @ApiStatus.Experimental
    Builder fill(Button button);

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.0
     * @vision.experimental {@inheritDoc}
     */
    @Override
    @ApiStatus.Experimental
    Builder border(Button button, Set<? extends Border> borders);

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.0
     * @vision.experimental {@inheritDoc}
     */
    @Override
    @ApiStatus.Experimental
    Builder border(Button button, Border... borders);

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException {@inheritDoc}
     * @since 1.0
     * @vision.experimental {@inheritDoc}
     */
    @Override
    @ApiStatus.Experimental
    Builder border(Button button);

    /**
     * {@inheritDoc}
     *
     * @throws IllegalStateException {@inheritDoc}
     * @since 1.0
     */
    @Override
    Hopper build();
  }
}

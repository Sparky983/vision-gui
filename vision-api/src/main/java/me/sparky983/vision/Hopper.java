package me.sparky983.vision;

import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents the {@link Hopper} variant of a {@link Gui}.
 *
 * @see #hopper()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.hopper()
 *        .title(Component.text("My GUI"))
 *        .slot(Slot.of(0, 2), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@ApiStatus.NonExtendable
@NullMarked
public non-sealed interface Hopper extends Gui {
  /**
   * The number of columns {@code Hopper}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental int ROWS = 1;

  /**
   * The number of columns {@code Hopper}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental int COLUMNS = 5;

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException {@inheritDoc}
   * @throws NullPointerException {@inheritDoc}
   * @since 1.0
   * @deprecated {@inheritDoc}
   */
  @Deprecated
  @Override
  default Hopper button(final Slot slot, final @Nullable Button button) {
    return slot(slot, button);
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException {@inheritDoc}
   * @throws NullPointerException {@inheritDoc}
   * @since 1.1
   */
  @Override
  Hopper slot(Slot slot, @Nullable Button button);

  /**
   * {@inheritDoc}
   *
   * @throws NullPointerException {@inheritDoc}
   * @since 1.1
   */
  @Override
  Hopper onClose(Consumer<? super Close> handler);

  /**
   * A {@link Hopper} builder.
   *
   * @see #hopper()
   * @since 1.0
   * @vision.examples <pre>
   *Gui gui = Gui.hopper()
   *        .title(Component.text("My GUI"))
   *        .slot(Slot.of(0, 2), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
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
     * @deprecated {@inheritDoc}
     */
    @Deprecated
    @Override
    default Builder button(final Slot slot, final Button button) {
      return slot(slot, button);
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.1
     */
    @Override
    Builder slot(Slot slot, Button button);

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
    Builder border(Set<Border> borders, Button button);

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
    Builder border(Border border, Button button);

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
     * @throws NullPointerException {@inheritDoc}
     * @since 1.1
     */
    @Override
    Builder onClose(Consumer<? super Close> handler);

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

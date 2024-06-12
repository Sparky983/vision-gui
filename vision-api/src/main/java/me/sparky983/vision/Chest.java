package me.sparky983.vision;

import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents the {@code Chest} variant of a {@link Gui}.
 *
 * @see #chest()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.chest()
 *        .title(Component.text("My GUI"))
 *        .rows(3)
 *        .slot(Slot.of(1, 4), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@ApiStatus.NonExtendable
@NullMarked
public non-sealed interface Chest extends Gui {
  /**
   * The minimum number of rows that a {@code Chest} can have.
   *
   * @see Gui#rows()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental
  int MIN_ROWS = 1;

  /**
   * The maximum number of rows that a {@code Chest} can have.
   *
   * @see Gui#rows()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental
  int MAX_ROWS = 6;

  /**
   * The number of columns {@code Chest}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental
  int COLUMNS = 9;

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
  default Chest button(final Slot slot, final @Nullable Button button) {
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
  Chest slot(Slot slot, @Nullable Button button);

  /**
   * {@inheritDoc}
   *
   * @throws NullPointerException {@inheritDoc}
   * @since 1.1
   */
  @Override
  Chest onClose(Consumer<? super Close> handler);

  /**
   * A {@link Chest} builder.
   *
   * @see #chest()
   * @since 1.0
   * @vision.examples <pre>
   *Gui gui = Gui.chest()
   *        .title(Component.text("My GUI"))
   *        .rows(3)
   *        .slot(Slot.of(1, 4), Button.of(ItemType.STONE))
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
     * Sets the number of rows in the {@link Chest}.
     *
     * @param rows the number of rows
     * @return this {@code Builder} instance (for chaining)
     * @throws IllegalArgumentException if the number of rows is less than 1 or greater than
     * 6.
     * @since 1.0
     * @vision.apiNote After the {@link Chest} is built, the number of rows cannot be changed,
     * so it must be specified before the {@link Chest} is built.
     */
    Builder rows(int rows);

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
     * @throws NullPointerException {@inheritDoc}
     * @since 1.1
     */
    @Override
    Builder slot(Slot slot, Button button);

    /**
     * {@inheritDoc}
     * <p>
     * If the amount of rows change via subsequent calls to {@link #rows(int)}, they will be
     * prefilled with the specified {@link Button}.
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
     * <p>
     * The borders are set during {@link #build()}, so subsequent calls to {@link #rows(int)}
     * will move the {@link Border#BOTTOM bottom border}.
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
     * <p>
     * The borders are set during {@link #build()}, so subsequent calls to {@link #rows(int)}
     * will move the {@link Border#BOTTOM bottom border}.
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
     * <p>
     * The borders are set during {@link #build()}, so subsequent calls to {@link #rows(int)}
     * will move the {@link Border#BOTTOM bottom border}.
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
    Chest build();
  }
}

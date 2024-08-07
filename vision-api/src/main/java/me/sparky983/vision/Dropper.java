package me.sparky983.vision;

import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents the {@link Dropper} variant of a {@link Gui}.
 *
 * @see #dropper()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.dropper()
 *        .title(Component.text("My GUI"))
 *        .slot(Slot.of(1, 1), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@ApiStatus.NonExtendable
@NullMarked
public non-sealed interface Dropper extends Gui {
  /**
   * The number of columns {@code Dropper}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental int ROWS = 3;

  /**
   * The number of columns {@code Dropper}s have.
   *
   * @see Gui#columns()
   * @since 1.0
   * @vision.experimental because this may be deleted, renamed or moved.
   */
  @ApiStatus.Experimental int COLUMNS = 3;

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
  default Dropper button(final Slot slot, @Nullable final Button button) {
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
  Dropper slot(Slot slot, @Nullable Button button);

  /**
   * {@inheritDoc}
   *
   * @throws NullPointerException {@inheritDoc}
   * @since 1.1
   */
  @Override
  Dropper onClose(Consumer<? super Close> handler);

  /**
   * A {@link Dropper} builder.
   *
   * @see #dropper()
   * @since 1.0
   * @vision.examples <pre>
   *Gui gui = Gui.dropper()
   *        .title(Component.text("My GUI"))
   *        .slot(Slot.of(1, 1), Button.of(ItemType.STONE))
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
    Dropper build();
  }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Set;

/**
 * Represents the {@code Chest} variant of a {@link Gui}.
 *
 * @see #chest()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.chest()
 *        .title(Component.text("My GUI"))
 *        .rows(3)
 *        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@NullMarked
public non-sealed interface Chest extends Gui {

    /**
     * The minimum number of rows that a chest can have.
     *
     * @see Gui#rows()
     * @since 1.0
     * @vision.experimental because this may be deleted, renamed or moved.
     */
    @ApiStatus.Experimental
    int MIN_ROWS = 1;

    /**
     * The maximum number of rows that a chest can have.
     *
     * @see Gui#rows()
     * @since 1.0
     * @vision.experimental because this may be deleted, renamed or moved.
     */
    @ApiStatus.Experimental
    int MAX_ROWS = 6;

    /**
     * The number of columns chests have.
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
     */
    @Override
    Chest button(Slot slot, @Nullable Button button);

    /**
     * A {@link Chest} builder.
     *
     * @see #chest()
     * @since 1.0
     * @vision.examples <pre>
     *Gui gui = Gui.chest()
     *        .title(Component.text("My GUI"))
     *        .rows(3)
     *        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
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
         * @return this builder instance (for chaining)
         * @throws IllegalArgumentException if the number of rows is less than 1 or greater than
         * 6.
         * @since 1.0
         * @vision.apiNote This method must be called before {@link #build()}.
         */
        Builder rows(int rows);

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
         * <p>
         * If the amount of rows change via subsequent calls to {@link #rows(int)}, they will be
         * prefilled with the specified {@link Button}.
         *
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         * @vision.experimental {@inheritDoc}
         */
        @Override
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
        Builder border(Button button, Set<Border> borders);

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
        Builder border(Button button, Border... borders);

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
        Builder border(Button button);

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

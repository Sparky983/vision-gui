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
    interface Builder extends Gui.Builder {

        /**
         * Sets the title of the {@link Chest}.
         *
         * @param title {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         * @vision.apiNote After the {@link Chest} is built, the title cannot be changed, so it
         * must be specified before the {@link Chest} is built
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
         * Sets the {@link Button} at the specified {@link Slot} of the {@link Chest}.
         *
         * @param slot {@inheritDoc}
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Builder button(Slot slot, Button button);

        /**
         * Sets all the empty slots to the specified {@link Button} in the {@link Chest}.
         * <p>
         * If the amount of rows change via subsequent calls to {@link #rows(int)}, they will be
         * prefilled with the specified {@link Button}.
         *
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Builder fill(Button button);

        /**
         * Sets the specified borders of the {@link Chest} to the specified {@link Button}.
         * <p>
         * Changes to the border set after this method is called will not affect the {@link Chest}.
         * <p>
         * When the {@link Chest} is built, the {@link Button Buttons} will be placed in the empty
         * slots covered by the borders. If a border has been specified multiple times, the last
         * specified {@link Button} will be used. The same is the case for corners.
         * <p>
         * The borders are set during {@link #build()}, so subsequent calls to {@link #rows(int)}
         * will move the {@link Border#BOTTOM bottom border}.
         *
         * @param button {@inheritDoc}
         * @param borders {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @throws IllegalArgumentException {@inheritDoc}
         * @since 1.0
         * @vision.experimental {@inheritDoc}
         */
        @Override
        Builder border(Button button, Set<Border> borders);

        /**
         * Sets the specified borders of the {@link Chest} to the specified {@link Button}.
         * <p>
         * Changes to the border array after this method is called will not affect the
         * {@link Chest}.
         * <p>
         * When the {@link Chest} is built, the {@link Button Buttons} will be placed in the empty
         * slots covered by the borders. If a border has been specified multiple times, the last
         * specified {@link Button} will be used. The same is the case for corners.
         * <p>
         * The borders are set during {@link #build()}, so subsequent calls to {@link #rows(int)}
         * will move the {@link Border#BOTTOM bottom border}.
         *
         * @param button {@inheritDoc}
         * @param borders {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @throws IllegalArgumentException {@inheritDoc}
         * @since 1.0
         * @vision.experimental {@inheritDoc}
         */
        @Override
        Builder border(Button button, Border... borders);

        /**
         * Sets all the borders of the {@link Chest} to the specified {@link Button}.
         * <p>
         * When the {@link Chest} is built, the {@link Button Buttons} will be placed in all empty
         * border slots. If a border has been specified multiple times, the last specified
         * {@link Button} will be used. The same is the case for corners.
         * <p>
         * The borders are set during {@link #build()}, so subsequent calls to {@link #rows(int)}
         * will move the {@link Border#BOTTOM bottom border}.
         *
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         * @vision.experimental {@inheritDoc}
         */
        @Override
        Builder border(Button button);

        /**
         * Builds the {@link Chest}.
         * <p>
         * If both a {@link #fill(Button) fill} and a {@link #border(Button, Set) border} has been
         * specified, the {@link #border(Button, Set) border} will overlay the {@link #fill(Button)}
         * in the returned {@link Chest}.
         *
         * @return the built {@link Chest}
         * @throws IllegalStateException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Chest build();
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;

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
non-sealed public interface Chest extends Gui {

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
         * Sets all current slots to the specified {@link Button} in the {@link Chest}.
         * <p>
         * This method will replace any preexisting {@link Button Buttons}.
         * <p>
         * If more slots are added after this method is called via {@link #rows(int)}, they will not
         * be filled.
         *
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Builder fill(Button button);
        // TODO: Figure out if we should do anything different if the amount of slots change

        /**
         * Builds the {@link Chest}.
         *
         * @return the built {@link Chest}
         * @throws IllegalStateException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Chest build();
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;

import java.util.Set;

/**
 * Represents the {@link Dropper} variant of a {@link Gui}.
 *
 * @see #dropper()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.dropper()
 *        .title(Component.text("My GUI"))
 *        .button(Slot.of(1, 1), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@NullMarked
public non-sealed interface Dropper extends Gui {

    /**
     * The number of columns dropper have.
     *
     * @see Gui#columns()
     * @since 1.0
     * @vision.experimental because this may be deleted, renamed or moved.
     */
    @ApiStatus.Experimental
    int ROWS = 3;

    /**
     * The number of columns dropper have.
     *
     * @see Gui#columns()
     * @since 1.0
     * @vision.experimental because this may be deleted, renamed or moved.
     */
    @ApiStatus.Experimental
    int COLUMNS = 3;

    /**
     * A {@link Dropper} builder.
     *
     * @see #dropper()
     * @since 1.0
     * @vision.examples <pre>
     *Gui gui = Gui.dropper()
     *        .title(Component.text("My GUI"))
     *        .button(Slot.of(1, 1), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     */
    interface Builder extends Gui.Builder {

        /**
         * Sets the title of the {@link Dropper}.
         *
         * @param title {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         * @vision.apiNote After the {@link Gui} is built, the title cannot be changed, so it
         * must be specified before the {@link Gui} is built
         */
        @Override
        Builder title(Component title);

        /**
         * Sets the {@link Button} at the specified {@link Slot} of the {@link Dropper}.
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
         * Sets all the empty slots to the specified {@link Button} in the {@link Dropper}.
         *
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Builder fill(Button button);

        /**
         * Sets the specified borders of the {@link Dropper} to the specified {@link Button}.
         * <p>
         * Changes to the border set after this method is called will not affect the
         * {@link Dropper}.
         * <p>
         * When the {@link Dropper} is built, the {@link Button Buttons} will be placed in the empty
         * slots covered by the borders. If a border has been specified multiple times, the last
         * specified {@link Button} will be used. The same is the case for corners.
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
         * Sets the specified borders of the {@link Dropper} to the specified {@link Button}.
         * <p>
         * Changes to the border array after this method is called will not affect the
         * {@link Dropper}.
         * <p>
         * When the {@link Dropper} is built, the {@link Button Buttons} will be placed in the empty
         * slots covered by the borders. If a border has been specified multiple times, the last
         * specified {@link Button} will be used. The same is the case for corners.
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
         * Sets all the borders of the {@link Dropper} to the specified {@link Button}.
         * <p>
         * When the {@link Dropper} is built, the {@link Button Buttons} will be placed in all empty
         * border slots. If a border has been specified multiple times, the last specified
         * {@link Button} will be used. The same is the case for corners.
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
         * Builds the {@link Dropper}.
         * <p>
         * If both a {@link #fill(Button) fill} and a {@link #border(Button, Set) border} has been
         * specified, the {@link #border(Button, Set) border} will overlay the {@link #fill(Button)}
         * in the returned {@link Dropper}.
         *
         * @return the built {@link Dropper}
         * @throws IllegalStateException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Dropper build();
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Set;

/**
 * Represents the {@link Hopper} variant of a {@link Gui}.
 *
 * @see #hopper()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.hopper()
 *        .title(Component.text("My GUI"))
 *        .button(Slot.of(0, 2), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@NullMarked
public non-sealed interface Hopper extends Gui {

    /**
     * The number of columns hoppers have.
     *
     * @see Gui#columns()
     * @since 1.0
     * @vision.experimental because this may be deleted, renamed or moved.
     */
    @ApiStatus.Experimental
    int ROWS = 1;

    /**
     * The number of columns hoppers have.
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
     * @vision.examples <pre>
     *Gui gui = Gui.hopper()
     *        .title(Component.text("My GUI"))
     *        .button(Slot.of(0, 2), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     */
    interface Builder extends Gui.Builder {

        /**
         * Sets the title of the {@link Hopper}.
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
         * Sets the {@link Button} at the specified {@link Slot} of the {@link Hopper}.
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
         * Sets all the empty slots to the specified {@link Button} in the {@link Hopper}.
         *
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Builder fill(Button button);

        /**
         * Sets the specified borders of the {@link Hopper} to the specified {@link Button}.
         * <p>
         * Changes to the border set after this method is called will not affect the {@link Hopper}.
         * <p>
         * When the {@link Hopper} is built, the {@link Button Buttons} will be placed in the empty
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
         * Sets the specified borders of the {@link Hopper} to the specified {@link Button}.
         * <p>
         * Changes to the border array after this method is called will not affect the
         * {@link Hopper}.
         * <p>
         * When the {@link Hopper} is built, the {@link Button Buttons} will be placed in the empty
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
         * Sets all the borders of the {@link Hopper} to the specified {@link Button}.
         * <p>
         * When the {@link Hopper} is built, the {@link Button Buttons} will be placed in all empty
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
         * Builds the {@link Hopper}.
         * <p>
         * If both a {@link #fill(Button) fill} and a {@link #border(Button, Set) border} has been
         * specified, the {@link #border(Button, Set) border} will overlay the {@link #fill(Button)}
         * in the returned {@link Hopper}.
         *
         * @return the built {@link Hopper}
         * @throws IllegalStateException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Hopper build();
    }
}

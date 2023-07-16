package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;

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
        Builder fill(Button button);

        /**
         * {@inheritDoc}
         *
         * @throws NullPointerException {@inheritDoc}
         * @throws IllegalArgumentException {@inheritDoc}
         * @since 1.0
         * @vision.experimental {@inheritDoc}
         */
        @Override
        Builder border(Button button, Set<Border> borders);

        /**
         * {@inheritDoc}
         *
         * @throws NullPointerException {@inheritDoc}
         * @throws IllegalArgumentException {@inheritDoc}
         * @since 1.0
         * @vision.experimental {@inheritDoc}
         */
        @Override
        Builder border(Button button, Border... borders);

        /**
         * {@inheritDoc}
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
        Hopper build();
    }
}

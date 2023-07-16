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
        Dropper build();
    }
}

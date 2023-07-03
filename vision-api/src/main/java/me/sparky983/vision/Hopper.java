package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;

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
non-sealed public interface Hopper extends Gui {

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
         * Sets all current slots to the specified {@link Button} in the {@link Hopper}.
         * <p>
         * This method will replace any preexisting {@link Button Buttons}.
         *
         * @param button {@inheritDoc}
         * @return {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Builder fill(Button button);

        /**
         * Builds the {@link Hopper}.
         *
         * @return the built {@link Hopper}
         * @throws IllegalStateException {@inheritDoc}
         * @since 1.0
         */
        @Override
        Hopper build();
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;

import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

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
         * Specifies the title of the {@link Hopper}.
         *
         * @param title the title
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the title is {@code null}.
         * @since 1.0
         * @vision.apiNote After the {@link Gui} is built, the title cannot be changed, so it
         * must be specified before the {@link Gui} is built
         */
        @Override
        Builder title(Component title);

        /**
         * Sets the {@link Button} at the specified {@link Slot} of the {@link Hopper}.
         *
         * @param slot the slot
         * @param button the button
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the slot or button is {@code null}.
         * @since 1.0
         */
        @Override
        Builder button(Slot slot, Button button);

        /**
         * Builds the {@link Hopper}.
         *
         * @return the built {@link Hopper}
         * @throws IllegalStateException if any of the buttons are out of bounds.
         * @since 1.0
         */
        @Override
        Hopper build();
    }
}

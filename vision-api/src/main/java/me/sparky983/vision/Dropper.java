package me.sparky983.vision;

import net.kyori.adventure.text.Component;

import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

/**
 * Represents the {@link Dropper} variant of a {@link Gui}.
 *
 * @see #dropper()
 * @since 1.0
 * @vision.examples <pre>
 *Gui gui = Gui.dropper()
 *        .title(Component.text("My GUI"))
 *        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
 *        .build();
 *</pre>
 */
@NullMarked
non-sealed public interface Dropper extends Gui {

    /**
     * A {@link Dropper} builder.
     *
     * @see #dropper()
     * @since 1.0
     * @vision.examples <pre>
     *Gui gui = Gui.dropper()
     *        .title(Component.text("My GUI"))
     *        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     */
    interface Builder extends Gui.Builder {

        /**
         * Specifies the title of the {@link Dropper}.
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
         * Sets the {@link Button} at the specified {@link Slot} of the {@link Dropper}.
         *
         * @since 1.0
         */
        @Override
        Builder button(Slot slot, Button button);

        /**
         * Builds the {@link Dropper}.
         *
         * @return the built {@link Dropper}
         * @throws IllegalStateException if any of the buttons are out of bounds.
         * @since 1.0
         */
        @Override
        Dropper build();
    }
}
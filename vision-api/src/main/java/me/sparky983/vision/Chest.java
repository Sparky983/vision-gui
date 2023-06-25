package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;

/**
 * Represents the {@link Chest} variant of a {@link Gui}.
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
         * Specifies the number of rows in the {@link Chest}.
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
         * Specifies the title of the {@link Chest}.
         *
         * @param title the title
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the title is {@code null}.
         * @since 1.0
         * @vision.apiNote After the {@link Chest} is built, the title cannot be changed, so it
         * must be specified before the {@link Chest} is built
         */
        @Override
        Builder title(Component title);

        /**
         * Sets the {@link Button} at the specified {@link Slot} of the {@link Chest}.
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
         * Builds the {@link Chest}.
         *
         * @return the built {@link Chest}
         * @throws IllegalStateException if any of the buttons are out of bounds.
         * @since 1.0
         */
        @Override
        Chest build();
    }
}

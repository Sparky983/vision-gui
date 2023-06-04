package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;

/**
 * Represents the clicking of a {@link Button}.
 *
 * @see Button#click(Click)
 */
@NullMarked
public interface Click {

    /**
     * Creates a new {@code Click} with the specified clicker, button, slot and type.
     *
     * @param clicker the audience who clicked the {@link Button}
     * @param button the {@link Button} that was clicked
     * @param slot the {@link Slot} that was clicked
     * @param type the type of this click
     * @return the new {@code Click}.
     * @throws NullPointerException if the clicker, button, slot or type is {@code null}.
     * @since 0.1
     * @vision.experimental because this become internal in the future.
     */
    @ApiStatus.Experimental
    static Click of(final Audience clicker, final Button button, final Slot slot, final Type type) {

        return new ClickImpl(clicker, button, slot, type);
    }

    /**
     * Gets the {@code Audience} who clicked the {@link Button}.
     *
     * @return the {@code Audience} who clicked the {@link Button}
     * @since 0.1
     */
    Audience clicker();

    /**
     * Gets the {@link Button} that was clicked.
     *
     * @return the {@link Button} that was clicked
     * @since 0.1
     */
    Button button();

    /**
     * Gets the {@link Slot} that was clicked.
     *
     * @return the {@link Slot} that was clicked
     * @since 0.1
     */
    Slot slot();

    /**
     * Gets the {@code Type} of this click.
     *
     * @return the {@code Type} of this click
     * @since 0.1
     */
    Type type();

    /**
     * Represents the type of {@link Click}.
     *
     * @since 0.1
     */
    enum Type {

        /**
         * Represents a left click.
         *
         * @since 0.1
         */
        LEFT,

        /**
         * Represents a shift left click.
         *
         * @since 0.1
         */
        SHIFT_LEFT,

        /**
         * Represents a right click.
         *
         * @since 0.1
         */
        RIGHT,

        /**
         * Represents a shift right click.
         *
         * @since 0.1
         */
        SHIFT_RIGHT,

        /**
         * Represents a middle click, or "scroll click".
         *
         * @since 0.1
         */
        MIDDLE,

        /**
         * Represents a drop click.
         *
         * @since 0.1
         */
        DROP,

        /**
         * Represents a control drop click.
         *
         * @since 0.1
         */
        CONTROL_DROP,

        /**
         * Represents a double click.
         *
         * @since 0.1
         */
        DOUBLE_CLICK,

        /**
         * Represents a number key click.
         *
         * @since 0.1
         */
        NUMBER_KEY;

        /**
         * Checks whether this click is a left click ({@link #LEFT}, or {@link #SHIFT_LEFT}.
         *
         * @return whether click is a left click
         * @since 0.1
         */
        public boolean isLeft() {

            return switch(this) {
                case LEFT, SHIFT_LEFT -> true;
                default -> false;
            };
        }

        /**
         * Checks whether this click is a right click ({@link #RIGHT}, or {@link #SHIFT_RIGHT}.
         *
         * @return whether click is a right click
         * @since 0.1
         */
        public boolean isRight() {

            return switch (this) {
                case RIGHT, SHIFT_RIGHT -> true;
                default -> false;
            };
        }

        /**
         * Checks whether this click is a shift click ({@link #SHIFT_LEFT}, or {@link #SHIFT_RIGHT}.
         *
         * @return whether click is a shift click
         * @since 0.1
         */
        public boolean isShift() {

            return switch (this) {
                case SHIFT_LEFT, SHIFT_RIGHT -> true;
                default -> false;
            };
        }

        /**
         * Checks whether this click is a drop click ({@link #DROP}, or {@link #CONTROL_DROP}.
         *
         * @return whether click is a drop click
         * @since 0.1
         */
        public boolean isDrop() {

            return switch (this) {
                case DROP, CONTROL_DROP -> true;
                default -> false;
            };
        }
    }
}

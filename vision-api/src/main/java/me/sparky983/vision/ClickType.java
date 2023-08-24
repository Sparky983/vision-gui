package me.sparky983.vision;

/**
 * Represents the type of {@link Click}.
 *
 * @since 0.1
 */
public enum ClickType {
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
        return switch (this) {
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

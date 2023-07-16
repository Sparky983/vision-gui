package me.sparky983.vision;

import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;

import java.util.Set;

/**
 * Represents a {@link Gui} border.
 *
 * @since 1.0
 */
@ApiStatus.Experimental
@NullMarked
public enum Border {

    /**
     * The top border.
     * <p>
     * This border covers all slots in the topmost row.
     *
     * @since 1.0
     */
    TOP,

    /**
     * The bottom border.
     * <p>
     * This border covers all slots in the bottom-most row.
     *
     * @since 1.0
     */
    BOTTOM,

    /**
     * The left border.
     * <p>
     * This border covers all slots in the leftmost column.
     *
     * @since 1.0
     */
    LEFT,

    /**
     * The right border.
     * <p>
     * This border covers all slots in the rightmost column.
     *
     * @since 1.0
     */
    RIGHT;

    private static final Set<Border> ALL = Set.of(Border.values());

    /**
     * Returns a set containing all {@link Border Borders}.
     *
     * @return a set containing all {@link Border Borders}
     * @since 1.0
     */
    // TODO(Sparky983): Does this really need to be public? Users shouldn't need to use this because
    //  of Gui.Builder.border(Button).
    public static Set<Border> all() {

        return ALL;
    }
}

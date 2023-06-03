package me.sparky983.vision;

import org.jspecify.nullness.NullMarked;

/**
 * Represents a slot inside a {@link Gui}.
 *
 * @since 0.1
 */
@NullMarked
public record Slot(int row, int column) {

    /**
     * Creates a new slot.
     *
     * @param row the row of the slot
     * @param column the column of the slot
     * @throws IllegalArgumentException if either the row is less than 0 or greater than 5 or
     * column is less than 0 or greater than 8
     * @see #of(int, int)
     * @since 0.1
     */
    public Slot {

        if (row < 0 || row >= Gui.MAX_ROWS) {

            throw new IllegalArgumentException("row must be between 0 and 5");
        }

        if (column < 0 || column >= Gui.COLUMNS) {

            throw new IllegalArgumentException("column must be between 0 and 8");
        }
    }

    /**
     * Creates a new slot.
     *
     * @param row the row of the slot
     * @param column the column of the slot
     * @return the newly created slot
     * @throws IllegalArgumentException if either the row is less than 0 or greater than 5 or
     * column is less than 0 or greater than 8
     * @see #Slot(int, int)
     * @since 0.1
     */
    public static Slot of(final int row, final int column) {

        return new Slot(row, column);
    }
}

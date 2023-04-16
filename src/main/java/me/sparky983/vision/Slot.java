package me.sparky983.vision;

/**
 * Represents a slot inside a {@link Gui}.
 */
public record Slot(int column, int row) {

    /**
     * Creates a new slot.
     *
     * @param column the column of the slot
     * @param row the row of the slot
     * @throws IllegalArgumentException if either the column is less than 0 or greater than 8
     * or the row is less than 0 or greater than 5
     * @see #of(int, int)
     * @since 0.1
     */
    public Slot {

        if (column < 0 || column > 8) {

            throw new IllegalArgumentException("Column must be between 0 and 8");
        }

        if (row < 0 || row > 5) {

            throw new IllegalArgumentException("Row must be between 0 and 5");
        }
    }

    /**
     * Creates a new slot.
     *
     * @param column the column of the slot
     * @param row the row of the slot
     * @return the newly created slot
     * @throws IllegalArgumentException if either the column is less than 0 or greater than 8
     * or the row is less than 0 or greater than 5
     * @see #Slot(int, int)
     * @since 0.1
     */
    public static Slot of(int column, int row) {

        return new Slot(column, row);
    }
}

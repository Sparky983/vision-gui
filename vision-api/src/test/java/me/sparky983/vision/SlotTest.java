package me.sparky983.vision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlotTest {

    @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
    @ParameterizedTest
    void testNewSlotWhenColumnIsLessThanZero(final int column) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> new Slot(column, 0));

        assertEquals("Column must be between 0 and 8", e.getMessage());
    }

    @ValueSource(ints = {9, 10, Integer.MAX_VALUE})
    @ParameterizedTest
    void testNewSlotWhenColumnIsGreaterThanEight(final int column) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> new Slot(column, 0));

        assertEquals("Column must be between 0 and 8", e.getMessage());
    }

    @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
    void testNewSlotWhenRowIsLessThanZero(final int row) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> new Slot(0, row));

        assertEquals("Slot must be between 0 and 5", e.getMessage());
    }

    @ValueSource(ints = {6, 10, Integer.MAX_VALUE})
    @ParameterizedTest
    void testNewSlotWhenRowIsGreaterThanFive(final int row) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> new Slot(0, row));

        assertEquals("Slot must be between 0 and 5", e.getMessage());
    }

    @Test
    void testNewSlot() {

        {
            final Slot slot = new Slot(0, 0);
            assertEquals(0, slot.column());
            assertEquals(0, slot.row());
        }
        {
            final Slot slot = new Slot(8, 5);
            assertEquals(8, slot.column());
            assertEquals(5, slot.row());
        }
    }

    @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
    @ParameterizedTest
    void testSlotOfWhenColumnIsLessThanZero(final int column) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> Slot.of(column, 0));

        assertEquals("Column must be between 0 and 8", e.getMessage());
    }

    @ValueSource(ints = {9, 10, Integer.MAX_VALUE})
    @ParameterizedTest
    void testSlotOfWhenColumnIsGreaterThanEight(final int column) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> Slot.of(column, 0));

        assertEquals("Column must be between 0 and 8", e.getMessage());
    }

    @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
    void testSlotOfWhenRowIsLessThanZero(final int row) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> Slot.of(0, row));

        assertEquals("Slot must be between 0 and 5", e.getMessage());
    }

    @ValueSource(ints = {6, 10, Integer.MAX_VALUE})
    @ParameterizedTest
    void testSlotOfWhenRowIsGreaterThanFive(final int row) {

        final Exception e =
                assertThrows(IllegalArgumentException.class, () -> Slot.of(0, row));

        assertEquals("Slot must be between 0 and 5", e.getMessage());
    }

    @Test
    void testSlotOf() {

        {
            final Slot slot = Slot.of(0, 0);
            assertEquals(0, slot.column());
            assertEquals(0, slot.row());
        }
        {
            final Slot slot = Slot.of(8, 5);
            assertEquals(8, slot.column());
            assertEquals(5, slot.row());
        }
    }
}

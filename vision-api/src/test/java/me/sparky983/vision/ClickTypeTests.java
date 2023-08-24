package me.sparky983.vision;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClickTypeTests {
    @ValueSource(strings = {"LEFT", "SHIFT_LEFT"})
    @ParameterizedTest
    void testIsLeftWhenTypeIsLeft(final ClickType type) {
        assertTrue(type.isLeft());
    }

    @ValueSource(strings = {
            "RIGHT",
            "SHIFT_RIGHT",
            "MIDDLE",
            "DROP",
            "CONTROL_DROP",
            "DOUBLE_CLICK",
            "NUMBER_KEY"
    })
    @ParameterizedTest
    void testIsLeftWhenTypeIsNotLeft(final ClickType type) {
        assertFalse(type.isLeft());
    }

    @ValueSource(strings = {"RIGHT", "SHIFT_RIGHT"})
    @ParameterizedTest
    void testIsRightWhenTypeIsRight(final ClickType type) {
        assertTrue(type.isRight());
    }

    @ValueSource(strings = {
            "LEFT",
            "SHIFT_LEFT",
            "MIDDLE",
            "DROP",
            "CONTROL_DROP",
            "DOUBLE_CLICK",
            "NUMBER_KEY"
    })
    @ParameterizedTest
    void testIsRightWhenTypeIsNotRight(final ClickType type) {
        assertFalse(type.isRight());
    }

    @ValueSource(strings = {"SHIFT_LEFT", "SHIFT_RIGHT"})
    @ParameterizedTest
    void testIsShiftWhenTypeIsShift(final ClickType type) {
        assertTrue(type.isShift());
    }

    @ValueSource(strings = {
            "LEFT",
            "RIGHT",
            "MIDDLE",
            "DROP",
            "CONTROL_DROP",
            "DOUBLE_CLICK",
            "NUMBER_KEY"
    })
    @ParameterizedTest
    void testIsShiftWhenTypeIsNotShift(final ClickType type) {
        assertFalse(type.isShift());
    }

    @ValueSource(strings = {"DROP", "CONTROL_DROP"})
    @ParameterizedTest
    void testIsDropWhenTypeIsDrop(final ClickType type) {
        assertTrue(type.isDrop());
    }

    @ValueSource(strings = {
            "LEFT",
            "RIGHT",
            "SHIFT_LEFT",
            "SHIFT_RIGHT",
            "MIDDLE",
            "DOUBLE_CLICK",
            "NUMBER_KEY"
    })
    @ParameterizedTest
    void testIsDropWhenTypeIsNotDrop(final ClickType type) {
        assertFalse(type.isDrop());
    }
}

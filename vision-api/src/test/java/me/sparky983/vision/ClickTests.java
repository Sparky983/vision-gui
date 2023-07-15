package me.sparky983.vision;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClickTests {

    @Nested
    class TypeTests {

        @ValueSource(strings = {"LEFT", "SHIFT_LEFT"})
        @ParameterizedTest
        void testIsLeftWhenTypeIsLeft(final Click.Type type) {

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
        void testIsLeftWhenTypeIsNotLeft(final Click.Type type) {

            assertFalse(type.isLeft());
        }

        @ValueSource(strings = {"RIGHT", "SHIFT_RIGHT"})
        @ParameterizedTest
        void testIsRightWhenTypeIsRight(final Click.Type type) {

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
        void testIsRightWhenTypeIsNotRight(final Click.Type type) {

            assertFalse(type.isRight());
        }

        @ValueSource(strings = {"SHIFT_LEFT", "SHIFT_RIGHT"})
        @ParameterizedTest
        void testIsShiftWhenTypeIsShift(final Click.Type type) {

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
        void testIsShiftWhenTypeIsNotShift(final Click.Type type) {

            assertFalse(type.isShift());
        }

        @ValueSource(strings = {"DROP", "CONTROL_DROP"})
        @ParameterizedTest
        void testIsDropWhenTypeIsDrop(final Click.Type type) {

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
        void testIsDropWhenTypeIsNotDrop(final Click.Type type) {

            assertFalse(type.isDrop());
        }
    }
}

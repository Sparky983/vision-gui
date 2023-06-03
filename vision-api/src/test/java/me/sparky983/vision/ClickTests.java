package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClickTests {

    /**
     * A clicker to be used for testing.
     */
    static final Audience CLICKER = Audience.empty();


    /**
     * A button to be used for testing.
     */
    static final Button BUTTON = Button.of(ItemType.STONE);

    /**
     * A slot to be used for testing.
     */
    static final Slot SLOT = Slot.of(0, 0);
    /**
     * A type to be used for testing.
     */
    static final Click.Type TYPE = Click.Type.LEFT;

    @Test
    void testClickOfWhenClickerIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                Click.of(null, BUTTON, SLOT, TYPE));

        assertEquals("clicker cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testClickOfWhenButtonIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                Click.of(CLICKER, null, SLOT, TYPE));

        assertEquals("button cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testClickOfWhenSlotIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                Click.of(CLICKER, BUTTON, null, TYPE));

        assertEquals("slot cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testClickOfWhenTypeIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                Click.of(CLICKER, BUTTON, SLOT, null));

        assertEquals("type cannot be null", e.getMessage());
    }

    @Test
    void testClickOf() {

        final Click click = Click.of(CLICKER, BUTTON, SLOT, TYPE);

        assertEquals(CLICKER, click.clicker());
        assertEquals(BUTTON, click.button());
        assertEquals(SLOT, click.slot());
        assertEquals(TYPE, click.type());
    }

    @Nested
    class TypeTests {

        @ValueSource(strings = {"LEFT", "SHIFT_LEFT"})
        @ParameterizedTest
        void testIsLeftWhenTypeIsLeft(final Click.Type type) {

            assertTrue(Click.Type.LEFT.isLeft());
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

            assertFalse(Click.Type.LEFT.isLeft());
        }

        @ValueSource(strings = {"RIGHT", "SHIFT_RIGHT"})
        @ParameterizedTest
        void testIsRightWhenTypeIsRight(final Click.Type type) {

            assertTrue(Click.Type.RIGHT.isRight());
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

            assertFalse(Click.Type.RIGHT.isRight());
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

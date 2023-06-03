package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClickTest {

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
}

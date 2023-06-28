package me.sparky983.vision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

class DropperTest {

    /**
     * A slot to be used for testing.
     */
    static final Slot SLOT = Slot.of(0, 0);

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderTitleWhenTitleIsNull() {

        final Gui.Builder builder = Gui.dropper();

        final Exception e = assertThrows(NullPointerException.class, () -> builder.title(null));
        assertEquals("title cannot be null", e.getMessage());
    }

    @Test
    void testBuilderTitle() {

        final Gui.Builder builder = Gui.dropper();

        assertEquals(builder, builder.title(Component.empty()));

        final Gui gui = builder.build();

        assertEquals(Component.empty(), gui.title());
    }

    @Test
    void testUnspecifiedTitle() {

        final Gui gui = Gui.dropper().build();

        assertEquals(DropperImpl.DEFAULT_TITLE, gui.title());
    }

    @Test
    void testColumns() {

        final Gui gui = Gui.dropper().build();

        assertEquals(Dropper.COLUMNS, gui.columns());
    }

    @Test
    void testRows() {

        final Gui gui = Gui.dropper().build();

        assertEquals(Dropper.ROWS, gui.rows());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderButtonWhenSlotIsNull() {

        final Gui.Builder builder = Gui.dropper();

        final Exception e = assertThrows(NullPointerException.class, () ->
                builder.button(null, Button.of(ItemType.STONE)));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderButtonWhenButtonIsNull() {

        final Gui.Builder builder = Gui.dropper();

        final Exception e = assertThrows(NullPointerException.class, () ->
                builder.button(SLOT, null));
        assertEquals("button cannot be null", e.getMessage());
    }

    @CsvSource({
            "0, 5",
            "1, 0",
            "1, 2",
            "1, 4"
    })
    @ParameterizedTest
    void testBuilderButtonWhenSlotIsOutOfBounds(final int row, final int column) {

        final Slot slot = Slot.of(row, column);
        final Gui.Builder builder = Gui.dropper()
                .button(slot, Button.of(ItemType.STONE));

        final Exception e = assertThrows(IllegalStateException.class, builder::build);
        assertEquals(DropperImpl.SLOT_OUT_OF_BOUNDS.formatted(slot), e.getMessage());
    }

    @Test
    void testBuilderButton() {

        final Gui.Builder builder = Gui.dropper();
        final Button button = Button.of(ItemType.STONE);

        assertEquals(builder, builder.button(SLOT, button));

        final Gui gui = builder.build();

        assertEquals(Optional.of(button), gui.button(SLOT));
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSetButtonWhenSlotIsNull() {

        final Gui gui = Gui.dropper().build();

        final Exception e = assertThrows(NullPointerException.class, () ->
                gui.button(null, Button.of(ItemType.STONE)));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @Test
    void testSetButtonWhenButtonIsNull() {

        final Gui gui = Gui.dropper().build();

        gui.button(SLOT, Button.of(ItemType.STONE));

        assertTrue(gui.button(SLOT).isPresent());

        gui.button(SLOT, null);

        assertEquals(Optional.empty(), gui.button(SLOT));
    }

    @CsvSource({
            "0, 5",
            "1, 0",
            "1, 2",
            "1, 4"
    })
    @ParameterizedTest
    void testSetButtonWhenSlotIsOutOfBounds(final int row, final int column) {

        final Slot slot = Slot.of(row, column);
        final Gui gui = Gui.dropper().build();
        final Button button = Button.of(ItemType.STONE);

        final Exception e = assertThrows(IllegalArgumentException.class, () ->
                gui.button(slot, button));
        assertEquals(DropperImpl.SLOT_OUT_OF_BOUNDS.formatted(slot), e.getMessage());
    }

    @Test
    void testSetButton() {

        final Gui gui = Gui.dropper().build();
        final Button button = Button.of(ItemType.STONE);

        assertEquals(gui, gui.button(SLOT, button));

        assertEquals(Optional.of(button), gui.button(SLOT));
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testGetButtonWhenSlotIsNull() {

        final Gui gui = Gui.dropper().build();

        final Exception e = assertThrows(NullPointerException.class, () -> gui.button(null));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @CsvSource({
            "0, 5",
            "1, 0",
            "1, 2",
            "1, 4"
    })
    @ParameterizedTest
    void testGetButtonWhenSlotIsOutOfBounds(final int row, final int column) {

        final Slot slot = Slot.of(row, column);
        final Gui gui = Gui.dropper().build();

        final Exception e = assertThrows(IllegalArgumentException.class, () -> gui.button(slot));
        assertEquals(DropperImpl.SLOT_OUT_OF_BOUNDS.formatted(slot), e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSubscribeWhenSubscriberIsNull() {

        final Gui gui = Gui.dropper().build();

        final Exception e = assertThrows(NullPointerException.class, () -> gui.subscribe(null));
        assertEquals("subscriber cannot be null", e.getMessage());
    }

    @Test
    void testSubscribe() {

        final Gui gui = Gui.dropper().build();
        final Gui.Subscriber subscriber = mock();
        final Button button = Button.of(ItemType.STONE);

        gui.subscribe(subscriber);

        gui.button(SLOT, button);
        verify(subscriber).button(SLOT, button);
        verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testSubscriberThrowsException() {

        final Gui gui = Gui.dropper().build();
        final Gui.Subscriber subscriber = mock();
        final Button button = Button.of(ItemType.STONE);
        final RuntimeException e = new RuntimeException();

        gui.subscribe(subscriber);

        doThrow(e).when(subscriber).button(SLOT, button);
        gui.button(SLOT, button);

        verify(subscriber).button(SLOT, button);
        verify(subscriber).exception(e);
        verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testCancelSubscription() {

        final Gui gui = Gui.dropper().build();
        final Gui.Subscriber subscriber = mock();
        final Button button = Button.of(ItemType.STONE);

        final Subscription subscription = gui.subscribe(subscriber);

        assertFalse(subscription.isCancelled());

        subscription.cancel();

        gui.button(SLOT, button);

        assertTrue(subscription.isCancelled());
        verifyNoMoreInteractions(subscriber);
    }
}

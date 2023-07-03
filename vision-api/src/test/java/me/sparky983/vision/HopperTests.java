package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static me.sparky983.vision.Container.SLOT_OUT_OF_BOUNDS;
import static me.sparky983.vision.Hopper.COLUMNS;
import static me.sparky983.vision.Hopper.ROWS;
import static me.sparky983.vision.HopperImpl.DEFAULT_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class HopperTests {

    /**
     * A slot to be used for testing.
     */
    static final Slot SLOT = Slot.of(0, 0);

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderTitleWhenTitleIsNull() {

        final Gui.Builder builder = Gui.hopper();

        final Exception e = assertThrows(NullPointerException.class, () -> builder.title(null));
        assertEquals("title cannot be null", e.getMessage());
    }

    @Test
    void testBuilderTitle() {

        final Gui.Builder builder = Gui.hopper();

        assertEquals(builder, builder.title(Component.empty()));

        final Gui gui = builder.build();

        assertEquals(Component.empty(), gui.title());
    }

    @Test
    void testUnspecifiedTitle() {

        final Gui gui = Gui.hopper().build();

        assertEquals(DEFAULT_TITLE, gui.title());
    }

    @Test
    void testColumns() {

        final Gui gui = Gui.hopper().build();

        assertEquals(COLUMNS, gui.columns());
    }

    @Test
    void testRows() {

        final Gui gui = Gui.hopper().build();

        assertEquals(ROWS, gui.rows());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderButtonWhenSlotIsNull() {

        final Gui.Builder builder = Gui.hopper();
        final Button button = Button.of(ItemType.STONE);

        final Exception e = assertThrows(NullPointerException.class, () ->
                builder.button(null, button));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderButtonWhenButtonIsNull() {

        final Gui.Builder builder = Gui.hopper();

        final Exception e = assertThrows(NullPointerException.class, () ->
                builder.button(SLOT, null));
        assertEquals("button cannot be null", e.getMessage());
    }

    @CsvSource({
            "2, 3",
            "3, 3",
            "3, 2",
            "3, 3"
    })
    @ParameterizedTest
    void testBuilderButtonWhenSlotIsOutOfBounds(final int row, final int column) {

        final Slot slot = Slot.of(row, column);
        final Gui.Builder builder = Gui.hopper()
                .button(slot, Button.of(ItemType.STONE));

        final Exception e = assertThrows(IllegalStateException.class, builder::build);
        assertEquals(
                String.format(SLOT_OUT_OF_BOUNDS, slot.row(), slot.column(), ROWS, COLUMNS),
                e.getMessage());
    }

    @Test
    void testBuilderButton() {

        final Gui.Builder builder = Gui.hopper();
        final Button button = Button.of(ItemType.STONE);

        assertEquals(builder, builder.button(SLOT, button));

        final Gui gui = builder.build();

        assertEquals(Optional.of(button), gui.button(SLOT));
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSetButtonWhenSlotIsNull() {

        final Gui gui = Gui.hopper().build();
        final Button button = Button.of(ItemType.STONE);

        final Exception e = assertThrows(NullPointerException.class, () ->
                gui.button(null, button));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @Test
    void testSetButtonWhenButtonIsNull() {

        final Gui gui = Gui.hopper().build();

        gui.button(SLOT, Button.of(ItemType.STONE));

        assertTrue(gui.button(SLOT).isPresent());

        gui.button(SLOT, null);

        assertEquals(Optional.empty(), gui.button(SLOT));
    }

    @CsvSource({
            "2, 3",
            "3, 3",
            "3, 2",
            "3, 3"
    })
    @ParameterizedTest
    void testSetButtonWhenSlotIsOutOfBounds(final int row, final int column) {

        final Slot slot = Slot.of(row, column);
        final Gui gui = Gui.hopper().build();
        final Button button = Button.of(ItemType.STONE);

        final Exception e = assertThrows(IllegalArgumentException.class, () ->
                gui.button(slot, button));
        assertEquals(
                String.format(SLOT_OUT_OF_BOUNDS, slot.row(), slot.column(), ROWS, COLUMNS),
                e.getMessage());
    }

    @Test
    void testSetButton() {

        final Gui gui = Gui.hopper().build();
        final Button button = Button.of(ItemType.STONE);

        assertEquals(gui, gui.button(SLOT, button));

        assertEquals(Optional.of(button), gui.button(SLOT));
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testGetButtonWhenSlotIsNull() {

        final Gui gui = Gui.hopper().build();

        final Exception e = assertThrows(NullPointerException.class, () -> gui.button(null));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @CsvSource({
            "2, 3",
            "3, 3",
            "3, 2",
            "3, 3"
    })
    @ParameterizedTest
    void testGetButtonWhenSlotIsOutOfBounds(final int row, final int column) {

        final Slot slot = Slot.of(row, column);
        final Gui gui = Gui.hopper().build();

        final Exception e = assertThrows(IllegalArgumentException.class, () -> gui.button(slot));
        assertEquals(
                String.format(SLOT_OUT_OF_BOUNDS, slot.row(), slot.column(), ROWS, COLUMNS),
                e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSubscribeWhenSubscriberIsNull() {

        final Gui gui = Gui.hopper().build();

        final Exception e = assertThrows(NullPointerException.class, () -> gui.subscribe(null));
        assertEquals("subscriber cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderFillWhenButtonIsNull() {

        final Gui.Builder builder = Gui.hopper();

        assertThrows(NullPointerException.class, () -> builder.fill(null));
    }

    @Test
    void testBuilderFill() {

        final Gui.Builder builder = Gui.hopper()
                .button(Slot.of(0, 2), Button.of(ItemType.STONE));
        final Button button = Button.of(ItemType.STONE);

        assertEquals(builder, builder.fill(button));

        final Gui gui = builder.build();

        for (int row = 0; row < gui.rows(); row++) {
            for (int column = 0; column < gui.columns(); column++) {
                assertEquals(Optional.of(button), gui.button(Slot.of(row, column)));
            }
        }
    }

    @Test
    void testType() {

        final Gui gui = Gui.hopper().build();

        assertEquals(GuiType.HOPPER, gui.type());
    }

    @Test
    void testSubscribe() {

        final Gui gui = Gui.hopper().build();
        final Gui.Subscriber subscriber = mock();
        final Button button = Button.of(ItemType.STONE);

        gui.subscribe(subscriber);

        gui.button(SLOT, button);
        verify(subscriber).button(SLOT, button);
        verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testSubscriberThrowsException() {

        final Gui gui = Gui.hopper().build();
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

        final Gui gui = Gui.hopper().build();
        final Gui.Subscriber subscriber = mock();
        final Button button = Button.of(ItemType.STONE);

        final Subscription subscription = gui.subscribe(subscriber);

        assertFalse(subscription.isCancelled());

        subscription.cancel();

        gui.button(SLOT, button);

        assertTrue(subscription.isCancelled());
        verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testToString() {

        final Gui gui = Gui.hopper()
                .title(Component.text("title"))
                .build();

        assertEquals(
                String.format("HopperImpl[title=%s]", Component.text("title")), gui.toString());
    }
}

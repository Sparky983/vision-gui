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
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

@Nested
class ChestTests {

    /**
     * A slot to be used for testing.
     */
    static final Slot SLOT = Slot.of(0, 0);

    @SuppressWarnings("ConstantConditions")
    @Test
    void testBuilderTitleWhenTitleIsNull() {

        final Gui.Builder builder = Gui.chest();

        final Exception e = assertThrows(NullPointerException.class, () -> builder.title(null));
        assertEquals("title cannot be null", e.getMessage());
    }

    @Test
    void testBuilderTitle() {

        final Gui.Builder builder = Gui.chest();

        assertEquals(builder, builder.title(Component.empty()));

        final Gui gui = builder.build();

        assertEquals(Component.empty(), gui.title());
    }

    @Test
    void testUnspecifiedTitle() {

        final Gui gui = Gui.chest().build();

        assertEquals(ChestImpl.DEFAULT_TITLE, gui.title());
    }

    @Test
    void testColumns() {

        final Gui gui = Gui.chest().build();

        assertEquals(Chest.COLUMNS, gui.columns());
    }

    @ValueSource(ints = {Integer.MIN_VALUE, 0, -1, 7, 8, Integer.MAX_VALUE})
    @ParameterizedTest
    void testBuilderRowsWhenRowsIsOutOfBounds(final int rows) {

        final Chest.Builder builder = Gui.chest();

        final Exception e = assertThrows(IllegalArgumentException.class, () -> builder.rows(rows));
        assertEquals("rows must be between 1 and " + Chest.MAX_ROWS, e.getMessage());
    }

    @ValueSource(ints = {1, 2, 4, 5, 6})
    @ParameterizedTest
    void testBuilderRows(final int rows) {

        final Chest.Builder builder = Gui.chest();

        assertEquals(builder, builder.rows(rows));

        final Gui gui = builder.build();

        assertEquals(rows, gui.rows());
    }

    @Test
    void testUnspecifiedRows() {

        final Gui gui = Gui.chest().build();

        assertEquals(ChestImpl.DEFAULT_ROWS, gui.rows());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderButtonWhenSlotIsNull() {

        final Gui.Builder builder = Gui.chest();

        final Exception e = assertThrows(NullPointerException.class, () ->
                builder.button(null, Button.of(ItemType.STONE)));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testBuilderButtonWhenButtonIsNull() {

        final Gui.Builder builder = Gui.chest();

        final Exception e = assertThrows(NullPointerException.class, () ->
                builder.button(SLOT, null));
        assertEquals("button cannot be null", e.getMessage());
    }

    @CsvSource({
            "1, 0, 1",
            "1, 8, 1",
            "5, 0, 5",
            "5, 8, 5"
    })
    @ParameterizedTest
    void testBuilderButtonWhenSlotIsOutOfBounds(final int slotRow,
                                                final int slotColumn,
                                                final int guiRows) {

        final Slot slot = Slot.of(slotRow, slotColumn);
        final Gui.Builder builder = Gui.chest()
                .rows(guiRows)
                .button(slot, Button.of(ItemType.STONE));

        final Exception e = assertThrows(IllegalStateException.class, builder::build);
        assertEquals(
                Container.SLOT_OUT_OF_BOUNDS
                        .formatted(slotRow, slotColumn, guiRows, Chest.COLUMNS),
                e.getMessage());
    }

    @Test
    void testBuilderButton() {

        final Gui.Builder builder = Gui.chest();
        final Button button = Button.of(ItemType.STONE);

        assertEquals(builder, builder.button(SLOT, button));

        final Gui gui = builder.build();

        assertEquals(Optional.of(button), gui.button(SLOT));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testSetButtonWhenSlotIsNull() {

        final Gui gui = Gui.chest().build();

        final Exception e = assertThrows(NullPointerException.class, () ->
                gui.button(null, Button.of(ItemType.STONE)));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @Test
    void testSetButtonWhenButtonIsNull() {

        final Gui gui = Gui.chest().build();

        gui.button(SLOT, Button.of(ItemType.STONE));

        assertTrue(gui.button(SLOT).isPresent());

        gui.button(SLOT, null);

        assertEquals(Optional.empty(), gui.button(SLOT));
    }

    @CsvSource({
            "1, 0, 1",
            "1, 8, 1",
            "5, 0, 5",
            "5, 8, 5"
    })
    @ParameterizedTest
    void testSetButtonWhenSlotIsOutOfBounds(final int slotRow,
                                            final int slotColumn,
                                            final int guiRows) {

        final Gui gui = Gui.chest()
                .rows(guiRows)
                .build();
        final Slot slot = Slot.of(slotRow, slotColumn);
        final Button button = Button.of(ItemType.STONE);

        final Exception e = assertThrows(IllegalArgumentException.class, () ->
                gui.button(slot, button));
        assertEquals(
                Container.SLOT_OUT_OF_BOUNDS
                        .formatted(slotRow, slotColumn, guiRows, Chest.COLUMNS),
                e.getMessage());
    }

    @Test
    void testSetButton() {

        final Gui gui = Gui.chest().build();
        final Button button = Button.of(ItemType.STONE);

        assertEquals(gui, gui.button(SLOT, button));

        assertEquals(Optional.of(button), gui.button(SLOT));
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testGetButtonWhenSlotIsNull() {

        final Gui gui = Gui.chest().build();

        final Exception e = assertThrows(NullPointerException.class, () -> gui.button(null));
        assertEquals("slot cannot be null", e.getMessage());
    }

    @CsvSource({
            "1, 0, 1",
            "1, 8, 1",
            "5, 0, 5",
            "5, 8, 5"
    })
    @ParameterizedTest
    void testGetButtonWhenSlotIsOutOfBounds(final int slotRow,
                                            final int slotColumn,
                                            final int guiRows) {

        final Gui gui = Gui.chest()
                .rows(guiRows)
                .build();
        final Slot slot = Slot.of(slotRow, slotColumn);

        final Exception e = assertThrows(IllegalArgumentException.class, () -> gui.button(slot));
        assertEquals(
                Container.SLOT_OUT_OF_BOUNDS
                        .formatted(slotRow, slotColumn, guiRows, Chest.COLUMNS),
                e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSubscribeWhenSubscriberIsNull() {

        final Gui gui = Gui.chest().build();

        final Exception e = assertThrows(NullPointerException.class, () -> gui.subscribe(null));
        assertEquals("subscriber cannot be null", e.getMessage());
    }

    @Test
    void testSubscribe() {

        final Gui gui = Gui.chest().build();
        final Gui.Subscriber subscriber = mock();
        final Button button = Button.of(ItemType.STONE);

        gui.subscribe(subscriber);

        gui.button(SLOT, button);
        verify(subscriber).button(SLOT, button);
        verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testSubscriberThrowsException() {

        final Gui gui = Gui.chest().build();
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

        final Gui gui = Gui.chest().build();
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

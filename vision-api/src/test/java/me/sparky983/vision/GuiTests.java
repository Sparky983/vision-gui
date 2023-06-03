package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class GuiTests {

    /**
     * A component to be used for testing as a gui's name.
     */
    static final Component TITLE = Component.text("title");

    @Nested
    class Builder {

        @SuppressWarnings("ConstantConditions")
        @Test
        void testBuilderTitleWhenTitleIsNull() {

            final Gui.Builder builder = Gui.gui();

            final Exception e = assertThrows(NullPointerException.class, () -> builder.title(null));
            assertEquals("title cannot be null", e.getMessage());
        }

        @Test
        void testBuilderTitle() {

            final Gui.Builder builder = Gui.gui();

            assertEquals(builder, builder.title(TITLE));

            final Gui gui = builder.rows(1);

            assertEquals(TITLE, gui.title());
        }

        @Test
        void testUnspecifiedTitle() {

            final Gui gui = Gui.gui().rows(1);

            assertEquals(GuiImpl.DEFAULT_NAME, gui.title());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testButtonWhenSlotIsNull() {

            final Gui gui = Gui.gui().rows(1);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    gui.button(null, Button.of(ItemType.STONE)));
            assertEquals("slot cannot be null", e.getMessage());
        }

        @Test
        void testButtonWhenButtonIsNull() {

            final Gui gui = Gui.gui().rows(1);

            gui.button(Slot.of(0, 0), Button.of(ItemType.STONE));

            assertTrue(gui.button(Slot.of(0, 0)).isPresent());

            gui.button(Slot.of(0, 0), null);

            assertEquals(Optional.empty(), gui.button(Slot.of(0, 0)));
        }

        @CsvSource({
                "1, 0, 1",
                "1, 8, 1",
                "5, 0, 5",
                "5, 8, 5"
        })
        @ParameterizedTest
        void testButtonWhenSlotIsOutOfRange(final int slotRow,
                                            final int slotColumn,
                                            final int guiRows) {

            final Gui gui = Gui.gui().rows(guiRows);

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    gui.button(Slot.of(slotRow, slotColumn), Button.of(ItemType.STONE)));
            assertEquals("slot (" + slotRow + ", " + slotColumn + ") out of range for " +
                    guiRows + " rows", e.getMessage());
        }

        @Test
        void testButton() {

            final Gui gui = Gui.gui().rows(1);
            final Button button = Button.of(ItemType.STONE);

            assertEquals(gui, gui.button(Slot.of(0, 0), button));

            assertEquals(Optional.of(button), gui.button(Slot.of(0, 0)));
        }

        @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
        @ParameterizedTest
        void testBuilderRowsWhenRowsIsLessThan1(final int rows) {

            final Gui.Builder builder = Gui.gui();

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> builder.rows(rows));
            assertEquals("rows must be between 1 and 6", e.getMessage());
        }

        @ValueSource(ints = {7, 8, Integer.MAX_VALUE})
        @ParameterizedTest
        void testBuilderRowsWhenRowsIsGreaterThan6(final int rows) {

            final Gui.Builder builder = Gui.gui();

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> builder.rows(rows));
            assertEquals("rows must be between 1 and 6", e.getMessage());
        }

        @ValueSource(ints = {1, 2, 4, 5, 6})
        @ParameterizedTest
        void testBuilderRows(final int rows) {

            final Gui gui = Gui.gui().rows(rows);

            assertEquals(rows, gui.rows());
        }

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Gui gui = Gui.gui().rows(1);

            final Exception e = assertThrows(NullPointerException.class,
                    () -> gui.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Gui gui = Gui.gui().rows(1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            gui.subscribe(subscriber);

            gui.button(Slot.of(0, 0), button);
            verify(subscriber).button(Slot.of(0, 0), button);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testSubscriberThrowsException() {

            final Gui gui = Gui.gui().rows(1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);
            final RuntimeException e = new RuntimeException();

            gui.subscribe(subscriber);

            doThrow(e).when(subscriber).button(Slot.of(0, 0), button);
            gui.button(Slot.of(0, 0), button);

            verify(subscriber).button(Slot.of(0, 0), button);
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testCancelSubscription() {

            final Gui gui = Gui.gui().rows(1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            final Subscription subscription = gui.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            gui.button(Slot.of(0, 0), button);

            assertTrue(subscription.isCancelled());
            verifyNoMoreInteractions(subscriber);
        }
    }

    @Nested
    class GuiTitleAndRows {

        @Test
        void testGuiWhenTitleIsNull() {

            final Gui gui = Gui.gui(null, 1);

            assertEquals(GuiImpl.DEFAULT_NAME, gui.title());
        }

        @Test
        void testGuiTitle() {

            final Gui gui = Gui.gui(TITLE, 1);

            assertEquals(TITLE, gui.title());
        }

        @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
        @ParameterizedTest
        void testGuiWhenRowsIsLessThan1(final int rows) {

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> Gui.gui(null, rows));
            assertEquals("rows must be between 1 and 6", e.getMessage());
        }

        @ValueSource(ints = {7, 8, Integer.MAX_VALUE})
        @ParameterizedTest
        void testGuiWhenRowsIsGreaterThan6(final int rows) {

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> Gui.gui(null, rows));
            assertEquals("rows must be between 1 and 6", e.getMessage());
        }

        @ValueSource(ints = {1, 2, 4, 5, 6})
        @ParameterizedTest
        void testGuiRows(final int rows) {

            final Gui gui = Gui.gui(null, rows);

            assertEquals(rows, gui.rows());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testButtonWhenSlotIsNull() {

            final Gui gui = Gui.gui(null, 1);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    gui.button(null, Button.of(ItemType.STONE)));
            assertEquals("slot cannot be null", e.getMessage());
        }

        @Test
        void testButtonWhenButtonIsNull() {

            final Gui gui = Gui.gui(null, 1);

            gui.button(Slot.of(0, 0), Button.of(ItemType.STONE));

            assertTrue(gui.button(Slot.of(0, 0)).isPresent());

            gui.button(Slot.of(0, 0), null);

            assertEquals(Optional.empty(), gui.button(Slot.of(0, 0)));
        }

        @CsvSource({
                "1, 0, 1",
                "1, 8, 1",
                "5, 0, 5",
                "5, 8, 5"
        })
        @ParameterizedTest
        void testButtonWhenSlotIsOutOfRange(final int slotRow,
                                            final int slotColumn,
                                            final int guiRows) {

            final Gui gui = Gui.gui(null, guiRows);

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    gui.button(Slot.of(slotRow, slotColumn), Button.of(ItemType.STONE)));
            assertEquals("slot (" + slotRow + ", " + slotColumn + ") out of range for " +
                    guiRows + " rows", e.getMessage());
        }

        @Test
        void testButton() {

            final Gui gui = Gui.gui(null, 1);
            final Button button = Button.of(ItemType.STONE);

            assertEquals(gui, gui.button(Slot.of(0, 0), button));

            assertEquals(Optional.of(button), gui.button(Slot.of(0, 0)));
        }

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Gui gui = Gui.gui(null, 1);

            final Exception e = assertThrows(NullPointerException.class,
                    () -> gui.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Gui gui = Gui.gui(null, 1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            gui.subscribe(subscriber);

            gui.button(Slot.of(0, 0), button);
            verify(subscriber).button(Slot.of(0, 0), button);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testSubscriberThrowsException() {

            final Gui gui = Gui.gui(null, 1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);
            final RuntimeException e = new RuntimeException();

            gui.subscribe(subscriber);

            doThrow(e).when(subscriber).button(Slot.of(0, 0), button);
            gui.button(Slot.of(0, 0), button);

            verify(subscriber).button(Slot.of(0, 0), button);
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testCancelSubscription() {

            final Gui gui = Gui.gui(null, 1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            final Subscription subscription = gui.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            gui.button(Slot.of(0, 0), button);

            assertTrue(subscription.isCancelled());
            verifyNoMoreInteractions(subscriber);
        }
    }

    @Nested
    class GuiRows {

        @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
        @ParameterizedTest
        void testGuiWhenRowsIsLessThan1(final int rows) {

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> Gui.gui(rows));
            assertEquals("rows must be between 1 and 6", e.getMessage());
        }

        @ValueSource(ints = {7, 8, Integer.MAX_VALUE})
        @ParameterizedTest
        void testGuiWhenRowsIsGreaterThan6(final int rows) {

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> Gui.gui(rows));
            assertEquals("rows must be between 1 and 6", e.getMessage());
        }

        @ValueSource(ints = {1, 2, 4, 5, 6})
        @ParameterizedTest
        void testGuiRows(final int rows) {

            final Gui gui = Gui.gui(rows);

            assertEquals(rows, gui.rows());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testButtonWhenSlotIsNull() {

            final Gui gui = Gui.gui(1);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    gui.button(null, Button.of(ItemType.STONE)));
            assertEquals("slot cannot be null", e.getMessage());
        }

        @Test
        void testButtonWhenButtonIsNull() {

            final Gui gui = Gui.gui(1);

            gui.button(Slot.of(0, 0), Button.of(ItemType.STONE));

            assertTrue(gui.button(Slot.of(0, 0)).isPresent());

            gui.button(Slot.of(0, 0), null);

            assertEquals(Optional.empty(), gui.button(Slot.of(0, 0)));
        }

        @CsvSource({
                "1, 0, 1",
                "1, 8, 1",
                "5, 0, 5",
                "5, 8, 5"
        })
        @ParameterizedTest
        void testButtonWhenSlotIsOutOfRange(final int slotRow,
                                            final int slotColumn,
                                            final int guiRows) {

            final Gui gui = Gui.gui(guiRows);

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    gui.button(Slot.of(slotRow, slotColumn), Button.of(ItemType.STONE)));
            assertEquals("slot (" + slotRow + ", " + slotColumn + ") out of range for " +
                    guiRows + " rows", e.getMessage());
        }

        @Test
        void testButton() {

            final Gui gui = Gui.gui(1);
            final Button button = Button.of(ItemType.STONE);

            assertEquals(gui, gui.button(Slot.of(0, 0), button));

            assertEquals(Optional.of(button), gui.button(Slot.of(0, 0)));
        }

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Gui gui = Gui.gui(1);

            final Exception e = assertThrows(NullPointerException.class,
                    () -> gui.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Gui gui = Gui.gui(1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            gui.subscribe(subscriber);

            gui.button(Slot.of(0, 0), button);
            verify(subscriber).button(Slot.of(0, 0), button);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testSubscriberThrowsException() {

            final Gui gui = Gui.gui(1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);
            final RuntimeException e = new RuntimeException();

            gui.subscribe(subscriber);

            doThrow(e).when(subscriber).button(Slot.of(0, 0), button);
            gui.button(Slot.of(0, 0), button);

            verify(subscriber).button(Slot.of(0, 0), button);
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testCancelSubscription() {

            final Gui gui = Gui.gui(1);
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            final Subscription subscription = gui.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            gui.button(Slot.of(0, 0), button);

            assertTrue(subscription.isCancelled());
            verifyNoMoreInteractions(subscriber);
        }
    }
}

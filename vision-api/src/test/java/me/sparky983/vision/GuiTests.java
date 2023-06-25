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
    class Chest {

        @CsvSource({
                "1, 0, 1",
                "2, 1, 2",
                "3, 1, 5",
                "4, 3, 4",
                "5, 0, 5"
        })
        @ParameterizedTest
        void testType(final int rows, final int allowedRow, final int disallowedRow) {

            final Gui gui = Gui.chest()
                    .rows(rows)
                    .build();

            final GuiType type = gui.type();

            assertEquals(rows, type.rows());
            assertEquals(Gui.Chest.COLUMNS, type.columns());
            assertTrue(type.allowsSlot(Slot.of(allowedRow, 0)));
            assertFalse(type.allowsSlot(Slot.of(disallowedRow, 0)));
            assertEquals(GuiTypeImpl.ChestImpl.NAME, type.name());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testBuilderTitleWhenTitleIsNull() {

            final Gui.Builder builder = Gui.chest();

            final Exception e = assertThrows(NullPointerException.class, () ->
                    builder.title(null));
            assertEquals("title cannot be null", e.getMessage());
        }

        @Test
        void testBuilderTitle() {

            final Gui.Builder builder = Gui.chest();

            assertEquals(builder, builder.title(TITLE));

            final Gui gui = builder.build();

            assertEquals(TITLE, gui.title());
        }

        @Test
        void testUnspecifiedTitle() {

            final Gui gui = Gui.chest().build();

            assertEquals(gui.type().name(), gui.title());
        }

        @Test
        void testColumns() {

            final Gui gui = Gui.chest().build();

            assertEquals(GuiType.Chest.COLUMNS, gui.columns());
        }

        @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
        @ParameterizedTest
        void testBuilderRowsWhenRowsIsLessThan1(final int rows) {

            final Gui.Chest.Builder builder = Gui.chest();

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> builder.rows(rows));
            assertEquals(GuiTypeImpl.ChestImpl.INCORRECT_ROWS.formatted(rows), e.getMessage());
        }

        @ValueSource(ints = {7, 8, Integer.MAX_VALUE})
        @ParameterizedTest
        void testBuilderRowsWhenRowsIsGreaterThan6(final int rows) {

            final Gui.Chest.Builder builder = Gui.chest();

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    builder.rows(rows));
            assertEquals(GuiTypeImpl.ChestImpl.INCORRECT_ROWS.formatted(rows), e.getMessage());
        }

        @ValueSource(ints = {1, 2, 4, 5, 6})
        @ParameterizedTest
        void testBuilderRows(final int rows) {

            final Gui.Chest.Builder builder = Gui.chest();

            assertEquals(builder, builder.rows(rows));

            final Gui gui = builder.build();

            assertEquals(rows, gui.rows());
        }

        @Test
        void testUnspecifiedRows() {

            final Gui gui = Gui.chest().build();

            assertEquals(GuiImpl.ChestImpl.BuilderImpl.DEFAULT_ROWS, gui.type());
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
                    builder.button(Slot.of(0, 0), null));
            assertEquals("button cannot be null", e.getMessage());
        }

        @CsvSource({
                "1, 0, 1",
                "1, 8, 1",
                "5, 0, 5",
                "5, 8, 5"
        })
        @ParameterizedTest
        void testBuilderButtonWhenSlotIsOutOfBounds(final int slowRow,
                                                    final int slotColumn,
                                                    final int guiRows) {

            final Slot slot = Slot.of(slowRow, slotColumn);
            final Gui.Builder builder = Gui.chest()
                    .rows(guiRows)
                    .button(slot, Button.of(ItemType.STONE));

            final Exception e = assertThrows(IllegalStateException.class, builder::build);
            assertEquals(GuiImpl.ChestImpl.SLOT_OUT_OF_BOUNDS.formatted(slot, guiRows),
                    e.getMessage());
        }

        @Test
        void testBuilderButton() {

            final Gui.Builder builder = Gui.chest();
            final Button button = Button.of(ItemType.STONE);

            assertEquals(builder, builder.button(Slot.of(0, 4), button));

            final Gui gui = builder.build();

            assertEquals(Optional.of(button), gui.button(Slot.of(0, 4)));
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
            assertEquals(GuiImpl.ChestImpl.SLOT_OUT_OF_BOUNDS.formatted(slot, guiRows), e.getMessage());
        }

        @Test
        void testSetButton() {

            final Gui gui = Gui.chest().build();
            final Button button = Button.of(ItemType.STONE);

            assertEquals(gui, gui.button(Slot.of(0, 0), button));

            assertEquals(Optional.of(button), gui.button(Slot.of(0, 0)));
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

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    gui.button(slot));
            assertEquals(GuiImpl.ChestImpl.SLOT_OUT_OF_BOUNDS.formatted(slot, guiRows),
                    e.getMessage());
        }

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Gui gui = Gui.chest().build();

            final Exception e = assertThrows(NullPointerException.class,
                    () -> gui.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Gui gui = Gui.chest().build();
            final Gui.Subscriber subscriber = mock();
            final Button button = Button.of(ItemType.STONE);

            gui.subscribe(subscriber);

            gui.button(Slot.of(0, 0), button);
            verify(subscriber).button(Slot.of(0, 0), button);
            verifyNoMoreInteractions(subscriber);
        }

        @Test
        void testSubscriberThrowsException() {

            final Gui gui = Gui.chest().build();
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

            final Gui gui = Gui.chest().build();
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

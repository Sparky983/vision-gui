package me.sparky983.vision;

import static me.sparky983.vision.Chest.COLUMNS;
import static me.sparky983.vision.Chest.MAX_ROWS;
import static me.sparky983.vision.ChestImpl.DEFAULT_ROWS;
import static me.sparky983.vision.ChestImpl.DEFAULT_TITLE;
import static me.sparky983.vision.Container.SLOT_OUT_OF_BOUNDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Nested
class ChestTests {
  /**
   * A slot to be used for testing.
   */
  static final Slot SLOT = Slot.of(0, 0);

  /**
   * A close to be used for testing.
   */
  static final Close CLOSE = mock();

  @Test
  void testType() {
    final Gui gui = Gui.chest().build();

    assertEquals(GuiType.CHEST, gui.type());
  }

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

    assertEquals(DEFAULT_TITLE, gui.title());
  }

  @Test
  void testColumns() {
    final Gui gui = Gui.chest().build();

    assertEquals(COLUMNS, gui.columns());
  }

  @ValueSource(ints = {Integer.MIN_VALUE, 0, -1, 7, 8, Integer.MAX_VALUE})
  @ParameterizedTest
  void testBuilderRowsWhenRowsIsOutOfBounds(final int rows) {
    final Chest.Builder builder = Gui.chest();

    final Exception e = assertThrows(IllegalArgumentException.class, () -> builder.rows(rows));
    assertEquals("rows must be between 1 and " + MAX_ROWS, e.getMessage());
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

    assertEquals(DEFAULT_ROWS, gui.rows());
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderButtonWhenSlotIsNull() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    final Exception e = assertThrows(NullPointerException.class, () -> builder.slot(null, button));
    assertEquals("slot cannot be null", e.getMessage());
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderButtonWhenButtonIsNull() {
    final Gui.Builder builder = Gui.chest();

    final Exception e = assertThrows(NullPointerException.class, () -> builder.slot(SLOT, null));
    assertEquals("button cannot be null", e.getMessage());
  }

  @CsvSource({"1, 0, 1", "1, 8, 1", "5, 0, 5", "5, 8, 5"})
  @ParameterizedTest
  void testBuilderButtonWhenSlotIsOutOfBounds(
      final int slotRow, final int slotColumn, final int guiRows) {
    final Slot slot = Slot.of(slotRow, slotColumn);
    final Gui.Builder builder = Gui.chest().rows(guiRows).slot(slot, Button.of(ItemType.STONE));

    final Exception e = assertThrows(IllegalStateException.class, builder::build);
    assertEquals(
        String.format(SLOT_OUT_OF_BOUNDS, slotRow, slotColumn, guiRows, COLUMNS), e.getMessage());
  }

  @Test
  void testBuilderButton() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    assertEquals(builder, builder.slot(SLOT, button));

    final Gui gui = builder.build();

    assertEquals(Optional.of(button), gui.slot(SLOT));
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testGetButtonWhenSlotIsNull() {
    final Gui gui = Gui.chest().build();

    final Exception e = assertThrows(NullPointerException.class, () -> gui.slot(null));
    assertEquals("slot cannot be null", e.getMessage());
  }

  @CsvSource({"1, 0, 1", "1, 8, 1", "5, 0, 5", "5, 8, 5"})
  @ParameterizedTest
  void testGetButtonWhenSlotIsOutOfBounds(
      final int slotRow, final int slotColumn, final int guiRows) {
    final Gui gui = Gui.chest().rows(guiRows).build();
    final Slot slot = Slot.of(slotRow, slotColumn);

    final Exception e = assertThrows(IllegalArgumentException.class, () -> gui.slot(slot));
    assertEquals(
        String.format(SLOT_OUT_OF_BOUNDS, slotRow, slotColumn, guiRows, COLUMNS), e.getMessage());
  }

  @SuppressWarnings("ConstantConditions")
  @Test
  void testSetButtonWhenSlotIsNull() {
    final Gui gui = Gui.chest().build();
    final Button button = Button.of(ItemType.STONE);

    final Exception e = assertThrows(NullPointerException.class, () -> gui.slot(null, button));
    assertEquals("slot cannot be null", e.getMessage());
  }

  @Test
  void testSetButtonWhenButtonIsNull() {
    final Gui gui = Gui.chest().build();

    gui.slot(SLOT, Button.of(ItemType.STONE));

    assertTrue(gui.slot(SLOT).isPresent());

    gui.slot(SLOT, null);

    assertEquals(Optional.empty(), gui.slot(SLOT));
  }

  @CsvSource({"1, 0, 1", "1, 8, 1", "5, 0, 5", "5, 8, 5"})
  @ParameterizedTest
  void testSetButtonWhenSlotIsOutOfBounds(
      final int slotRow, final int slotColumn, final int guiRows) {
    final Gui gui = Gui.chest().rows(guiRows).build();
    final Slot slot = Slot.of(slotRow, slotColumn);
    final Button button = Button.of(ItemType.STONE);

    final Exception e = assertThrows(IllegalArgumentException.class, () -> gui.slot(slot, button));
    assertEquals(
        String.format(SLOT_OUT_OF_BOUNDS, slotRow, slotColumn, guiRows, COLUMNS), e.getMessage());
  }

  @Test
  void testSetButton() {
    final Gui gui = Gui.chest().build();
    final Button button = Button.of(ItemType.STONE);

    assertEquals(gui, gui.slot(SLOT, button));

    assertEquals(Optional.of(button), gui.slot(SLOT));
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderFillWhenButtonIsNull() {
    final Gui.Builder builder = Gui.chest();

    assertThrows(NullPointerException.class, () -> builder.fill(null));
  }

  @Test
  void testBuilderFill() {
    final Button button = Button.of(ItemType.STONE);
    final Button filler = Button.of(ItemType.STONE);
    final Chest.Builder builder = Gui.chest().slot(Slot.of(1, 4), button);

    assertEquals(builder, builder.fill(filler));

    builder.rows(3);

    final Gui gui = builder.build();

    for (int row = 0; row < gui.rows(); row++) {
      for (int column = 0; column < gui.columns(); column++) {
        if (row == 1 && column == 4) {
          assertEquals(Optional.of(button), gui.slot(Slot.of(row, column)));
        } else {
          assertEquals(Optional.of(filler), gui.slot(Slot.of(row, column)));
        }
      }
    }
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderSetWhenButtonIsNull() {
    final Gui.Builder builder = Gui.chest();

    assertThrows(NullPointerException.class, () -> builder.border(null, Set.of(Border.TOP)));
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderSetWhenBordersIsNull() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(NullPointerException.class, () -> builder.border(button, (Set<Border>) null));
  }

  @Test
  void testBuilderBorderSetWhenBordersIsEmpty() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(IllegalArgumentException.class, () -> builder.border(button, Set.of()));
  }

  @Test
  void testBuilderBorderSet() {
    final Button button = Button.of(ItemType.STONE);
    final Button border = Button.of(ItemType.DIAMOND);
    final Chest.Builder builder = Gui.chest().slot(Slot.of(0, 4), button);

    assertEquals(builder, builder.border(border, Set.of(Border.TOP, Border.LEFT)));

    builder.rows(3);

    final Gui gui = builder.build();

    final Set<Slot> slots = Set.of(
        Slot.of(0, 0),
        Slot.of(0, 1),
        Slot.of(0, 2),
        Slot.of(0, 3),
        Slot.of(0, 5),
        Slot.of(0, 6),
        Slot.of(0, 7),
        Slot.of(0, 8),

        // Slot.of(0, 0) - corner
        Slot.of(1, 0),
        Slot.of(2, 0));

    for (final Slot slot : gui.slots()) {
      if (slots.contains(slot)) {
        assertEquals(Optional.of(border), gui.slot(slot), slot.toString());
      } else if (slot.row() == 0 && slot.column() == 4) {
        assertEquals(Optional.of(button), gui.slot(slot), slot.toString());
      } else {
        assertEquals(Optional.empty(), gui.slot(slot), slot.toString());
      }
    }
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderVarargsWhenButtonIsNull() {
    final Gui.Builder builder = Gui.chest();

    assertThrows(NullPointerException.class, () -> builder.border(null, Border.TOP));
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderVarargsWhenBordersIsNull() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(NullPointerException.class, () -> builder.border(button, (Border) null));
  }

  @Test
  void testBuilderBorderVarargsWhenBordersIsEmpty() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(IllegalArgumentException.class, () -> builder.border(button, new Border[0]));
  }

  @Test
  void testBuilderBorderVarargsWhenBordersHasDuplicates() {
    final Gui.Builder builder = Gui.chest();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(
        IllegalArgumentException.class, () -> builder.border(button, Border.TOP, Border.TOP));
  }

  @Test
  void testBuilderBorderVarargs() {
    final Button button = Button.of(ItemType.STONE);
    final Button border = Button.of(ItemType.DIAMOND);
    final Chest.Builder builder = Gui.chest().slot(Slot.of(0, 4), button);

    assertEquals(builder, builder.border(border, Border.TOP, Border.LEFT));

    builder.rows(3);

    final Gui gui = builder.build();

    final Set<Slot> slots = Set.of(
        Slot.of(0, 0),
        Slot.of(0, 1),
        Slot.of(0, 2),
        Slot.of(0, 3),
        Slot.of(0, 5),
        Slot.of(0, 6),
        Slot.of(0, 7),
        Slot.of(0, 8),

        // Slot.of(0, 0) - corner
        Slot.of(1, 0),
        Slot.of(2, 0));

    for (final Slot slot : gui.slots()) {
      if (slots.contains(slot)) {
        assertEquals(Optional.of(border), gui.slot(slot), slot.toString());
      } else if (slot.row() == 0 && slot.column() == 4) {
        assertEquals(Optional.of(button), gui.slot(slot), slot.toString());
      } else {
        assertEquals(Optional.empty(), gui.slot(slot), slot.toString());
      }
    }
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderWhenButtonIsNull() {
    final Gui.Builder builder = Gui.chest();

    assertThrows(NullPointerException.class, () -> builder.border(null));
  }

  @Test
  void testBuilderBorder() {
    final Button button = Button.of(ItemType.STONE);
    final Button border = Button.of(ItemType.DIAMOND);
    final Chest.Builder builder = Gui.chest().slot(Slot.of(0, 4), button);

    assertEquals(builder, builder.border(border)); // all borders

    builder.rows(3);

    final Gui gui = builder.build();

    final Set<Slot> slots = Set.of(
        Slot.of(0, 0),
        Slot.of(0, 1),
        Slot.of(0, 2),
        Slot.of(0, 3),
        Slot.of(0, 5),
        Slot.of(0, 6),
        Slot.of(0, 7),
        Slot.of(0, 8),
        Slot.of(2, 0),
        Slot.of(2, 1),
        Slot.of(2, 2),
        Slot.of(2, 3),
        Slot.of(2, 4),
        Slot.of(2, 5),
        Slot.of(2, 6),
        Slot.of(2, 7),
        Slot.of(2, 8),

        // Slot.of(0, 0) - corner
        Slot.of(1, 0),
        // Slot.of(2, 0), - corner

        // Slot.of(0, 8) - corner
        Slot.of(1, 8)
        // Slot.of(2, 8) - corner
        );

    for (final Slot slot : gui.slots()) {
      if (slots.contains(slot)) {
        assertEquals(Optional.of(border), gui.slot(slot), slot.toString());
      } else if (slot.row() == 0 && slot.column() == 4) {
        assertEquals(Optional.of(button), gui.slot(slot), slot.toString());
      } else {
        assertEquals(Optional.empty(), gui.slot(slot), slot.toString());
      }
    }
  }

  @Test
  void testSlots() {
    final Gui gui = Gui.chest().rows(2).build();

    final List<Slot> slots = List.of(
        Slot.of(0, 0),
        Slot.of(0, 1),
        Slot.of(0, 2),
        Slot.of(0, 3),
        Slot.of(0, 4),
        Slot.of(0, 5),
        Slot.of(0, 6),
        Slot.of(0, 7),
        Slot.of(0, 8),
        Slot.of(1, 0),
        Slot.of(1, 1),
        Slot.of(1, 2),
        Slot.of(1, 3),
        Slot.of(1, 4),
        Slot.of(1, 5),
        Slot.of(1, 6),
        Slot.of(1, 7),
        Slot.of(1, 8));

    assertEquals(slots, gui.slots());
  }

  @Test
  void testBuilderOnClickWhenHandlerIsNull() {
    final Gui.Builder builder = Gui.chest();

    final Exception e = assertThrows(NullPointerException.class, () -> builder.onClose(null));
    assertEquals("handler cannot be null", e.getMessage());
  }

  @Test
  void testBuilderOnclick() {
    final Gui.Builder builder = Gui.chest();
    final Consumer<Close> clickHandler = mock();

    assertEquals(builder, builder.onClose(clickHandler));

    final Gui gui = builder.build();

    gui.publisher().close(CLOSE);

    verify(clickHandler).accept(CLOSE);
    verifyNoMoreInteractions(clickHandler);
  }

  @Test
  void testOnClickWhenHandlerIsNull() {
    final Gui gui = Gui.chest().build();

    final Exception e = assertThrows(NullPointerException.class, () -> gui.onClose(null));
    assertEquals("handler cannot be null", e.getMessage());
  }

  @Test
  void testOnClick() {
    final Gui gui = Gui.chest().build();
    final Consumer<Close> clickHandler = mock();

    assertEquals(gui, gui.onClose(clickHandler));

    gui.publisher().close(CLOSE);

    verify(clickHandler).accept(CLOSE);
    verifyNoMoreInteractions(clickHandler);
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

    gui.slot(SLOT, button);
    verify(subscriber).button(SLOT, button);
    verify(subscriber).slot(SLOT, button);

    gui.publisher().close(CLOSE);
    verify(subscriber).close(CLOSE);

    verifyNoMoreInteractions(subscriber);
  }

  @Test
  void testCancelSubscriptionWhenSubscriptionIsAlreadyCancelled() {
    final Gui gui = Gui.chest().build();

    final Subscription subscription = gui.subscribe(mock());

    subscription.cancel();

    assertThrows(IllegalStateException.class, subscription::cancel);
  }

  @Test
  void testCancelSubscription() {
    final Gui gui = Gui.chest().build();
    final Gui.Subscriber subscriber = mock();
    final Button button = Button.of(ItemType.STONE);

    final Subscription subscription = gui.subscribe(subscriber);

    assertFalse(subscription.isCanceled());

    subscription.cancel();

    gui.slot(SLOT, button);
    gui.publisher().close(CLOSE);

    assertTrue(subscription.isCanceled());
    verifyNoMoreInteractions(subscriber);
  }

  @Test
  void testToString() {
    final Gui gui = Gui.chest().title(Component.text("title")).rows(3).build();

    assertEquals(
        String.format("ChestImpl[title=%s, rows=3]", Component.text("title")), gui.toString());
  }
}

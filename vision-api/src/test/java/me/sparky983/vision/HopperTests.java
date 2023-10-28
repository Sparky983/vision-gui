package me.sparky983.vision;

import static me.sparky983.vision.Container.SLOT_OUT_OF_BOUNDS;
import static me.sparky983.vision.Hopper.COLUMNS;
import static me.sparky983.vision.Hopper.ROWS;
import static me.sparky983.vision.HopperImpl.DEFAULT_TITLE;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HopperTests {
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
    final Gui gui = Gui.hopper().build();

    assertEquals(GuiType.HOPPER, gui.type());
  }

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

    final Exception e =
        assertThrows(NullPointerException.class, () -> builder.button(null, button));
    assertEquals("slot cannot be null", e.getMessage());
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderButtonWhenButtonIsNull() {
    final Gui.Builder builder = Gui.hopper();

    final Exception e = assertThrows(NullPointerException.class, () -> builder.button(SLOT, null));
    assertEquals("button cannot be null", e.getMessage());
  }

  @CsvSource({"2, 3", "3, 3", "3, 2", "3, 3"})
  @ParameterizedTest
  void testBuilderButtonWhenSlotIsOutOfBounds(final int row, final int column) {
    final Slot slot = Slot.of(row, column);
    final Gui.Builder builder = Gui.hopper().button(slot, Button.of(ItemType.STONE));

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
  void testGetButtonWhenSlotIsNull() {
    final Gui gui = Gui.hopper().build();

    final Exception e = assertThrows(NullPointerException.class, () -> gui.button(null));
    assertEquals("slot cannot be null", e.getMessage());
  }

  @CsvSource({"2, 3", "3, 3", "3, 2", "3, 3"})
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
  void testSetButtonWhenSlotIsNull() {
    final Gui gui = Gui.hopper().build();
    final Button button = Button.of(ItemType.STONE);

    final Exception e = assertThrows(NullPointerException.class, () -> gui.button(null, button));
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

  @CsvSource({"2, 3", "3, 3", "3, 2", "3, 3"})
  @ParameterizedTest
  void testSetButtonWhenSlotIsOutOfBounds(final int row, final int column) {
    final Slot slot = Slot.of(row, column);
    final Gui gui = Gui.hopper().build();
    final Button button = Button.of(ItemType.STONE);

    final Exception e =
        assertThrows(IllegalArgumentException.class, () -> gui.button(slot, button));
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
    final Button button = Button.of(ItemType.STONE);
    final Button filler = Button.of(ItemType.STONE);
    final Gui.Builder builder = Gui.hopper().button(Slot.of(0, 2), button);

    assertEquals(builder, builder.fill(filler));

    final Gui gui = builder.build();

    for (int column = 0; column < gui.columns(); column++) {
      if (column == 2) {
        assertEquals(Optional.of(button), gui.button(Slot.of(0, column)));
      } else {
        assertEquals(Optional.of(filler), gui.button(Slot.of(0, column)));
      }
    }
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderSetWhenButtonIsNull() {
    final Gui.Builder builder = Gui.hopper();

    assertThrows(NullPointerException.class, () -> builder.border(null, Set.of(Border.TOP)));
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderSetWhenBordersIsNull() {
    final Gui.Builder builder = Gui.hopper();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(NullPointerException.class, () -> builder.border(button, (Set<Border>) null));
  }

  @Test
  void testBuilderBorderSetWhenBordersIsEmpty() {
    final Gui.Builder builder = Gui.hopper();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(IllegalArgumentException.class, () -> builder.border(button, Set.of()));
  }

  @Test
  void testBuilderBorderSet() {
    final Button button = Button.of(ItemType.STONE);
    final Button border = Button.of(ItemType.DIAMOND);
    final Gui.Builder builder = Gui.hopper().button(Slot.of(0, 2), button);

    assertEquals(builder, builder.border(border, Set.of(Border.TOP)));

    final Gui gui = builder.build();

    for (final Slot slot : gui.slots()) {
      if (slot.column() == 2) {
        assertEquals(Optional.of(button), gui.button(slot), slot.toString());
      } else {
        assertEquals(Optional.of(border), gui.button(slot), slot.toString());
      }
    }
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderVarargsWhenButtonIsNull() {
    final Gui.Builder builder = Gui.hopper();

    assertThrows(NullPointerException.class, () -> builder.border(null, Border.TOP));
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderVarargsWhenBordersIsNull() {
    final Gui.Builder builder = Gui.hopper();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(NullPointerException.class, () -> builder.border(button, (Border) null));
  }

  @Test
  void testBuilderBorderVarargsWhenBordersIsEmpty() {
    final Gui.Builder builder = Gui.hopper();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(IllegalArgumentException.class, () -> builder.border(button, new Border[0]));
  }

  @Test
  void testBuilderBorderVarargsWhenBordersHasDuplicates() {
    final Gui.Builder builder = Gui.hopper();
    final Button button = Button.of(ItemType.STONE);

    assertThrows(
        IllegalArgumentException.class, () -> builder.border(button, Border.TOP, Border.TOP));
  }

  @Test
  void testBuilderBorderVarargs() {
    final Button button = Button.of(ItemType.STONE);
    final Button border = Button.of(ItemType.DIAMOND);
    final Gui.Builder builder = Gui.hopper().button(Slot.of(0, 2), button);

    assertEquals(builder, builder.border(border, Border.LEFT, Border.RIGHT));

    final Gui gui = builder.build();

    final Set<Slot> slots = Set.of(Slot.of(0, 0), Slot.of(0, 4));

    for (final Slot slot : gui.slots()) {
      if (slots.contains(slot)) {
        assertEquals(Optional.of(border), gui.button(slot), slot.toString());
      } else if (slot.column() == 2) {
        assertEquals(Optional.of(button), gui.button(slot), slot.toString());
      } else {
        assertEquals(Optional.empty(), gui.button(slot), slot.toString());
      }
    }
  }

  @SuppressWarnings("DataFlowIssue")
  @Test
  void testBuilderBorderWhenButtonIsNull() {
    final Gui.Builder builder = Gui.hopper();

    assertThrows(NullPointerException.class, () -> builder.border(null));
  }

  @Test
  void testBuilderBorder() {
    final Button button = Button.of(ItemType.STONE);
    final Button border = Button.of(ItemType.DIAMOND);
    final Gui.Builder builder = Gui.hopper().button(Slot.of(0, 1), button);

    assertEquals(builder, builder.border(border));

    final Gui gui = builder.build();

    for (final Slot slot : gui.slots()) {
      if (slot.column() == 1) {
        assertEquals(Optional.of(button), gui.button(slot), slot.toString());
      } else {
        assertEquals(Optional.of(border), gui.button(slot), slot.toString());
      }
    }
  }

  @Test
  void testSlots() {
    final Gui gui = Gui.hopper().build();

    final List<Slot> slots =
        List.of(Slot.of(0, 0), Slot.of(0, 1), Slot.of(0, 2), Slot.of(0, 3), Slot.of(0, 4));

    assertEquals(slots, gui.slots());
  }

  @Test
  void testBuilderOnClickWhenHandlerIsNull() {
    final Gui.Builder builder = Gui.hopper();

    final Exception e = assertThrows(NullPointerException.class, () -> builder.onClose(null));
    assertEquals("handler cannot be null", e.getMessage());
  }

  @Test
  void testBuilderOnclick() {
    final Gui.Builder builder = Gui.hopper();
    final Consumer<Close> clickHandler = mock();

    assertEquals(builder, builder.onClose(clickHandler));

    final Gui gui = builder.build();

    gui.publisher().close(CLOSE);

    verify(clickHandler).accept(CLOSE);
    verifyNoMoreInteractions(clickHandler);
  }

  @Test
  void testOnClickWhenHandlerIsNull() {
    final Gui gui = Gui.hopper().build();

    final Exception e = assertThrows(NullPointerException.class, () -> gui.onClose(null));
    assertEquals("handler cannot be null", e.getMessage());
  }

  @Test
  void testOnClick() {
    final Gui gui = Gui.hopper().build();
    final Consumer<Close> clickHandler = mock();

    assertEquals(gui, gui.onClose(clickHandler));

    gui.publisher().close(CLOSE);

    verify(clickHandler).accept(CLOSE);
    verifyNoMoreInteractions(clickHandler);
  }

  @Test
  void testSubscribe() {
    final Gui gui = Gui.hopper().build();
    final Gui.Subscriber subscriber = mock();
    final Button button = Button.of(ItemType.STONE);

    gui.subscribe(subscriber);

    gui.button(SLOT, button);
    verify(subscriber).button(SLOT, button);

    gui.publisher().close(CLOSE);
    verify(subscriber).close(CLOSE);

    verifyNoMoreInteractions(subscriber);
  }

  @Test
  void testCancelSubscriptionWhenSubscriptionIsAlreadyCancelled() {
    final Gui gui = Gui.hopper().build();

    final Subscription subscription = gui.subscribe(mock());

    subscription.cancel();

    assertThrows(IllegalStateException.class, subscription::cancel);
  }

  @Test
  void testCancelSubscription() {
    final Gui gui = Gui.hopper().build();
    final Gui.Subscriber subscriber = mock();
    final Button button = Button.of(ItemType.STONE);

    final Subscription subscription = gui.subscribe(subscriber);

    assertFalse(subscription.isCanceled());

    subscription.cancel();

    gui.button(SLOT, button);
    gui.publisher().close(CLOSE);

    assertTrue(subscription.isCanceled());
    verifyNoMoreInteractions(subscriber);
  }

  @Test
  void testToString() {
    final Gui gui = Gui.hopper().title(Component.text("title")).build();

    assertEquals(String.format("HopperImpl[title=%s]", Component.text("title")), gui.toString());
  }
}

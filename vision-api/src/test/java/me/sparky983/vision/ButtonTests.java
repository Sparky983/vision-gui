package me.sparky983.vision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ButtonTests {
  /**
   * A component to be used for testing as a button's name.
   */
  static final Component NAME = Component.text("name");

  /**
   * A component to be used for testing as the first line of a button's lore.
   */
  static final Component LORE_LINE_1 = Component.text("lore line 1");

  /**
   * A component to be used for testing the second line of a button's lore.
   */
  static final Component LORE_LINE_2 = Component.text("lore line 2");

  /**
   * An array of components to be used for testing button's lore with varargs.
   */
  static final Component[] LORE_ARRAY = {LORE_LINE_1, LORE_LINE_2};

  /**
   * A list of components to be used for testing button's lore with a list.
   */
  static final List<Component> LORE_LIST = List.of(LORE_LINE_1, LORE_LINE_2);

  /**
   * A click to be used for testing.
   */
  static final Click CLICK = mock();

  @AfterAll
  static void tearDownAll() {
    verifyNoInteractions(CLICK);
  }

  @Nested
  class ButtonFactory {
    @SuppressWarnings("ConstantConditions")
    @Test
    void testFactoryTypeWhenTypeIsNull() {
      final Button.Factory builder = Button.button();

      final Exception e = assertThrows(NullPointerException.class, () -> builder.type(null));
      assertEquals("type cannot be null", e.getMessage());
    }

    @Test
    void testFactoryType() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(ItemType.STONE, button.type());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testTypeWhenTypeIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(NullPointerException.class, () -> button.type(null));
      assertEquals("type cannot be null", e.getMessage());

      assertNotNull(button.type());
    }

    @Test
    void testType() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(button, button.type(ItemType.DIRT));
      assertEquals(button.type(), ItemType.DIRT);
    }

    @Test
    void testDefaultName() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(Component.translatable(ItemType.STONE), button.name());
    }

    @Test
    void testNameWhenNameIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      button.name(null);

      assertEquals(Component.translatable(ItemType.STONE), button.name());
    }

    @Test
    void testName() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(button, button.name(NAME));

      assertEquals(NAME, button.name());
    }

    @Test
    void testDefaultLore() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(List.of(), button.lore());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testVarargsLoreWhenLoreIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e =
          assertThrows(NullPointerException.class, () -> button.lore((Component[]) null));
      assertEquals("lore cannot be null", e.getMessage());

      assertNotNull(button.lore());
    }

    @Test
    void testVarargsLoreWhenLoreContainsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(
          NullPointerException.class, () -> button.lore(Arrays.asList(LORE_LINE_1, null)));
      assertEquals("lore[1] cannot be null", e.getMessage());

      assertNotEquals(Arrays.asList(LORE_LINE_1, null), button.lore());
    }

    @Test
    void testVarargsLore() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(button, button.lore(LORE_ARRAY));
      assertEquals(LORE_LIST, button.lore());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testListLoreWhenLoreIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e =
          assertThrows(NullPointerException.class, () -> button.lore((Component[]) null));
      assertEquals("lore cannot be null", e.getMessage());

      assertNotNull(button.lore());
    }

    @Test
    void testListLoreWhenLoreContainsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(
          NullPointerException.class, () -> button.lore(Arrays.asList(LORE_LINE_1, null)));
      assertEquals("lore[1] cannot be null", e.getMessage());
    }

    @Test
    void testListLore() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(button, button.lore(LORE_LIST));
      assertEquals(LORE_LIST, button.lore());
    }

    @Test
    void testDefaultAmount() {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(1, button.amount());
    }

    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    @ParameterizedTest
    void testAmountWhenAmountIsLessThan1(final int amount) {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
      assertEquals("amount must be between 1 and 64", e.getMessage());

      assertNotEquals(amount, button.amount());
    }

    @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
    @ParameterizedTest
    void testAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
      assertEquals("amount must be between 1 and 64", e.getMessage());

      assertNotEquals(amount, button.amount());
    }

    @ValueSource(ints = {1, 5, 64})
    @ParameterizedTest
    void testAmount(final int amount) {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(button, button.amount(amount));
      assertEquals(amount, button.amount());
    }

    @Test
    void testDefaultGlow() {
      final Button button = Button.button().type(ItemType.STONE);

      assertFalse(button.glow());
    }

    @ValueSource(booleans = {true, false})
    @ParameterizedTest
    void testGlow(final boolean glow) {
      final Button button = Button.button().type(ItemType.STONE);

      assertEquals(button, button.glow(glow));

      assertEquals(glow, button.glow());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testClickWhenClickIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e =
          assertThrows(NullPointerException.class, () -> button.publisher().click(null));
      assertEquals("click cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testOnClickWhenHandlerIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(NullPointerException.class, () -> button.onClick(null));
      assertEquals("handler cannot be null", e.getMessage());
    }

    @Test
    void testOnClick() {
      final Button button = Button.button().type(ItemType.STONE);
      final Consumer<Click> clickHandler = mock();

      assertEquals(button, button.onClick(clickHandler));

      button.publisher().click(CLICK);

      verify(clickHandler).accept(CLICK);
      verifyNoMoreInteractions(clickHandler);
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSubscribeWhenSubscriberIsNull() {
      final Button button = Button.button().type(ItemType.STONE);

      final Exception e = assertThrows(NullPointerException.class, () -> button.subscribe(null));
      assertEquals("subscriber cannot be null", e.getMessage());
    }

    @Test
    void testSubscribe() {
      final Button button = Button.button().type(ItemType.STONE);
      final Button.Subscriber subscriber = mock();

      button.subscribe(subscriber);

      button.type(ItemType.STONE);
      verify(subscriber).type(ItemType.STONE);

      button.name(NAME);
      verify(subscriber).name(NAME);

      button.lore(LORE_LIST);
      verify(subscriber).lore(LORE_LIST);

      button.lore(LORE_ARRAY);
      verify(subscriber, times(2)).lore(LORE_LIST);

      button.amount(5);
      verify(subscriber).amount(5);

      button.glow(true);
      verify(subscriber).glow(true);

      button.publisher().click(CLICK);
      verify(subscriber).click(CLICK);

      verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testCancelSubscriptionWhenSubscriptionIsAlreadyCancelled() {
      final Button button = Button.button().type(ItemType.STONE);

      final Subscription subscription = button.subscribe(mock());

      subscription.cancel();

      assertThrows(IllegalStateException.class, subscription::cancel);
    }

    @Test
    void testCancelSubscription() {
      final Button button = Button.button().type(ItemType.STONE);
      final Button.Subscriber subscriber = mock();

      final Subscription subscription = button.subscribe(subscriber);

      assertFalse(subscription.isCancelled());

      subscription.cancel();

      button.type(ItemType.STONE);
      button.name(NAME);
      button.lore(LORE_LIST);
      button.lore(LORE_ARRAY);
      button.amount(5);
      button.glow(true);
      button.publisher().click(CLICK);

      assertTrue(subscription.isCancelled());
      verifyNoInteractions(subscriber);
    }

    @Test
    void testToString() {
      final Button button = Button.button()
          .type(ItemType.STONE)
          .name(NAME)
          .lore(LORE_LIST)
          .amount(2)
          .glow(true);

      assertEquals(
          String.format(
              "ButtonImpl[type=%s, name=%s, lore=%s, amount=%s, glow=%s]",
              ItemType.STONE, NAME, LORE_LIST, 2, true),
          button.toString());
    }
  }

  @Nested
  class ButtonOf {
    @SuppressWarnings("ConstantConditions")
    @Test
    void testButtonOfWhenTypeIsNull() {
      final Exception e = assertThrows(NullPointerException.class, () -> Button.of(null));
      assertEquals("type cannot be null", e.getMessage());
    }

    @Test
    void testButtonOf() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(ItemType.STONE, button.type());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testTypeWhenTypeIsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(NullPointerException.class, () -> button.type(null));
      assertEquals("type cannot be null", e.getMessage());

      assertNotNull(button.type());
    }

    @Test
    void testType() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(button, button.type(ItemType.DIRT));
      assertEquals(ItemType.DIRT, button.type());
    }

    @Test
    void testDefaultName() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(Component.translatable(ItemType.STONE), button.name());
    }

    @Test
    void testNameWhenNameIsNull() {
      final Button button = Button.of(ItemType.STONE);

      button.name(null);

      assertEquals(Component.translatable(ItemType.STONE), button.name());
    }

    @Test
    void testName() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(button, button.name(NAME));
      assertEquals(NAME, button.name());
    }

    @Test
    void testDefaultLoreLore() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(List.of(), button.lore());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testVarargsLoreWhenLoreIsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e =
          assertThrows(NullPointerException.class, () -> button.lore((Component[]) null));
      assertEquals("lore cannot be null", e.getMessage());

      assertNotNull(button.lore());
    }

    @Test
    void testVarargsLoreWhenLoreContainsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(
          NullPointerException.class, () -> button.lore(Arrays.asList(LORE_LINE_1, null)));
      assertEquals("lore[1] cannot be null", e.getMessage());

      assertNotEquals(Arrays.asList(LORE_LINE_1, null), button.lore());
    }

    @Test
    void testVarargsLore() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(button, button.lore(LORE_ARRAY));
      assertEquals(LORE_LIST, button.lore());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testListLoreWhenLoreIsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e =
          assertThrows(NullPointerException.class, () -> button.lore((Component[]) null));
      assertEquals("lore cannot be null", e.getMessage());

      assertNotNull(button.lore());
    }

    @Test
    void testListLoreWhenLoreContainsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(
          NullPointerException.class, () -> button.lore(Arrays.asList(LORE_LINE_1, null)));
      assertEquals("lore[1] cannot be null", e.getMessage());
    }

    @Test
    void testListLore() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(button, button.lore(LORE_LIST));
      assertEquals(LORE_LIST, button.lore());
    }

    @Test
    void testDefaultAmount() {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(1, button.amount());
    }

    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    @ParameterizedTest
    void testAmountWhenAmountIsLessThan1(final int amount) {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
      assertEquals("amount must be between 1 and 64", e.getMessage());

      assertNotEquals(amount, button.amount());
    }

    @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
    @ParameterizedTest
    void testAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
      assertEquals("amount must be between 1 and 64", e.getMessage());

      assertNotEquals(amount, button.amount());
    }

    @ValueSource(ints = {1, 5, 64})
    @ParameterizedTest
    void testAmount(final int amount) {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(button, button.amount(amount));
      assertEquals(amount, button.amount());
    }

    @Test
    void testDefaultGlow() {
      final Button button = Button.of(ItemType.STONE);

      assertFalse(button.glow());
    }

    @ValueSource(booleans = {true, false})
    @ParameterizedTest
    void testGlow(final boolean glow) {
      final Button button = Button.of(ItemType.STONE);

      assertEquals(button, button.glow(glow));

      assertEquals(glow, button.glow());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testClickWhenClickIsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e =
          assertThrows(NullPointerException.class, () -> button.publisher().click(null));
      assertEquals("click cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testOnClickWhenHandlerIsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(NullPointerException.class, () -> button.onClick(null));
      assertEquals("handler cannot be null", e.getMessage());
    }

    @Test
    void testOnClick() {
      final Button button = Button.of(ItemType.STONE);
      final Consumer<Click> clickHandler = mock();

      assertEquals(button, button.onClick(clickHandler));

      button.publisher().click(CLICK);

      verify(clickHandler).accept(CLICK);
      verifyNoMoreInteractions(clickHandler);
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testSubscribeWhenSubscriberIsNull() {
      final Button button = Button.of(ItemType.STONE);

      final Exception e = assertThrows(NullPointerException.class, () -> button.subscribe(null));
      assertEquals("subscriber cannot be null", e.getMessage());
    }

    @Test
    void testSubscribe() {
      final Button button = Button.of(ItemType.STONE);
      final Button.Subscriber subscriber = mock();

      button.subscribe(subscriber);

      button.type(ItemType.STONE);
      verify(subscriber).type(ItemType.STONE);

      button.name(NAME);
      verify(subscriber).name(NAME);

      button.lore(LORE_LIST);
      verify(subscriber).lore(LORE_LIST);

      button.lore(LORE_ARRAY);
      verify(subscriber, times(2)).lore(LORE_LIST);

      button.amount(5);
      verify(subscriber).amount(5);

      button.glow(true);
      verify(subscriber).glow(true);

      button.publisher().click(CLICK);
      verify(subscriber).click(CLICK);

      verifyNoMoreInteractions(subscriber);
    }

    @Test
    void testCancelSubscriptionWhenSubscriptionIsAlreadyCancelled() {
      final Button button = Button.of(ItemType.STONE);

      final Subscription subscription = button.subscribe(mock());

      subscription.cancel();

      assertThrows(IllegalStateException.class, subscription::cancel);
    }

    @Test
    void testCancelSubscription() {
      final Button button = Button.of(ItemType.STONE);
      final Button.Subscriber subscriber = mock();

      final Subscription subscription = button.subscribe(subscriber);

      assertFalse(subscription.isCancelled());

      subscription.cancel();

      button.type(ItemType.STONE);
      button.name(NAME);
      button.lore(LORE_LIST);
      button.lore(LORE_ARRAY);
      button.amount(5);
      button.glow(true);
      button.publisher().click(CLICK);

      assertTrue(subscription.isCancelled());
      verifyNoInteractions(subscriber);
    }

    @Test
    void testToString() {
      final Button button =
          Button.of(ItemType.STONE).name(NAME).lore(LORE_LIST).amount(2).glow(true);

      assertEquals(
          String.format(
              "ButtonImpl[type=%s, name=%s, lore=%s, amount=%s, glow=%s]",
              ItemType.STONE, NAME, LORE_LIST, 2, true),
          button.toString());
    }
  }
}

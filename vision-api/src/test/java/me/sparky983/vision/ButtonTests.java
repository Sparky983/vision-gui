package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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

    @Nested
    class ButtonBuilder {

        @SuppressWarnings("ConstantConditions")
        @Test
        void testBuilderNameWhenNameIsNull() {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(NullPointerException.class, () -> builder.name(null));
            assertEquals("name cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotNull(button.name());
        }

        @Test
        void testBuilderName() {

            final Button.Builder builder = Button.button();

            assertEquals(builder, builder.name(NAME));

            final Button button = builder.type(ItemType.STONE);

            assertEquals(NAME, button.name());
        }

        @Test
        void testUnspecifiedName() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(Component.translatable(ItemType.STONE.translationKey()), button.name());
        }

        @Test
        void testNameWhenNameIsNull() {

            final Button button = Button.button().type(ItemType.STONE);

            button.name(null);

            assertEquals(Component.translatable(ItemType.STONE.translationKey()), button.name());
        }

        @Test
        void testName() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(button, button.name(NAME));

            assertEquals(NAME, button.name());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testBuilderVarargsLoreWhenLoreIsNull() {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(NullPointerException.class, () ->
                    builder.lore((Component[]) null));

            assertEquals("lore cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotNull(button.lore());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testBuilderVarargsLoreWhenLoreContainsNull() {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(NullPointerException.class, () ->
                    builder.lore(new Component[]{LORE_LINE_1, null}));
            assertEquals("lore[1] cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(Arrays.asList(LORE_LINE_1, null), button.lore());
        }

        @Test
        void testBuilderVarargsLore() {

            final Button.Builder builder = Button.button();

            assertEquals(builder, builder.lore(LORE_ARRAY));

            final Button button = builder.type(ItemType.STONE);

            assertEquals(LORE_LIST, button.lore());
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

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(LORE_LINE_1, null)));
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
        void testBuilderListLoreWhenLoreIsNull() {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(NullPointerException.class, () ->
                    builder.lore((List<Component>) null));

            assertEquals("lore cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotNull(button.lore());
        }

        @Test
        void testBuilderListLoreWhenLoreContainsNull() {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(NullPointerException.class, () ->
                    builder.lore(Arrays.asList(LORE_LINE_1, null)));

            assertEquals("lore[1] cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(Arrays.asList(LORE_LINE_1, null), button.lore());
        }

        @Test
        void testBuilderListLore() {

            final Button.Builder builder = Button.button();

            assertEquals(builder, builder.lore(LORE_LIST));

            final Button button = builder.type(ItemType.STONE);

            assertEquals(LORE_LIST, button.lore());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testListLoreWhenLoreIsNull() {

            final Button button = Button.button().type(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore((Component[]) null));
            assertEquals("lore cannot be null", e.getMessage());

            assertNotNull(button.lore());
        }

        @Test
        void testListLoreWhenLoreContainsNull() {

            final Button button = Button.button().type(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(LORE_LINE_1, null)));
            assertEquals("lore[1] cannot be null", e.getMessage());
        }

        @Test
        void testListLore() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(button, button.lore(LORE_LIST));
            assertEquals(LORE_LIST, button.lore());
        }

        @Test
        void testUnspecifiedLore() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(List.of(), button.lore());
        }

        @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
        @ParameterizedTest
        void testBuilderAmountWhenAmountIsLessThan1(final int amount) {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    builder.amount(amount));
            assertEquals("amount must be between 1 and 64", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(amount, button.amount());
        }

        @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
        @ParameterizedTest
        void testBuilderAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    builder.amount(amount));
            assertEquals("amount must be between 1 and 64", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(amount, button.amount());
        }

        @Test
        void testBuilderAmount() {

            final Button.Builder builder = Button.button();

            assertEquals(builder, builder.amount(5));

            final Button button = builder.type(ItemType.STONE);

            assertEquals(5, button.amount());
        }

        @Test
        void testUnspecifiedAmount() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(1, button.amount());
        }

        @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
        @ParameterizedTest
        void testAmountWhenAmountIsLessThan1(final int amount) {

            final Button button = Button.button().type(ItemType.STONE);

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    button.amount(amount));
            assertEquals("amount must be between 1 and 64", e.getMessage());

            assertNotEquals(amount, button.amount());
        }

        @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
        @ParameterizedTest
        void testAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {

            final Button button = Button.button().type(ItemType.STONE);

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
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

        @SuppressWarnings("ConstantConditions")
        @Test
        void testBuilderTypeWhenTypeIsNull() {

            final Button.Builder builder = Button.button();

            final Exception e = assertThrows(NullPointerException.class, () -> builder.type(null));
            assertEquals("type cannot be null", e.getMessage());
        }

        @Test
        void testBuilderType() {

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

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Button button = Button.button().type(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class,
                    () -> button.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Button button = Button.button().type(ItemType.STONE);
            final Button.Subscriber subscriber = mock();

            button.subscribe(subscriber);

            button.name(NAME);
            verify(subscriber).name(NAME);

            button.lore(LORE_LIST);
            verify(subscriber).lore(LORE_LIST);

            button.lore(LORE_ARRAY);
            verify(subscriber, times(2)).lore(LORE_LIST);

            button.amount(5);
            verify(subscriber).amount(5);

            button.type(ItemType.STONE);
            verify(subscriber).type(ItemType.STONE);
        }

        @Test
        void testSubscriberThrowsException() {

            final Button button = Button.button().type(ItemType.STONE);
            final Button.Subscriber subscriber = mock();
            final RuntimeException e = new RuntimeException();

            button.subscribe(subscriber);

            doThrow(e).when(subscriber).name(NAME);
            button.name(NAME);
            verify(subscriber).name(NAME);
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).lore(LORE_LIST);
            button.lore(LORE_LIST);
            verify(subscriber).lore(LORE_LIST);
            verify(subscriber, times(2)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).lore(LORE_LIST);
            button.lore(LORE_ARRAY);
            verify(subscriber, times(2)).lore(LORE_LIST);
            verify(subscriber, times(3)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).amount(5);
            button.amount(5);
            verify(subscriber).amount(5);
            verify(subscriber, times(4)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).type(ItemType.STONE);
            button.type(ItemType.STONE);
            verify(subscriber).type(ItemType.STONE);
            verify(subscriber, times(5)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).exception(e);
            button.name(NAME);
            verify(subscriber, times(2)).name(NAME);
            verify(subscriber, times(6)).exception(e);
            verifyNoMoreInteractions(subscriber); // exception should not be called again
        }

        @Test
        void testCancelSubscription() {

            final Button button = Button.button().type(ItemType.STONE);
            final Button.Subscriber subscriber = mock();

            final Subscription subscription = button.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            button.name(NAME);
            button.lore(LORE_LIST);
            button.lore(LORE_ARRAY);
            button.amount(5);
            button.type(ItemType.STONE);

            assertTrue(subscription.isCancelled());
            verifyNoInteractions(subscriber);
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
        void testDefaultName() {

            final Button button = Button.of(ItemType.STONE);

            assertEquals(Component.translatable(ItemType.STONE.translationKey()), button.name());
        }

        @Test
        void testNameWhenNameIsNull() {

            final Button button = Button.of(ItemType.STONE);

            button.name(null);

            assertEquals(Component.translatable(ItemType.STONE.translationKey()), button.name());
        }

        @Test
        void testName() {

            final Button button = Button.of(ItemType.STONE);

            assertEquals(button, button.name(NAME));
            assertEquals(NAME, button.name());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testVarargsLoreWhenLoreIsNull() {

            final Button button = Button.of(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore((Component[]) null));
            assertEquals("lore cannot be null", e.getMessage());

            assertNotNull(button.lore());
        }

        @Test
        void testVarargsLoreWhenLoreContainsNull() {

            final Button button = Button.of(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(LORE_LINE_1, null)));
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

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore((Component[]) null));
            assertEquals("lore cannot be null", e.getMessage());

            assertNotNull(button.lore());
        }

        @Test
        void testListLoreWhenLoreContainsNull() {

            final Button button = Button.of(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(LORE_LINE_1, null)));
            assertEquals("lore[1] cannot be null", e.getMessage());
        }

        @Test
        void testListLore() {

            final Button button = Button.of(ItemType.STONE);

            assertEquals(button, button.lore(LORE_LIST));
            assertEquals(LORE_LIST, button.lore());
        }

        @Test
        void testDefaultLoreLore() {

            final Button button = Button.of(ItemType.STONE);

            assertEquals(List.of(), button.lore());
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

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    button.amount(amount));
            assertEquals("amount must be between 1 and 64", e.getMessage());

            assertNotEquals(amount, button.amount());
        }

        @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
        @ParameterizedTest
        void testAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {

            final Button button = Button.of(ItemType.STONE);

            final Exception e = assertThrows(IllegalArgumentException.class, () ->
                    button.amount(amount));
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
            assertEquals(button.type(), ItemType.DIRT);
        }

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Button button = Button.of(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Button button = Button.of(ItemType.STONE);
            final Button.Subscriber subscriber = mock();

            button.subscribe(subscriber);

            button.name(NAME);
            verify(subscriber).name(NAME);

            button.lore(LORE_LIST);
            verify(subscriber).lore(LORE_LIST);

            button.lore(LORE_ARRAY);
            verify(subscriber, times(2)).lore(LORE_LIST);

            button.amount(5);
            verify(subscriber).amount(5);

            button.type(ItemType.STONE);
            verify(subscriber).type(ItemType.STONE);
        }

        @Test
        void testSubscriberThrowsException() {

            final Button button = Button.of(ItemType.STONE);
            final Button.Subscriber subscriber = mock();
            final RuntimeException e = new RuntimeException();

            button.subscribe(subscriber);

            doThrow(e).when(subscriber).name(NAME);
            button.name(NAME);
            verify(subscriber).name(NAME);
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).lore(LORE_LIST);
            button.lore(LORE_LIST);
            verify(subscriber).lore(LORE_LIST);
            verify(subscriber, times(2)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).lore(LORE_LIST);
            button.lore(LORE_ARRAY);
            verify(subscriber, times(2)).lore(LORE_LIST);
            verify(subscriber, times(3)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).amount(5);
            button.amount(5);
            verify(subscriber).amount(5);
            verify(subscriber, times(4)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).type(ItemType.STONE);
            button.type(ItemType.STONE);
            verify(subscriber).type(ItemType.STONE);
            verify(subscriber, times(5)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).exception(e);
            button.name(Component.text("name"));
            verify(subscriber, times(2)).name(Component.text("name"));
            verify(subscriber, times(6)).exception(e);
            verifyNoMoreInteractions(subscriber); // exception should not be called again
        }

        @Test
        void testCancelSubscription() {

            final Button button = Button.of(ItemType.STONE);
            final Button.Subscriber subscriber = mock();

            final Subscription subscription = button.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            button.name(NAME);
            button.lore(LORE_LIST);
            button.lore(LORE_ARRAY);
            button.amount(5);
            button.type(ItemType.STONE);

            assertTrue(subscription.isCancelled());
            verifyNoInteractions(subscriber);
        }
    }
}
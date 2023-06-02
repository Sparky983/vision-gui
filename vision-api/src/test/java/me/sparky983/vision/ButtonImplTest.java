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

class ButtonImplTest {

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

            assertEquals(builder, builder.name(Component.text("cool sword")));

            final Button button = builder.type(ItemType.DIAMOND_SWORD);

            assertEquals(Component.text("cool sword"), button.name());
        }

        @Test
        void testUnspecifiedName() {

            final Button button = Button.button()
                    .type(ItemType.STONE);

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

            assertEquals(button, button.name(Component.text("awesome item")));
            assertEquals(Component.text("awesome item"), button.name());
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
                    builder.lore(new Component[]{Component.text("line 1"), null}));
            assertEquals("lore[1] cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(Arrays.asList(Component.text("line 1"), null), button.lore());
        }

        @Test
        void testBuilderVarargsLore() {

            final Button.Builder builder = Button.button();

            assertEquals(builder, builder.lore(
                    Component.text("line 1"), Component.text("line 2")));

            final Button button = builder.type(ItemType.STONE);

            assertEquals(List.of(Component.text("line 1"), Component.text("line 2")),
                    button.lore());
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
                    button.lore(Arrays.asList(Component.text("line 1"), null)));
            assertEquals("lore[1] cannot be null", e.getMessage());

            assertNotEquals(Arrays.asList(Component.text("line 1"), null), button.lore());
        }

        @Test
        void testVarargsLore() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(button, button.lore(Component.text("line 1"), Component.text("line 2")));
            assertEquals(List.of(Component.text("line 1"), Component.text("line 2")),
                    button.lore());
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
                    builder.lore(Arrays.asList(Component.text("line 1"), null)));

            assertEquals("lore[1] cannot be null", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(Arrays.asList(Component.text("line 1"), null), button.lore());
        }

        @Test
        void testBuilderListLore() {

            final Button.Builder builder = Button.button();

            assertEquals(builder, builder.lore(
                    List.of(Component.text("line 1"), Component.text("line 2"))));

            final Button button = builder.type(ItemType.STONE);

            assertEquals(List.of(Component.text("line 1"), Component.text("line 2")),
                    button.lore());
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

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(Component.text("line 1"), null)));
            assertEquals("lore[1] cannot be null", e.getMessage());
        }

        @Test
        void testListLore() {

            final Button button = Button.button().type(ItemType.STONE);

            assertEquals(button,
                    button.lore(List.of(Component.text("line 1"), Component.text("line 2"))));
            assertEquals(List.of(Component.text("line 1"), Component.text("line 2")),
                    button.lore());
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

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> builder.amount(amount));
            assertEquals("amount must be between 1 and 64", e.getMessage());

            final Button button = builder.type(ItemType.STONE);
            assertNotEquals(amount, button.amount());
        }

        @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
        @ParameterizedTest
        void testBuilderAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {

            final Button.Builder builder = Button.button();

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> builder.amount(amount));
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

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
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

            final Button button = Button.button().type(ItemType.DIAMOND);

            assertEquals(ItemType.DIAMOND, button.type());
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testTypeWhenTypeIsNull() {

            final Button button = Button.button().type(ItemType.DIAMOND);

            final Exception e = assertThrows(NullPointerException.class, () -> button.type(null));
            assertEquals("type cannot be null", e.getMessage());

            assertNotNull(button.type());
        }

        @Test
        void testType() {

            final Button button = Button.button().type(ItemType.DIAMOND);

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

            button.name(Component.text("name"));
            verify(subscriber).name(Component.text("name"));

            button.lore(
                    List.of(Component.text("line 1"),
                            Component.text("line 2")));
            verify(subscriber)
                    .lore(
                            List.of(Component.text("line 1"),
                                    Component.text("line 2")));

            button.lore(Component.text("varargs line 1"),
                    Component.text("varargs line 2"));
            verify(subscriber)
                    .lore(
                            List.of(Component.text("varargs line 1"),
                                    Component.text("varargs line 2")));

            button.amount(5);
            verify(subscriber).amount(5);

            button.type(ItemType.DIAMOND);
            verify(subscriber).type(ItemType.DIAMOND);
        }

        @Test
        void testSubscriberThrowsException() {

            final Button button = Button.button().type(ItemType.STONE);
            final Button.Subscriber subscriber = mock();
            final RuntimeException e = new RuntimeException();

            button.subscribe(subscriber);

            doThrow(e).when(subscriber).name(Component.text("name"));
            button.name(Component.text("name"));
            verify(subscriber).name(Component.text("name"));
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber)
                    .lore(List.of(Component.text("line 1"),
                            Component.text("line 2")));
            button.lore(
                    List.of(Component.text("line 1"),
                            Component.text("line 2")));
            verify(subscriber)
                    .lore(List.of(Component.text("line 1"),
                            Component.text("line 2")));
            verify(subscriber, times(2)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber)
                    .lore(List.of(Component.text("varargs line 1"),
                            Component.text("varargs line 2")));
            button.lore(Component.text("varargs line 1"),
                    Component.text("varargs line 2"));
            verify(subscriber)
                    .lore(List.of(Component.text("varargs line 1"),
                            Component.text("varargs line 2")));
            verify(subscriber, times(3)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).amount(5);
            button.amount(5);
            verify(subscriber).amount(5);
            verify(subscriber, times(4)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).type(ItemType.DIAMOND);
            button.type(ItemType.DIAMOND);
            verify(subscriber).type(ItemType.DIAMOND);
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

            final Button button = Button.button().type(ItemType.STONE);
            final Button.Subscriber subscriber = mock();

            final Button.Subscription subscription = button.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            button.name(Component.text("name"));
            button.lore(
                    List.of(Component.text("line 1"),
                            Component.text("line 2")));
            button.lore(Component.text("varargs line 1"),
                    Component.text("varargs line 2"));
            button.amount(5);
            button.type(ItemType.DIAMOND);

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

            assertEquals(button, button.name(Component.text("awesome item")));
            assertEquals(Component.text("awesome item"), button.name());
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

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(Component.text("line 1"), null)));
            assertEquals("lore[1] cannot be null", e.getMessage());

            assertNotEquals(Arrays.asList(Component.text("line 1"), null), button.lore());
        }

        @Test
        void testVarargsLore() {

            final Button button = Button.of(ItemType.STONE);

            assertEquals(button, button.lore(Component.text("line 1"), Component.text("line 2")));
            assertEquals(List.of(Component.text("line 1"), Component.text("line 2")),
                    button.lore());
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

            final Exception e = assertThrows(NullPointerException.class, () ->
                    button.lore(Arrays.asList(Component.text("line 1"), null)));
            assertEquals("lore[1] cannot be null", e.getMessage());
        }

        @Test
        void testListLore() {

            final Button button = Button.of(ItemType.STONE);

            assertEquals(button,
                    button.lore(List.of(Component.text("line 1"), Component.text("line 2"))));
            assertEquals(List.of(Component.text("line 1"), Component.text("line 2")),
                    button.lore());
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

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
            assertEquals("amount must be between 1 and 64", e.getMessage());

            assertNotEquals(amount, button.amount());
        }

        @ValueSource(ints = {65, 66, Integer.MAX_VALUE})
        @ParameterizedTest
        void testAmountWhenAmountIsGreaterThanOrEqualTo64(final int amount) {

            final Button button = Button.of(ItemType.STONE);

            final Exception e =
                    assertThrows(IllegalArgumentException.class, () -> button.amount(amount));
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

            final Button button = Button.of(ItemType.DIAMOND);

            final Exception e = assertThrows(NullPointerException.class, () -> button.type(null));
            assertEquals("type cannot be null", e.getMessage());

            assertNotNull(button.type());
        }

        @Test
        void testType() {

            final Button button = Button.of(ItemType.DIAMOND);

            assertEquals(button, button.type(ItemType.DIRT));
            assertEquals(button.type(), ItemType.DIRT);
        }

        @SuppressWarnings("DataFlowIssue")
        @Test
        void testSubscribeWhenSubscriberIsNull() {

            final Button button = Button.of(ItemType.STONE);

            final Exception e = assertThrows(NullPointerException.class,
                    () -> button.subscribe(null));
            assertEquals("subscriber cannot be null", e.getMessage());
        }

        @Test
        void testSubscribe() {

            final Button button = Button.of(ItemType.STONE);
            final Button.Subscriber subscriber = mock();

            button.subscribe(subscriber);

            button.name(Component.text("name"));
            verify(subscriber).name(Component.text("name"));

            button.lore(
                    List.of(Component.text("line 1"),
                            Component.text("line 2")));
            verify(subscriber)
                    .lore(
                            List.of(Component.text("line 1"),
                                    Component.text("line 2")));

            button.lore(Component.text("varargs line 1"),
                    Component.text("varargs line 2"));
            verify(subscriber)
                    .lore(List.of(Component.text("varargs line 1"),
                            Component.text("varargs line 2")));

            button.amount(5);
            verify(subscriber).amount(5);

            button.type(ItemType.DIAMOND);
            verify(subscriber).type(ItemType.DIAMOND);
        }

        @Test
        void testSubscriberThrowsException() {

            final Button button = Button.of(ItemType.STONE);
            final Button.Subscriber subscriber = mock();
            final RuntimeException e = new RuntimeException();

            button.subscribe(subscriber);

            doThrow(e).when(subscriber).name(Component.text("name"));
            button.name(Component.text("name"));
            verify(subscriber).name(Component.text("name"));
            verify(subscriber).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber)
                    .lore(List.of(Component.text("line 1"),
                            Component.text("line 2")));
            button.lore(
                    List.of(Component.text("line 1"),
                            Component.text("line 2")));
            verify(subscriber)
                    .lore(List.of(Component.text("line 1"),
                            Component.text("line 2")));
            verify(subscriber, times(2)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber)
                    .lore(List.of(Component.text("varargs line 1"),
                            Component.text("varargs line 2")));
            button.lore(Component.text("varargs line 1"),
                    Component.text("varargs line 2"));
            verify(subscriber)
                    .lore(List.of(Component.text("varargs line 1"),
                            Component.text("varargs line 2")));
            verify(subscriber, times(3)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).amount(5);
            button.amount(5);
            verify(subscriber).amount(5);
            verify(subscriber, times(4)).exception(e);
            verifyNoMoreInteractions(subscriber);

            doThrow(e).when(subscriber).type(ItemType.DIAMOND);
            button.type(ItemType.DIAMOND);
            verify(subscriber).type(ItemType.DIAMOND);
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

            final Button.Subscription subscription = button.subscribe(subscriber);

            assertFalse(subscription.isCancelled());

            subscription.cancel();

            button.name(Component.text("name"));
            button.lore(
                    List.of(Component.text("line 1"),
                            Component.text("line 2")));
            button.lore(Component.text("varargs line 1"),
                    Component.text("varargs line 2"));
            button.amount(5);
            button.type(ItemType.DIAMOND);

            assertTrue(subscription.isCancelled());
            verifyNoInteractions(subscriber);
        }
    }
}

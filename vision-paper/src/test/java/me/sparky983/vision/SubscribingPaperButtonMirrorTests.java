package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class SubscribingPaperButtonMirrorTests {

    // COPIED FROM ButtonTests.java

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

    PaperItemTypeConverter itemTypeConverter;
    PaperButtonMirror paperButtonMirror;

    @BeforeEach
    void setUp() {

        itemTypeConverter = mock();
        paperButtonMirror = new SubscribingPaperButtonMirror(itemTypeConverter);
    }

    @AfterEach
    void tearDown() {

        verifyNoMoreInteractions(itemTypeConverter);
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testCreateWhenItemTypeConverterIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                new SubscribingPaperButtonMirror(null));

        assertEquals("itemTypeConverter cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testMirrorWhenButtonIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                paperButtonMirror.mirror(null, new ItemStack(Material.STONE)));

        assertEquals("button cannot be null", e.getMessage());
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void testMirrorWhenItemStackIsNull() {

        final Exception e = assertThrows(NullPointerException.class, () ->
                paperButtonMirror.mirror(Button.of(ItemType.STONE), null));

        assertEquals("item cannot be null", e.getMessage());
    }

    @Test
    void testMirrorWhenItemTypeCannotBeConverted() {

        when(itemTypeConverter.fromItemType(ItemType.STONE))
                .thenReturn(Optional.empty());

        final Button button = Button.of(ItemType.GRASS);
        final ItemStack item = new ItemStack(Material.GRASS);

        paperButtonMirror.mirror(button, item);

        button.type(ItemType.STONE);
        assertEquals(Material.GRASS, item.getType());

        verify(itemTypeConverter).fromItemType(ItemType.STONE);
    }

    @Disabled("Depends on a Paper API implementation")
    @Test
    void testMirror() {

        when(itemTypeConverter.fromItemType(ItemType.GRASS))
                .thenReturn(Optional.of(Material.GRASS));

        final Button button = Button.of(ItemType.STONE);
        final ItemStack item = new ItemStack(Material.STONE);

        paperButtonMirror.mirror(button, item);

        button.name(NAME);
        assertEquals(NAME, Component.empty()
                .style(PaperItemFactory.DEFAULT_STYLE)
                .append(item.displayName()));

        button.lore(LORE_ARRAY);
        assertEquals(List.of(
                Component.empty()
                        .style(PaperItemFactory.DEFAULT_STYLE)
                        .append(LORE_LINE_1),
                Component.empty()
                        .style(PaperItemFactory.DEFAULT_STYLE)
                        .append(LORE_LINE_2)), item.lore());

        button.lore(new Component[0]);

        button.lore(LORE_LIST);
        assertEquals(List.of(
                Component.empty()
                        .style(PaperItemFactory.DEFAULT_STYLE)
                        .append(LORE_LINE_1),
                Component.empty()
                        .style(PaperItemFactory.DEFAULT_STYLE)
                        .append(LORE_LINE_2)), item.lore());

        button.amount(2);
        assertEquals(2, item.getAmount());

        button.type(ItemType.GRASS);
        assertEquals(Material.GRASS, item.getType());

        verify(itemTypeConverter).fromItemType(ItemType.GRASS);
    }
}

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

import static me.sparky983.vision.CloningPaperItemFactory.DEFAULT_STYLE;
import static me.sparky983.vision.CloningPaperItemFactory.UNABLE_TO_MIRROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CloningPaperItemFactoryTest {

    PaperItemTypeConverter paperItemTypeConverter;
    PaperItemFactory buttonMirrorFactory;

    @BeforeEach
    void setUp() {

        paperItemTypeConverter = mock();
        buttonMirrorFactory = new CloningPaperItemFactory(paperItemTypeConverter);
    }

    @AfterEach
    void tearDown() {

        verifyNoMoreInteractions(paperItemTypeConverter);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testCreateWhenButtonIsNull() {

        final Exception e =
                assertThrows(NullPointerException.class, () -> buttonMirrorFactory.create(null));
        assertEquals("button cannot be null", e.getMessage());
    }

    @Test
    void testCreateWhenItemTypeCannotBeConverted() {

        when(paperItemTypeConverter.fromItemType(ItemType.STONE))
                .thenReturn(Optional.empty());

        final Button button = Button.of(ItemType.STONE);

        final Exception e = assertThrows(IllegalArgumentException.class, () ->
                buttonMirrorFactory.create(button));
        assertEquals(UNABLE_TO_MIRROR_MESSAGE.formatted(ItemType.STONE), e.getMessage());
        verify(paperItemTypeConverter).fromItemType(ItemType.STONE);
    }

    @Disabled("Depends on a Paper API implementation")
    @Test
    void testCreate() {

        when(paperItemTypeConverter.fromItemType(ItemType.STONE))
                .thenReturn(Optional.of(Material.STONE));

        final Button button = Button.button()
                .type(ItemType.STONE)
                .name(Component.text("name"))
                .lore(Component.text("lore"))
                .amount(64);

        final ItemStack item = buttonMirrorFactory.create(button);

        final ItemStack expectedItem = new ItemStack(Material.STONE, 64);
        expectedItem.editMeta((meta) -> {
            meta.displayName(Component.empty()
                    .style(DEFAULT_STYLE)
                    .append(Component.text("name")));
            meta.lore(List.of(
                    Component.empty()
                            .style(DEFAULT_STYLE)
                            .append(Component.text("lore"))));
        });
        assertEquals(expectedItem, item);
        verify(paperItemTypeConverter).fromItemType(ItemType.STONE);
    }
}

package me.sparky983.vision.paper;

import me.sparky983.vision.ItemType;
import org.bukkit.Material;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ModernPaperItemTypeConverterTests {
    static List<Arguments> provideConversions() {
        return List.of(
                Arguments.of(ItemType.STONE, Material.STONE),
                Arguments.of(ItemType.GRANITE, Material.GRANITE),
                Arguments.of(ItemType.DIORITE, Material.DIORITE),
                Arguments.of(ItemType.DIAMOND_SWORD, Material.DIAMOND_SWORD),
                Arguments.of(ItemType.COPPER_ORE, Material.COPPER_ORE)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testConvertWhenItemTypeIsNull() {
        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Exception e = assertThrows(NullPointerException.class, () ->
                itemTypeConverter.convert(null));

        assertEquals("itemType cannot be null", e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideConversions")
    void testConvert(final ItemType itemType, final Material expectedMaterial) {
        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<Material> material = itemTypeConverter.convert(itemType);

        assertEquals(Optional.of(expectedMaterial), material);
    }
}

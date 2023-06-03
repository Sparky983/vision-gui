package me.sparky983.vision;

import net.kyori.adventure.key.Key;
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

    @SuppressWarnings("deprecation")
    static List<Arguments> provideUnknownMaterials() {

        return List.of(
                Arguments.of(Material.AIR),
                Arguments.of(Material.LEGACY_DIAMOND),
                Arguments.of(Material.LEGACY_WOOL)
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

    @Test
    void testConvertWhenItemTypeCannotBeFound() {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<Material> material = itemTypeConverter.convert(
                ItemTypeImpl.of(Key.key("vision", "not_found"), true));

        assertEquals(Optional.empty(), material);
    }

    @ParameterizedTest
    @MethodSource("provideConversions")
    void testConvert(final ItemType itemType, final Material expectedMaterial) {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<Material> material = itemTypeConverter.convert(itemType);

        assertEquals(Optional.of(expectedMaterial), material);
    }
}

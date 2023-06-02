package me.sparky983.vision;

import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ModernPaperItemTypeConverterTest {

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
    void testFromItemTypeWhenItemTypeIsNull() {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Exception e = assertThrows(NullPointerException.class, () ->
                itemTypeConverter.fromItemType(null));

        assertEquals("itemType cannot be null", e.getMessage());
    }

    @Test
    void testFromItemTypeWhenItemTypeCannotBeFound() {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<Material> material = itemTypeConverter.fromItemType(
                ItemTypeImpl.of(Key.key("vision", "not_found"), true));

        assertEquals(Optional.empty(), material);
    }

    @ParameterizedTest
    @MethodSource("provideConversions")
    void testFromItemType(final ItemType itemType, final Material expectedMaterial) {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<Material> material = itemTypeConverter.fromItemType(itemType);

        assertEquals(Optional.of(expectedMaterial), material);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testToItemTypeWhenMaterialIsNull() {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Exception e = assertThrows(NullPointerException.class, () ->
                itemTypeConverter.fromMaterial(null));

        assertEquals("material cannot be null", e.getMessage());
    }

    @MethodSource("provideUnknownMaterials")
    @ParameterizedTest
    void testToItemTypeWhenItemTypeCannotBeFound() {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<ItemType> itemType = itemTypeConverter.fromMaterial(Material.AIR);

        assertEquals(Optional.empty(), itemType);
    }

    @ParameterizedTest
    @MethodSource("provideConversions")
    void testToItemType(final ItemType expectedItemType, final Material material) {

        final PaperItemTypeConverter itemTypeConverter = new ModernPaperItemTypeConverter();

        final Optional<ItemType> itemType = itemTypeConverter.fromMaterial(material);

        assertEquals(Optional.of(expectedItemType), itemType);
    }
}

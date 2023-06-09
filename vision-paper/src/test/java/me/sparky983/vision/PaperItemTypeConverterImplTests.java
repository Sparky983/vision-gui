package me.sparky983.vision;

import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import me.sparky983.vision.PaperItemTypeConverterImpl.Mode;

class PaperItemTypeConverterImplTests {

    @Nested
    class Modern {

        PaperItemTypeConverter itemTypeConverter;

        @BeforeEach
        void setUp() {

            itemTypeConverter = new PaperItemTypeConverterImpl(Mode.MODERN);
        }

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

            final Exception e = assertThrows(NullPointerException.class, () ->
                    itemTypeConverter.convert(null));

            assertEquals("itemType cannot be null", e.getMessage());
        }

        @Test
        void testConvertWhenItemTypeCannotBeFound() {

            final Optional<Material> material = itemTypeConverter.convert(
                    ItemTypeImpl.of(Key.key("vision", "not_found"), true));

            assertEquals(Optional.empty(), material);
        }

        @ParameterizedTest
        @MethodSource("provideConversions")
        void testConvert(final ItemType itemType, final Material expectedMaterial) {

            final Optional<Material> material = itemTypeConverter.convert(itemType);

            assertEquals(Optional.of(expectedMaterial), material);
        }
    }

    @Nested
    @Disabled("Depends on a Paper API implementation")
    class Legacy {

        PaperItemTypeConverter itemTypeConverter;

        @BeforeEach
        void setUp() {

            itemTypeConverter = new PaperItemTypeConverterImpl(Mode.LEGACY);
        }


        @SuppressWarnings("deprecation") // That's the point of this test
        static List<Arguments> provideLegacyConversions() {

            return List.of(
                    Arguments.of(ItemType.STONE, Material.LEGACY_STONE),
                    Arguments.of(ItemType.GRANITE, Material.LEGACY_DIAMOND_ORE),
                    Arguments.of(ItemType.DIORITE, Material.LEGACY_PAPER),
                    Arguments.of(ItemType.DIAMOND_SWORD, Material.LEGACY_DIAMOND_SWORD),
                    Arguments.of(ItemType.COPPER_ORE, Material.LEGACY_BEDROCK)
            );
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void testLegacyConvertWhenItemTypeIsNull() {

            final Exception e = assertThrows(NullPointerException.class, () ->
                    itemTypeConverter.convert(null));

            assertEquals("itemType cannot be null", e.getMessage());
        }

        @Test
        void testLegacyConvertWhenItemTypeCannotBeFound() {

            final Optional<Material> material = itemTypeConverter.convert(
                    ItemTypeImpl.of(Key.key("vision", "not_found"), true));

            assertEquals(Optional.empty(), material);
        }

        @ParameterizedTest
        @MethodSource("provideLegacyConversions")
        void testLegacyConvert(final ItemType itemType, final Material expectedMaterial) {

            final Optional<Material> material = itemTypeConverter.convert(itemType);

            assertEquals(Optional.of(expectedMaterial), material);
        }
    }
}

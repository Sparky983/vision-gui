package me.sparky983.vision;

import net.kyori.adventure.key.Key;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemTypeTest {

    static List<Arguments> provideItemTypesAndKey() {

        return List.of(
                Arguments.of(ItemType.STONE, Key.key("minecraft", "stone")),
                Arguments.of(ItemType.GRANITE, Key.key("minecraft", "granite")),
                Arguments.of(ItemType.DIORITE, Key.key("minecraft", "diorite")),
                Arguments.of(ItemType.ANDESITE, Key.key("minecraft", "andesite")),
                Arguments.of(ItemType.COPPER_ORE, Key.key("minecraft", "copper_ore"))
        );
    }

    @MethodSource("provideItemTypesAndKey")
    @ParameterizedTest
    void testItemTypeHasKey(final ItemType itemType, final Key key) {

        assertEquals(key, itemType.key());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testFindByKeyWhenKeyIsNull() {

        assertThrows(NullPointerException.class, () -> ItemType.findByKey(null));
    }

    @Test
    void testFindByKeyWhenKeyIsNotPresent() {

        assertEquals(Optional.empty(), ItemType.findByKey(Key.key("vision_test", "not_present")));
    }

    @MethodSource("provideItemTypesAndKey")
    @ParameterizedTest
    void testFindByKey(final ItemType itemType, final Key key) {

        assertEquals(Optional.of(itemType), ItemType.findByKey(key));
    }
}

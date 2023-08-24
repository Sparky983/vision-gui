package me.sparky983.vision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;
import net.kyori.adventure.key.Key;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ItemTypeTests {
  static List<Arguments> provideItemTypesAndKey() {
    return List.of(
        Arguments.of(ItemType.STONE, Key.key("minecraft", "stone")),
        Arguments.of(ItemType.GRANITE, Key.key("minecraft", "granite")),
        Arguments.of(ItemType.DIORITE, Key.key("minecraft", "diorite")),
        Arguments.of(ItemType.DIAMOND_SWORD, Key.key("minecraft", "diamond_sword")),
        Arguments.of(ItemType.COPPER_ORE, Key.key("minecraft", "copper_ore")));
  }

  static List<Arguments> provideItemTypesAndName() {
    return List.of(
        Arguments.of(ItemType.STONE, "block.minecraft.stone"),
        Arguments.of(ItemType.GRANITE, "block.minecraft.granite"),
        Arguments.of(ItemType.DIORITE, "block.minecraft.diorite"),
        Arguments.of(ItemType.DIAMOND_SWORD, "item.minecraft.diamond_sword"),
        Arguments.of(ItemType.COPPER_ORE, "block.minecraft.copper_ore"));
  }

  @MethodSource("provideItemTypesAndKey")
  @ParameterizedTest
  void testItemTypeHasKey(final ItemType itemType, final Key key) {
    assertEquals(key, itemType.key());
  }

  @MethodSource("provideItemTypesAndName")
  @ParameterizedTest
  void testItemTranslationKey(final ItemType itemType, final String translationKey) {
    assertEquals(translationKey, itemType.translationKey());
  }

  @SuppressWarnings("ConstantConditions")
  @Test
  void testFindByKeyWhenKeyIsNull() {
    final Exception e = assertThrows(NullPointerException.class, () -> ItemType.findByKey(null));

    assertEquals("key cannot be null", e.getMessage());
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

  @MethodSource("provideItemTypesAndKey")
  @ParameterizedTest
  void testToString(final ItemType itemType, final Key key) {
    assertEquals(key.asString(), itemType.toString());
  }
}

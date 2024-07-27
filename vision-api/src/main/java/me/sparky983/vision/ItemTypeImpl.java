package me.sparky983.vision;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import net.kyori.adventure.key.Key;
import org.jspecify.annotations.NullMarked;

/**
 * The default implementation of {@link ItemType}.
 */
@NullMarked
record ItemTypeImpl(Key key, boolean isBlock) implements ItemType {
  private static final HashMap<Key, ItemType> itemTypes = new HashMap<>();

  /**
   * Constructs a new {@code ItemTypeImpl}.
   *
   * @param key the key
   * @param isBlock whether the item type is a block
   * @throws NullPointerException if the key is {@code null}
   */
  ItemTypeImpl {
    Objects.requireNonNull(key, "key cannot be null");
  }

  /**
   * Creates a new {@link ItemType} for the given {@link Key}.
   *
   * @param key the key
   * @param isBlock whether the {@link ItemType} is a block
   * @return the new {@link ItemType}
   * @throws NullPointerException if the key is {@code null}.
   */
  static ItemType of(final Key key, final boolean isBlock) {
    final ItemType item = new ItemTypeImpl(key, isBlock);
    itemTypes.put(key, item);
    return item;
  }

  /**
   * Finds an {@link ItemType} by its key.
   *
   * @param key the key
   * @return the found {@link ItemType} or {@link Optional#empty()} if no {@link ItemType} by the
   * specified id was found
   * @throws NullPointerException if the key is {@code null}.
   */
  static Optional<ItemType> findByKey(final Key key) {
    Objects.requireNonNull(key, "key cannot be null");

    return Optional.ofNullable(itemTypes.get(key));
  }

  @Override
  public String translationKey() {
    final String category = isBlock ? "block." : "item.";
    return category + key.namespace() + "." + key.value().replace('/', '.');
  }

  @Override
  public String toString() {
    return key.asString();
  }
}

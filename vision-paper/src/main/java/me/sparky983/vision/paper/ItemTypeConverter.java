package me.sparky983.vision.paper;

import java.util.Objects;
import java.util.Optional;
import me.sparky983.vision.ItemType;
import org.bukkit.Material;
import org.jspecify.annotations.NullMarked;

/**
 * Converts {@link ItemType} to {@link Material}.
 */
@NullMarked
final class ItemTypeConverter {
  /**
   * Converts the specified {@link ItemType} to a {@link Material}.
   *
   * @param itemType the item type
   * @return the material or {@link Optional#empty()} if the material could not be found
   * @throws NullPointerException if the item type is {@code null}.
   */
  public Optional<Material> convert(final ItemType itemType) {
    Objects.requireNonNull(itemType, "itemType cannot be null");

    return Optional.ofNullable(Material.matchMaterial(itemType.key().asString()));
  }
}

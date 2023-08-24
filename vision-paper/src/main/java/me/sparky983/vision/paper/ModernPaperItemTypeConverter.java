package me.sparky983.vision.paper;

import java.util.Objects;
import java.util.Optional;
import me.sparky983.vision.ItemType;
import org.bukkit.Material;
import org.jspecify.annotations.NullMarked;

/**
 * The {@link PaperItemTypeConverter} implementation for non-legacy Paper API versions.
 */
@NullMarked
final class ModernPaperItemTypeConverter implements PaperItemTypeConverter {
  @Override
  public Optional<Material> convert(final ItemType itemType) {
    Objects.requireNonNull(itemType, "itemType cannot be null");

    return Optional.ofNullable(Material.matchMaterial(itemType.key().asString()));
  }
}

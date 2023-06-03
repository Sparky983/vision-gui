package me.sparky983.vision;

import org.bukkit.Material;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.Optional;

/**
 * The {@link PaperItemTypeConverter} implementation for non-legacy Paper API versions.
 */
@NullMarked
final class ModernPaperItemTypeConverter implements PaperItemTypeConverter {

    // TODO(Sparky983): Legacy implementation

    @Override
    public Optional<Material> convert(final ItemType itemType) {

        Objects.requireNonNull(itemType, "itemType cannot be null");

        return Optional.ofNullable(Material.matchMaterial(itemType.key().asString()));
    }

    @Override
    public Optional<ItemType> fromMaterial(final Material material) {

        Objects.requireNonNull(material, "material cannot be null");

        return ItemType.findByKey(material.key());
    }
}

package me.sparky983.vision;

import org.bukkit.Material;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.Optional;

/**
 * The {@link PaperItemTypeConverter} implementation for non-legacy Paper API versions.
 */
@NullMarked
final class PaperItemTypeConverterImpl implements PaperItemTypeConverter {

    private final Mode mode;

    PaperItemTypeConverterImpl(final Mode mode) {

        Objects.requireNonNull(mode, "mode cannot be null");

        this.mode = mode;
    }

    @Override
    public Optional<Material> convert(final ItemType itemType) {

        Objects.requireNonNull(itemType, "itemType cannot be null");

        return Optional.ofNullable(
                Material.matchMaterial(itemType.key().asString(), mode == Mode.LEGACY));
    }

    enum Mode {

        MODERN,
        LEGACY
    }
}

package me.sparky983.vision.paper;

import org.bukkit.Material;
import org.jspecify.nullness.NullMarked;

import java.util.Optional;

import me.sparky983.vision.ItemType;

/**
 * Converts {@link ItemType} to {@link Material} and vice versa.
 */
@NullMarked
interface PaperItemTypeConverter {

    /**
     * Converts the specified {@link ItemType} to a {@link Material}.
     *
     * @param itemType the item type
     * @return the material or {@link Optional#empty()} if the material could not be found
     * @throws NullPointerException if the item type is {@code null}.
     */
    Optional<Material> convert(ItemType itemType);
}

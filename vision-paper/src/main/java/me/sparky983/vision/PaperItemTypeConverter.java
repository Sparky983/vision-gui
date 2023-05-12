package me.sparky983.vision;

import org.bukkit.Material;
import org.jspecify.nullness.NullMarked;

import java.util.Optional;

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
    Optional<Material> fromItemType(ItemType itemType);

    /**
     * Converts the specified {@link Material} to an {@link ItemType}.
     * <p>
     * If the given material is {@link Material#AIR} or any legacy material,
     * {@link Optional#empty()} will be returned.
     *
     * @param material the material
     * @return the item type or {@link Optional#empty()} if the item type could not be found
     * @throws NullPointerException if the material is {@code null}.
     */
    Optional<ItemType> fromMaterial(Material material);
}

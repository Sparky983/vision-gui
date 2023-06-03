package me.sparky983.vision;

import org.bukkit.inventory.Inventory;
import org.jspecify.nullness.NullMarked;

/**
 * Mirrors {@link Gui} to {@link Inventory Inventories}.
 */
@NullMarked
interface PaperInventoryMirror {

    /**
     * Mirrors the specified {@link Gui} to the specified {@link Inventory}.
     *
     * @param gui the gui to be mirrored
     * @return the mirroring inventory
     * @throws NullPointerException if the gui or the inventory is {@code null}.
     */
    Inventory mirror(Gui gui);
}

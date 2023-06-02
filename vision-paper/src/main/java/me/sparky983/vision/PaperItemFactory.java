package me.sparky983.vision;

import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

/**
 * Creates {@link ItemStack ItemStacks} that mirror {@link Button Buttons}.
 */
@NullMarked
interface PaperItemFactory {

    /**
     * Creates a new {@link ItemStack} that mirrors the specified {@link Button}.
     *
     * @param button the button to be mirrored
     * @return the mirroring item stack
     * @throws IllegalArgumentException if the item type cannot be converted.
     * @throws NullPointerException if the item stack is null.
     */
    ItemStack mirror(Button button);
}

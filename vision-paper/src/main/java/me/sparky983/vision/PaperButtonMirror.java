package me.sparky983.vision;

import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

/**
 * Mirrors {@link Button Buttons} to {@link ItemStack ItemStacks}.
 */
@NullMarked
interface PaperButtonMirror {

    /**
     * Mirrors all the changes to the specified {@link Button} to the specified {@link ItemStack}.
     *
     * @param button the button to be mirrored
     * @param item the item stack to be mirrored to
     * @throws NullPointerException if the button or the item is {@code null}.
     */
    void mirror(Button button, ItemStack item);
}
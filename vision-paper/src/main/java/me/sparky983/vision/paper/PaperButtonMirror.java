package me.sparky983.vision.paper;

import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;
import me.sparky983.vision.Button;

/**
 * Mirrors {@link Button Buttons} to {@link ItemStack ItemStacks}.
 */
@NullMarked
interface PaperButtonMirror {

    /**
     * Mirrors all the changes to the specified {@link Button} to the specified {@link ItemStack}.
     * <p>
     * The button is a parameter because we need to mirror buttons that weren't created by us.
     *
     * @param button the button to be mirrored
     * @param item the item stack to be mirrored to
     * @throws NullPointerException if the button or the item is {@code null}.
     */
    void mirror(Button button, ItemStack item);
}

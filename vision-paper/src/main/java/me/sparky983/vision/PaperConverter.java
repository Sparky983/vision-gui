package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.Optional;

/**
 * Converts Vision types to Paper types.
 */
@NullMarked
interface PaperConverter extends PaperItemTypeConverter {

    /**
     * Converts a {@link Button} to an {@link ItemStack}.
     *
     * @param button the button to be converted
     * @return the converted item stack or {@link Optional#empty()} if the item type could not be
     * converted
     * @throws NullPointerException if the item stack is {@code null}.
     */
    Optional<ItemStack> convert(Button button);

    /**
     * Converts a {@link Component} to a {@link Component} that can be used in an item.
     *
     * @param component the component to be converted
     * @return the converted component
     * @throws NullPointerException if the component is {@code null}.
     */
    Component convert(Component component);
}

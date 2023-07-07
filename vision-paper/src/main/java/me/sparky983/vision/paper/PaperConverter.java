package me.sparky983.vision.paper;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.Locale;
import java.util.Optional;

import me.sparky983.vision.Button;

/**
 * Converts Vision types to Paper types.
 */
@NullMarked
interface PaperConverter extends PaperItemTypeConverter {

    /**
     * Converts a {@link Button} to an {@link ItemStack}.
     *
     * @param button the button to be converted
     * @param locale the locale to render {@link Component Components} with
     * @return the converted item or {@link Optional#empty()} if the item type could not be
     * converted
     * @throws NullPointerException if the button or the locale is {@code null}.
     */
    Optional<ItemStack> convert(Button button, Locale locale);

    /**
     * Converts a {@link Component} to a {@link Component} that can be used in an item.
     *
     * @param component the component to be converted
     * @param locale the locale to render {@link Component Components} with
     * @return the converted component
     * @throws NullPointerException if the component or the locale is {@code null}.
     */
    Component convert(Component component, Locale locale);
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.List;

/**
 * Represents a button.
 *
 * @see #button()
 * @see #of(ItemType)
 * @since 0.1
 */
@NullMarked
public interface Button {

    /**
     * Creates a new button builder.
     *
     * @return the newly created button builder
     * @see Builder
     * @see #of(ItemType)
     * @since 0.1
     */
    static Builder button() {

        return new ButtonImpl.BuilderImpl();
    }

    /**
     * Creates a new button of the specified type.
     *
     * @param type the type of the button
     * @return the newly created button
     * @see #button()
     * @since 0.1
     */
    static Button of(final ItemType type) {

        return button().type(type);
    }

    /**
     * Sets the name of this button.
     *
     * @param name the name or {@code null} to remove the name
     * @return this button instance (for chaining)
     * @since 0.1
     */
    Button name(@Nullable Component name);

    /**
     * Gets the name of this button.
     * <p>
     * If this button is untitled, the returned component will match Minecraft's default item name
     * which is usually a translatable component of the form {@literal "item.minecraft.<item_id>}
     * or {@code literal "block.minecraft.<item_id>}.
     *
     * @return the name of this button
     * @since 0.1
     */
    Component name();

    /**
     * Sets the lore of this button.
     * <p>
     * Changes to the input array will not be reflected in the lore of this button.
     *
     * @param lore the lore or an empty array to remove the lore
     * @return this button instance (for chaining)
     * @throws NullPointerException if the lore is or contains {@code null}.
     * @since 0.1
     */
    Button lore(Component... lore);

    /**
     * Sets the lore of this button.
     * <p>
     * Changes to the input list will not be reflected in the lore of this button.
     *
     * @param lore the lore or an empty array to remove the lore
     * @return this button instance (for chaining)
     * @throws NullPointerException if the lore is or contains {@code null}.
     * @since 0.1
     */
    Button lore(List<Component> lore);

    /**
     * Gets the lore of this button.
     *
     * @return an unmodifiable list containing the lore of this button or an empty list if no lore
     * is set
     * @since 0.1
     */
    List<Component> lore();

    /**
     * Sets the amount of items in this button.
     *
     * @param amount the amount
     * @return this button instance (for chaining)
     * @throws IllegalArgumentException if the amount is less than {@code 1} or greater than
     * {@code 64}.
     * @since 0.1
     */
    Button amount(int amount);

    /**
     * Gets the amount items in this button.
     *
     * @return the amount of items in this button
     * @since 0.1
     */
    int amount();

    /**
     * Sets the type of this button.
     *
     * @param type the type or {@code null} to remove the type
     * @return this button instance (for chaining)
     * @throws NullPointerException if the type is {@code null}.
     * @since 0.1
     */
    Button type(ItemType type);

    /**
     * Gets the type of this button.
     *
     * @return the type of this button
     * @since 0.1
     */
    ItemType type();

    /**
     * Compares this button to another button, ignoring the {@link #amount()}.
     *
     * @param other the button to compare with this button
     * @return whether this and the other button are equal
     * @see #equals(Object)
     * @since 0.1
     */
    @ApiStatus.Experimental // name may be changed in the future
    boolean equalsIgnoreAmount(Button other);

    /**
     * A typesafe button builder.
     * <p>
     * To build the button, use {@link #type(ItemType)}.
     * <p>
     * Examples:
     * <pre>
     * Button button = Button.button()
     *         .name(Component.text("Stone"))
     *         .type(ItemType.STONE); // builds the button
     * </pre>
     * <pre>
     * Button button = Button.button()
     *          .type(ItemType.STONE) // builds the button
     *          .lore(Component.text("Line 1"), Component.text("Line 2"));
     * </pre>
     *
     * @see #button()
     * @see #type(ItemType)
     * @since 0.1
     */
    interface Builder {

        /**
         * Specifies the name of the button.
         *
         * @param name the name
         * @return this button instance (for chaining)
         * @throws NullPointerException if the name is {@code null}.
         * @since 0.1
         */
        Builder name(Component name);

        /**
         * Specifies the lore of the button.
         * <p>
         * Changes to the input array will not be reflected in the lore of the button.
         *
         * @param lore the lore
         * @return this button instance (for chaining)
         * @throws NullPointerException if the lore is or contains {@code null}.
         * @since 0.1
         */
        Builder lore(Component... lore);

        /**
         * Specifies the lore of the button.
         * <p>
         * Changes to the input list will not be reflected in the lore of the button.
         *
         * @param lore the lore
         * @return this button instance (for chaining)
         * @throws NullPointerException if the lore is or contains {@code null}.
         * @since 0.1
         */
        Builder lore(List<Component> lore);

        /**
         * Specifies the amount of items in the button.
         *
         * @param amount the amount
         * @return this button instance (for chaining)
         * @throws IllegalArgumentException if the amount is less than {@code 1} or greater than
         * {@code 64}.
         * @since 0.1
         */
        Builder amount(int amount);

        /**
         * Specifies the type of the button and returns the built button.
         *
         * @param item the item type
         * @return the new button
         * @throws NullPointerException if the item type is {@code null}.
         * @since 0.1
         */
        Button type(ItemType item);
    }
}

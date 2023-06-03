package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents a button.
 *
 * @see #button()
 * @see #of(ItemType)
 * @since 0.1
 */
@NullMarked
public interface Button extends Subscribable<Button.Subscriber> {

    /**
     * Creates a new {@link Button.Builder}.
     *
     * @return the new {@link Button.Builder}
     * @see Builder
     * @see #of(ItemType)
     * @since 0.1
     */
    static Builder button() {

        return new ButtonImpl.BuilderImpl();
    }

    /**
     * Creates a new {@code Button} of the specified type.
     *
     * @param type the type of the {@code Button}
     * @return the created {@code Button}
     * @throws NullPointerException if the type is {@code null}.
     * @see #button()
     * @since 0.1
     */
    static Button of(final ItemType type) {

        return button().type(type);
    }

    /**
     * Sets the name of this {@code Button}.
     *
     * @param name the name or {@code null} to remove the name
     * @return this {@code Button} instance (for chaining)
     * @since 0.1
     */
    Button name(@Nullable Component name);

    /**
     * Gets the name of this {@code Button}.
     * <p>
     * If this {@code Button} is untitled, the returned {@code Component} will match Minecraft's
     * default item name which is usually a translatable component of the form
     * {@literal "item.minecraft.<item_id>} or {@code literal "block.minecraft.<item_id>}.
     *
     * @return the name of this {@code Button}
     * @since 0.1
     */
    Component name();

    /**
     * Sets the lore of this {@code Button}.
     * <p>
     * Changes to the input array will not be reflected in the lore of this {@code Button}.
     *
     * @param lore the lore or an empty array to remove the lore
     * @return this {@code Button} instance (for chaining)
     * @throws NullPointerException if the lore is or contains {@code null}.
     * @since 0.1
     */
    Button lore(Component... lore);

    /**
     * Sets the lore of this {@code Button}.
     * <p>
     * Changes to the input {@link List} will not be reflected in the lore of this {@code Button}.
     *
     * @param lore the lore or an empty {@link List} to remove the lore
     * @return this {@code Button} instance (for chaining)
     * @throws NullPointerException if the lore is or contains {@code null}.
     * @since 0.1
     */
    Button lore(List<Component> lore);

    /**
     * Gets the lore of this {@code Button}.
     *
     * @return an unmodifiable {@link List} containing the lore of this button or an empty
     * {@link List} if no lore is set
     * @since 0.1
     */
    List<Component> lore();

    /**
     * Sets the amount of items in this {@code Button}.
     *
     * @param amount the amount
     * @return this {@code Button} instance (for chaining)
     * @throws IllegalArgumentException if the amount is less than {@code 1} or greater than
     * {@code 64}.
     * @since 0.1
     */
    Button amount(int amount);

    /**
     * Gets the amount items in this {@code Button}.
     *
     * @return the amount of items in this {@code Button}
     * @since 0.1
     */
    int amount();

    /**
     * Sets the type of this {@code Button}.
     *
     * @param type the type
     * @return this {@code Button} instance (for chaining)
     * @throws NullPointerException if the type is {@code null}.
     * @since 0.1
     */
    Button type(ItemType type);

    /**
     * Gets the type of this {@code Button}.
     *
     * @return the type of this {@code Button}
     * @since 0.1
     */
    ItemType type();

    /**
     * Clicks this {@code Button}.
     * <p>
     * This method is called by the {@link Vision} when this button is clicked.
     *
     * @param click an object describing the click
     * @throws NullPointerException if the click is {@code null}.
     * @since 0.1
     */
    void click(Click click);

    /**
     * Subscribes the specified {@link Click} handler to this button.
     *
     * @param handler the {@link Click} handler
     * @return the {@code Button} instance (for chaining)
     * @throws NullPointerException if the {@link Click} handler is {@code null}.
     * @since 0.1
     */
    Button onClick(Consumer<Click> handler);

    /**
     * Subscribes the specified subscriber to this {@code Button}.
     *
     * @param subscriber the subscriber
     * @return a {@code Subscription} that can be used to unsubscribe the subscriber
     * @throws NullPointerException if the subscriber is {@code null}.
     * @since 0.1
     */
    Subscription subscribe(Subscriber subscriber);

    /**
     * Represents a subscriber to a {@link Button}.
     *
     * @see #subscribe(Subscriber)
     * @since 0.1
     */
    interface Subscriber extends Subscribable.Subscriber {

        /**
         * Called when the name of a {@link Button} changes.
         *
         * @param name the new name
         * @throws NullPointerException if the name is {@code null} (optional).
         * @see #name(Component)
         * @since 0.1
         */
        void name(Component name);

        /**
         * Called when the lore of a {@link Button} changes.
         *
         * @param lore the new lore
         * @throws NullPointerException if the lore is or contains {@code null} (optional).
         * @see #lore(List)
         * @see #lore(Component...)
         * @since 0.1
         */
        void lore(List<Component> lore);

        /**
         * Called when the amount of the {@link Button} changes.
         *
         * @param amount the new amount
         * @throws IllegalArgumentException if the amount is less than {@code 1} or greater than
         * {@code 64} (optional).
         * @see #amount(int)
         * @since 0.1
         */
        void amount(int amount);

        /**
         * Called when the type of the {@link Button} changes.
         *
         * @param type the new type
         * @throws NullPointerException if the type is {@code null} (optional).
         * @see #type(ItemType)
         * @since 0.1
         */
        void type(ItemType type);

        /**
         * Called when the {@link Button} is clicked.
         *
         * @param click an object describing the click
         * @throws NullPointerException if the click is {@code null} (optional).
         * @see #click(Click)
         * @since 0.1
         */
        void click(Click click);
    }

    /**
     * A {@link Button} builder.
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
     *         .type(ItemType.STONE) // builds the button
     *         .lore(Component.text("Line 1"), Component.text("Line 2"));
     * </pre>
     *
     * @see #button()
     * @see #type(ItemType)
     * @since 0.1
     */
    interface Builder {

        /**
         * Specifies the name of the {@link Button}.
         *
         * @param name the name
         * @return this {@code Builder} instance (for chaining)
         * @throws NullPointerException if the name is {@code null}.
         * @since 0.1
         */
        Builder name(Component name);

        /**
         * Specifies the lore of the {@link Button}.
         * <p>
         * Changes to the input array will not be reflected in the lore of the button.
         *
         * @param lore the lore
         * @return this {@code Builder} instance (for chaining)
         * @throws NullPointerException if the lore is or contains {@code null}.
         * @since 0.1
         */
        Builder lore(Component... lore);

        /**
         * Specifies the lore of the {@link Button}.
         * <p>
         * Changes to the input {@link List} will not be reflected in the lore of the button.
         *
         * @param lore the lore
         * @return this {@code Builder} instance (for chaining)
         * @throws NullPointerException if the lore is or contains {@code null}.
         * @since 0.1
         */
        Builder lore(List<Component> lore);

        /**
         * Specifies the amount of items in the {@link Button}.
         *
         * @param amount the amount
         * @return this {@code Builder} instance (for chaining)
         * @throws IllegalArgumentException if the amount is less than {@code 1} or greater than
         * {@code 64}.
         * @since 0.1
         */
        Builder amount(int amount);

        /**
         * Adds a {@link Click} handler to the button {@link Button}.
         *
         * @param handler the {@link Click} handler
         * @return the {@code Builder} instance (for chaining)
         * @throws NullPointerException if the {@link Click} handler is {@code null}.
         * @since 0.1
         */
        Builder onClick(Consumer<Click> handler);

        /**
         * Specifies the type of the {@link Button} and returns the built {@link Button}.
         *
         * @param type the item type
         * @return the new {@link Button}
         * @throws NullPointerException if the item type is {@code null}.
         * @since 0.1
         */
        Button type(ItemType type);
    }
}

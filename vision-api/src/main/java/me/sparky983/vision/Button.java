package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents a button.
 *
 * @see #of(ItemType)
 * @since 0.1
 * @vision.apiNote Unlike Bukkit, {@code Button}s aren't cloned when they're added to a {@link Gui},
 * meaning you can always mutate the {@code Button} and have the mutation be reflected in the
 * {@link Gui}.
 */
@NullMarked
public interface Button extends Subscribable<Button.Subscriber> {

    /**
     * Creates a new {@code Button} of the specified type.
     *
     * @param type the type of the {@code Button}
     * @return the created {@code Button}
     * @throws NullPointerException if the type is {@code null}.
     * @since 0.1
     * @vision.examples <pre>
     *Button button = Button.of(ItemTypes.DIAMOND)
     *        .name(Component.text("My Button"))
     *        .lore(Component.text("My lore line 1"), Component.text("My lore line 2"));</pre>
     */
    static Button of(final ItemType type) {

        return new ButtonImpl(type);
    }

    /**
     * Creates a new {@link Button.Factory}.
     *
     * @return the new {@link Button.Factory}
     * @see Factory
     * @see #of(ItemType)
     * @since 1.0
     * @vision.experimental because this may be deleted or repurposed. Use {@link #of(ItemType)}
     * when possible.
     * @vision.examples <pre>
     *Button button = Button.button()
     *        .type(ItemTypes.DIAMOND)
     *        .name(Component.text("My Button"))
     *        .lore(Component.text("My lore line 1"), Component.text("My lore line 2"));</pre>
     */
    @ApiStatus.Experimental
    static Factory button() {

        return ButtonImpl.FACTORY;
    }

    /**
     * Sets the name of this {@code Button}.
     *
     * @param name the name or {@code null} to remove the name
     * @return this {@code Button} instance (for chaining)
     * @since 0.1
     * @vision.implNote The Paper Vision implementation removes the default Minecraft display name
     * style (italics).
     */
    Button name(@Nullable Component name);

    /**
     * Returns the name of this {@code Button}.
     * <p>
     * If this {@code Button} is untitled, the returned {@link Component} will match Minecraft's
     * default item name which is usually a translatable component of the form
     * {@literal "item.minecraft.<item_id>"} or {@literal "block.minecraft.<item_id>"}.
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
     * @vision.implNote The Paper Vision implementation removes the default Minecraft lore style
     * (purple, italics).
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
     * @vision.implNote The Paper Vision implementation removes the default Minecraft lore style
     * (purple, italics).
     */
    Button lore(List<Component> lore);

    /**
     * Returns the lore of this {@code Button}.
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
     * Returns the amount items in this {@code Button}.
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
     * Returns the type of this {@code Button}.
     *
     * @return the type of this {@code Button}
     * @since 0.1
     */
    ItemType type();

    /**
     * Clicks this {@code Button}.
     * <p>
     * This method is called by Vision when this button is clicked.
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
     * @vision.apiNote This method may be called multiple times to add multiple handlers.
     * @vision.examples <pre>
     *{@code Button button = Button.button()
     *        .name(Component.text("Click me!"))
     *        .type(ItemType.DIAMOND);
     *        .onClick(click -> click.clicker().sendMessage(Component.text("You clicked me!")))}</pre>
     */
    Button onClick(Consumer<Click> handler);

    /**
     * Subscribes the specified {@link Subscriber} to this {@code Button}.
     *
     * @param subscriber the subscriber
     * @return a {@link Subscription} that can be used to unsubscribe the subscriber
     * @throws NullPointerException if the subscriber is {@code null}.
     * @since 0.1
     * @vision.examples <pre>
     *{@code Button button = ...;
     *button.subscribe(new Button.Subscriber() {
     *    public void name(Component name) {
     *        System.out.println("Name updated");
     *    }
     *    public void lore(List<Component> lore) {
     *        System.out.println("Lore updated");
     *    }
     *    public void amount(int amount) {
     *        System.out.println("Amount updated");
     *    }
     *    public void type(ItemType type) {
     *        System.out.println("Type updated");
     *    }
     *    public void click(Click click) {
     *    }
     *    public void exception(RuntimeException thrown) {
     *    }
     *})}</pre>
     */
    @Override
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
     * A {@link Button} factory.
     *
     * @see #button()
     * @see #type(ItemType)
     * @since 1.0
     * @vision.experimental because this may be deleted or repurposed.
     * @vision.apiNote This class is designed to improve readability by requiring the type parameter
     * to be named in source code.
     * @vision.examples <pre>
     *{@literal // With factory}
     *Button button = Button.button()
     *        .type(ItemType.STONE)
     *        .name(Component.text("Stone"));
     *
     *{@literal // Without factory}
     *Button button = Button.of(ItemType.STONE)
     *        .name(Component.text("Stone"));</pre>
     */
    @FunctionalInterface
    @ApiStatus.Experimental
    interface Factory {

        /**
         * Creates a new {@code Button} of the specified type.
         *
         * @param type the item type
         * @return the new {@link Button}
         * @throws NullPointerException if the item type is {@code null}.
         * @since 1.0
         */
        Button type(ItemType type);
    }
}

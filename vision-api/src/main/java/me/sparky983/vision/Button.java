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
 * @vision.apiNote Unlike Bukkit, {@code Button}s aren't cloned when they're added to a {@link Gui},
 * meaning you can always mutate the {@code Button} and have the mutation be reflected in the
 * {@link Gui}.
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
     * @vision.apiNote The builder is type-safe, so it cannot be built until the
     * {@link Button.Builder#type(ItemType)} has been specified.
     * @vision.examples <pre>
     *Button button = Button.button()
     *        .name(Component.text("My Button"))
     *        .lore(Component.text("My lore line 1"), Component.text("My lore line 2"))
     *        .type(ItemTypes.DIAMOND);</pre>
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
     * @vision.examples <pre>
     *Button button = Button.of(ItemTypes.DIAMOND)
     *        .name(Component.text("My Button"))
     *        .lore(Component.text("My lore line 1"), Component.text("My lore line 2"));</pre>
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
     * @vision.implNote The Paper Vision implementation removes the default Minecraft display name
     * style (italics).
     */
    Button name(@Nullable Component name);

    /**
     * Returns the name of this {@code Button}.
     * <p>
     * If this {@code Button} is untitled, the returned {@code Component} will match Minecraft's
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
     * A {@link Button} builder.
     *
     * @see #button()
     * @see #type(ItemType)
     * @since 0.1
     * @vision.apiNote This builder is type-safe, so it cannot be built until the
     * {@link Builder#type(ItemType)} has been specified.
     * @vision.examples <pre>
     *Button button = Button.button()
     *        .name(Component.text("Stone"))
     *        .type(ItemType.STONE); // builds the button</pre>
     * <pre>
     *Button button = Button.button()
     *        .type(ItemType.STONE) // builds the button
     *        .lore(Component.text("Line 1"), Component.text("Line 2"));</pre>
     */
    interface Builder {

        /**
         * Sets the name of the {@link Button}.
         *
         * @param name the name
         * @return this {@code Builder} instance (for chaining)
         * @throws NullPointerException if the name is {@code null}.
         * @since 0.1
         * @vision.implNote The Paper Vision implementation removes the default Minecraft display
         * name style (italics).
         */
        Builder name(Component name);

        /**
         * Sets the lore of the {@link Button}.
         * <p>
         * Changes to the input array will not be reflected in the lore of the button.
         *
         * @param lore the lore
         * @return this {@code Builder} instance (for chaining)
         * @throws NullPointerException if the lore is or contains {@code null}.
         * @since 0.1
         * @vision.implNote The Paper Vision implementation removes the default Minecraft lore style
         * (purple, italics).
         */
        Builder lore(Component... lore);

        /**
         * Sets the lore of the {@link Button}.
         * <p>
         * Changes to the input {@link List} will not be reflected in the lore of the button.
         *
         * @param lore the lore
         * @return this {@code Builder} instance (for chaining)
         * @throws NullPointerException if the lore is or contains {@code null}.
         * @since 0.1
         * @vision.implNote The Paper Vision implementation removes the default Minecraft lore style
         * (purple, italics).
         */
        Builder lore(List<Component> lore);

        /**
         * Sets the amount of items in the {@link Button}.
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
         * @vision.apiNote This method may be called multiple times to add multiple handlers.
         * @vision.examples <pre>
         *{@code Button button = Button.button()
         *       .name(Component.text("Click me!"))
         *       .onClick(click -> click.clicker().sendMessage(Component.text("You clicked me!")))
         *       .type(ItemType.DIAMOND);}</pre>
         */
        Builder onClick(Consumer<Click> handler);

        /**
         * Sets the type of the {@link Button} and returns the built {@link Button}.
         *
         * @param type the item type
         * @return the new {@link Button}
         * @throws NullPointerException if the item type is {@code null}.
         * @since 0.1
         */
        Button type(ItemType type);
    }
}

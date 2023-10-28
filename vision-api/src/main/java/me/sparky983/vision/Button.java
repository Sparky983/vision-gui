package me.sparky983.vision;

import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents a button.
 *
 * @see #of(ItemType)
 * @since 0.1
 * @vision.apiNote Unlike Bukkit, {@code Button}s aren't cloned when they're added to a {@link Gui},
 * meaning you can always mutate the {@code Button} and have the mutation be reflected in the
 * {@link Gui}.
 */
@ApiStatus.NonExtendable
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
   * Creates a copy of the specified {@code Button}.
   * <p>
   * The returned button will have all the same properties as the specified {@code Button}, except
   * without any {@link Subscriber Subscribers}.
   *
   * @param button the {@code Button} to copy
   * @return a copy of the specified {@code Button}
   * @throws NullPointerException if the {@code Button} is {@code null}.
   * @since 1.1
   */
  static Button copyOf(final Button button) {
    return new ButtonImpl(button);
  }

  /**
   * Returns the type of this {@code Button}.
   *
   * @return the type of this {@code Button}
   * @since 0.1
   */
  ItemType type();

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
   * Sets the name of this {@code Button}.
   *
   * @param name the name or {@code null} to remove the name
   * @return this {@code Button} instance (for chaining)
   * @since 0.1
   * @vision.implNote The Paper Vision implementation's default style is
   * {@link NamedTextColor#WHITE} with no {@link TextDecoration}, rather than Minecraft's style
   * (italics).
   */
  Button name(@Nullable Component name);

  /**
   * Returns the lore of this {@code Button}.
   *
   * @return an unmodifiable {@link List} containing the lore of this button or an empty
   * {@link List} if no lore is set
   * @since 0.1
   */
  List<Component> lore();

  /**
   * Sets the lore of this {@code Button}.
   * <p>
   * Changes to the input array will not be reflected in the lore of this {@code Button}.
   *
   * @param lore the lore or an empty array to remove the lore
   * @return this {@code Button} instance (for chaining)
   * @throws NullPointerException if the lore is or contains {@code null}.
   * @since 0.1
   * @vision.implNote The Paper Vision implementation's default style is
   * {@link NamedTextColor#WHITE} with no {@link TextDecoration}, rather than Minecraft's style
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
   * @vision.implNote The Paper Vision implementation's default style is
   * {@link NamedTextColor#WHITE} with no {@link TextDecoration}, rather than Minecraft's style
   * (purple, italics).
   */
  Button lore(List<? extends Component> lore);

  /**
   * Returns the amount items in this {@code Button}.
   *
   * @return the amount of items in this {@code Button}
   * @since 0.1
   */
  int amount();

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
   * Checks whether this {@code Button} is glowing.
   *
   * @return {@code true} if this {@code Button} is glowing, otherwise {@code false}
   * @since 1.0
   * @vision.experimental because this may be renamed.
   */
  @ApiStatus.Experimental
  boolean glow();

  /**
   * Sets whether this {@code Button} is glowing.
   *
   * @param glow {@code true} to make this
   * @return this {@code Button} instance (for chaining)
   * @since 1.0
   * @vision.experimental because this may be renamed or changed.
   */
  @ApiStatus.Experimental
  Button glow(boolean glow);

  /**
   * Subscribes the specified {@link Click} handler to this button.
   *
   * @param handler the {@link Click} handler
   * @return the {@code Button} instance (for chaining)
   * @throws NullPointerException if the {@link Click} handler is {@code null}.
   * @since 0.1
   * @vision.apiNote This method may be called multiple times to add multiple handlers.
   * @vision.examples <pre>
   *{@code Button button = Button.of(ItemType.DIAMOND)
   *        .name(Component.text("Click me!"))
   *        .onClick(click -> click.clicker().sendMessage(Component.text("You clicked me!")))}</pre>
   */
  Button onClick(Consumer<? super Click> handler);

  /**
   * Returns the {@link Publisher} associated with this {@code Button}.
   *
   * @return the {@link Publisher} associated with this {@code Button}
   * @since 1.1
   */
  Publisher publisher();

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
   *    public void type(ItemType type) {
   *        System.out.println("Type updated");
   *    }
   *    public void name(Component name) {
   *        System.out.println("Name updated");
   *    }
   *    public void lore(List<Component> lore) {
   *        System.out.println("Lore updated");
   *    }
   *    public void amount(int amount) {
   *        System.out.println("Amount updated");
   *    }
   *})}</pre>
   */
  @Override
  Subscription subscribe(Subscriber subscriber);

  /**
   * Represents a {@link Button} {@link Publisher}.
   *
   * @see #publisher()
   * @since 1.1
   */
  interface Publisher {
    /**
     * Publishes the click event.
     *
     * @param click the click
     * @throws NullPointerException if the click is {@code null}.
     * @since 1.1
     */
    void click(Click click);
  }

  /**
   * Represents a subscriber to a {@link Button}.
   *
   * @see #subscribe(Subscriber)
   * @since 0.1
   */
  interface Subscriber extends Subscribable.Subscriber {
    /**
     * Called when the type of the {@link Button} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param type the new type
     * @throws NullPointerException if the type is {@code null} (optional).
     * @see Button#type(ItemType)
     * @since 0.1
     */
    default void type(final ItemType type) {}

    /**
     * Called when the name of a {@link Button} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param name the new name
     * @throws NullPointerException if the name is {@code null} (optional).
     * @see Button#name(Component)
     * @since 0.1
     */
    default void name(final Component name) {}

    /**
     * Called when the lore of a {@link Button} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param lore the new lore
     * @throws NullPointerException if the lore is or contains {@code null} (optional).
     * @see Button#lore(List)
     * @see Button#lore(Component...)
     * @since 0.1
     */
    default void lore(final List<Component> lore) {}

    /**
     * Called when the amount of the {@link Button} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param amount the new amount
     * @throws IllegalArgumentException if the amount is less than {@code 1} or greater than
     * {@code 64} (optional).
     * @see Button#amount(int)
     * @since 0.1
     */
    default void amount(final int amount) {}

    /**
     * Called when the glowing state of the {@code Button} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param glow the new glowing state
     * @see Button#glow(boolean)
     * @since 1.0
     * @vision.experimental because this may be renamed.
     */
    @ApiStatus.Experimental
    default void glow(final boolean glow) {}

    /**
     * Called when the {@link Button} is clicked.
     * <p>
     * The default implementation does nothing.
     *
     * @param click an object describing the click
     * @throws NullPointerException if the click is {@code null} (optional).
     * @see Publisher#click(Click)
     * @since 0.1
     */
    default void click(final Click click) {}
  }
}

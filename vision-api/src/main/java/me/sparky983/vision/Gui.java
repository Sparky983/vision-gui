package me.sparky983.vision;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Represents a GUI.
 *
 * @since 0.1
 */
@NullMarked
public sealed interface Gui extends Subscribable<Gui.Subscriber> permits Chest, Hopper, Dropper {
  /**
   * Creates a new {@link Chest.Builder} with 1 row.
   *
   * @return the new {@link Chest.Builder}
   * @see Chest.Builder
   * @since 1.0
   * @vision.examples <pre>
   *Gui gui = Gui.gui()
   *        .title(Component.text("My GUI"))
   *        .rows(3)
   *        .slot(Slot.of(1, 4), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
   */
  static Chest.Builder chest() {
    return new ChestImpl.BuilderImpl();
  }

  /**
   * Creates a new {@link Dropper.Builder}.
   *
   * @return the new {@link Dropper.Builder}
   * @see Dropper.Builder
   * @since 1.0
   * @vision.examples <pre>
   *Gui gui = Gui.dropper()
   *        .title(Component.text("My GUI"))
   *        .slot(Slot.of(1, 1), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
   */
  static Dropper.Builder dropper() {
    return new DropperImpl.BuilderImpl();
  }

  /**
   * Creates a new {@link Hopper.Builder}.
   *
   * @return the new {@link Hopper.Builder}
   * @see Hopper.Builder
   * @since 1.0
   * @vision.examples <pre>
   *Gui gui = Gui.hopper()
   *        .title(Component.text("My GUI"))
   *        .slot(Slot.of(0, 2), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
   */
  static Hopper.Builder hopper() {
    return new HopperImpl.BuilderImpl();
  }

  /**
   * Returns the type of this {@code Gui}.
   *
   * @return the type of this {@code Gui}
   * @since 1.0
   */
  GuiType type();

  /**
   * Returns the title of this {@code Gui}.
   * <p>
   * If this {@code Gui} is untitled, the returned component will match Minecraft's default
   * container title which is usually a translatable {@link Component} of the form
   * {@literal "container.<container>"}.
   *
   * @return the title of this {@code Gui}
   * @since 0.1
   */
  Component title();

  /**
   * Returns the number of rows in this {@code Gui}.
   *
   * @return the number of rows
   * @since 0.1
   */
  int rows();

  /**
   * Returns the number of columns in this {@code Gui}.
   *
   * @return the number of columns
   * @since 1.0
   */
  int columns();

  /**
   * Returns the {@link Button} at the specified {@link Slot}.
   *
   * @param slot the slot
   * @return the button at the specified slot or {@link Optional#empty()} if there is no button.
   * @throws IllegalArgumentException if the slot is out of bounds.
   * @throws NullPointerException if the slot is {@code null}.
   * @since 0.1
   * @deprecated in favour of the more well-named {@link #slot(Slot)}.
   */
  @Deprecated
  default Optional<Button> button(final Slot slot) {
    return slot(slot);
  }

  /**
   * Returns the {@link Button} at the specified {@link Slot}.
   *
   * @param slot the slot
   * @return the button at the specified slot or {@link Optional#empty()} if there is no button.
   * @throws IllegalArgumentException if the slot is out of bounds.
   * @throws NullPointerException if the slot is {@code null}.
   * @since 1.1
   */
  Optional<Button> slot(Slot slot);

  /**
   * Sets the {@link Button} at the specified {@link Slot}.
   *
   * @param slot the slot
   * @param button the button or {@code null} to remove the button
   * @return this {@code Gui} instance (for chaining)
   * @throws IllegalArgumentException if the slot is out of bounds.
   * @throws NullPointerException if the slot is {@code null}.
   * @since 0.1
   * @deprecated in favour of the more well-named {@link #slot(Slot, Button)}.
   */
  @Deprecated
  default Gui button(final Slot slot, final @Nullable Button button) {
    return slot(slot, button);
  }

  /**
   * Sets the {@link Button} at the specified {@link Slot}.
   *
   * @param slot the slot
   * @param button the button or {@code null} to remove the button
   * @return this {@code Gui} instance (for chaining)
   * @throws IllegalArgumentException if the slot is out of bounds.
   * @throws NullPointerException if the slot is {@code null}.
   * @since 1.1
   */
  Gui slot(Slot slot, @Nullable Button button);

  /**
   * Returns an immutable list of all slots, present or absent, in this {@code Gui}.
   * <p>
   * The returned list is ordered from left to right, then top to bottom.
   *
   * @return an immutable list of all slots in this {@code Gui}
   * @since 1.0
   * @vision.apiNote This method returns a {@code List} so you can get each slot by index. This is
   * similar to Bukkit slots work.
   * @vision.implNote The returned list is cached.
   */
  List<Slot> slots();

  /**
   * Subscribes the specified {@link Close} handler to this {@code Gui}.
   *
   * @param handler the {@link Close} handler
   * @return this {@code Gui} instance (for chaining)
   * @throws NullPointerException if the {@link Click} handler is {@code null}.
   * @since 1.1
   * @vision.apiNote This method may be called multiple times to add multiple handlers.
   * @vision.examples <pre>
   *{@code Gui gui = Gui.chest()
   *        .build()
   *        .onClick(close -> close.closer().sendMessage(Component.text("You closed me!")))}</pre>
   */
  Gui onClose(Consumer<? super Close> handler);

  /**
   * Returns the {@link Publisher} associated with this {@code Gui}.
   *
   * @return the {@link Publisher} associated with this {@code Gui}
   * @since 1.1
   */
  Publisher publisher();

  /**
   * Subscribes the specified {@link Subscriber} to this {@code Gui}.
   *
   * @param subscriber the subscriber to subscribe
   * @return a {@link Subscription} that can be used to unsubscribe the subscriber
   * @throws NullPointerException if the subscriber is {@code null}.
   * @since 0.1
   * @vision.examples <pre>
   * {@code Gui gui = ....;
   *gui.subscribe(new Gui.Subscriber() {
   *    public void button(Slot slot, Button button) {
   *        System.out.println("Slot changed");
   *    }
   *}}</pre>
   */
  @Override
  Subscription subscribe(Subscriber subscriber);

  /**
   * Represents a {@link Gui} {@link Publisher}
   *
   * @see #publisher()
   * @since 1.1
   */
  interface Publisher {
    /**
     * Publishes the close event.
     *
     * @param close the close
     * @throws NullPointerException if the close is {@code null}.
     * @since 1.1
     */
    void close(Close close);
  }

  /**
   * Represents a subscriber to a {@link Gui}.
   *
   * @see Gui#subscribe(Subscriber)
   * @since 0.1
   */
  interface Subscriber extends Subscribable.Subscriber {
    /**
     * Called when the a {@link Slot} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param slot the slot
     * @param button the new button or {@code null} if there is no new {@link Button}
     * @throws NullPointerException if the slot is {@code null} (optional).
     * @see Gui#slot(Slot, Button)
     * @since 0.1
     * @deprecated in favour of the more well-named {@link #slot(Slot, Button)}.
     */
    @Deprecated
    default void button(final Slot slot, final @Nullable Button button) {}

    /**
     * Called when the a {@link Slot} changes.
     * <p>
     * The default implementation does nothing.
     *
     * @param slot the slot
     * @param button the new button or {@code null} if there is no new {@link Button}
     * @throws NullPointerException if the slot is {@code null} (optional).
     * @see Gui#slot(Slot, Button)
     * @since 1.1
     */
    default void slot(final Slot slot, final @Nullable Button button) {}

    /**
     * Called when a {@link Gui} is closed.
     *
     * @param close an object describing the closure
     * @throws NullPointerException if the close is {@code null} (optional).
     * @see Publisher#close(Close)
     * @since 1.1
     */
    default void close(final Close close) {}
  }

  /**
   * A {@link Gui} builder.
   *
   * @since 0.1
   * @vision.examples <pre>
   *Gui gui = Gui.chest()
   *        .title(Component.text("My Gui"))
   *        .rows(3)
   *        .slot(Slot.of(1, 4), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
   *<pre>
   *Gui gui = Gui.dropper()
   *        .title(Component.text("My Gui"))
   *        .slot(Slot.of(1, 1), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
   *<pre>
   *Gui gui = Gui.hopper()
   *        .title(Component.text("My Gui"))
   *        .slot(Slot.of(0, 2), Button.of(ItemType.STONE))
   *        .build();
   *</pre>
   */
  sealed interface Builder permits Chest.Builder, Dropper.Builder, Hopper.Builder {
    /**
     * Sets the title of the {@link Gui}.
     *
     * @param title the title
     * @return this {@code Builder} instance (for chaining)
     * @throws NullPointerException if the title is {@code null}.
     * @since 0.1
     * @vision.apiNote After the {@link Gui} is built, the title cannot be changed, so it
     * must be specified before the {@link Gui} is built.
     */
    Builder title(Component title);

    /**
     * Sets the {@link Button} at the specified {@link Slot} in the {@link Gui}.
     *
     * @param slot the slot
     * @param button the button
     * @return this {@code Builder} instance (for chaining)
     * @throws NullPointerException if the slot or button is {@code null}.
     * @since 1.0
     * @deprecated in favour of the more well-named {@link #slot(Slot, Button)}.
     */
    @Deprecated
    default Builder button(final Slot slot, final Button button) {
      return slot(slot, button);
    }

    /**
     * Sets the {@link Button} at the specified {@link Slot} in the {@link Gui}.
     *
     * @param slot the slot
     * @param button the button
     * @return this {@code Builder} instance (for chaining)
     * @throws NullPointerException if the slot or button is {@code null}.
     * @since 1.1
     */
    Builder slot(Slot slot, Button button);

    /**
     * Sets all the empty slots to the specified {@link Button} in the {@link Gui}.
     *
     * @param button the button
     * @return this {@code Builder} instance (for chaining)
     * @throws NullPointerException if the button is {@code null}.
     * @since 1.0
     * @vision.experimental because this may be changed, deleted or renamed.
     */
    @ApiStatus.Experimental
    Builder fill(Button button);

    /**
     * Sets the specified borders of the {@link Gui} to the specified {@link Button}.
     * <p>
     * Changes to the border set after this method is called will not affect the {@link Gui}.
     * <p>
     * When the {@link Gui} is built, the {@link Button Buttons} will be placed in the empty
     * slots covered by the borders. If a border has been specified multiple times, the last
     * specified {@link Button} will be used. The same is the case for corners.
     *
     * @param button the button
     * @param borders the borders
     * @return this {@code Builder} instance (for chaining)
     * @throws IllegalArgumentException if there are no borders.
     * @throws NullPointerException if the button is {@code null} or the borders is or contains
     * {@code null}.
     * @since 1.0
     * @vision.experimental because this may be changed, deleted or renamed.
     */
    @ApiStatus.Experimental
    Builder border(Button button, Set<? extends Border> borders);

    /**
     * Sets the specified borders of the {@link Gui} to the specified {@link Button}.
     * <p>
     * Changes to the border array after this method is called will not affect the {@link Gui}.
     * <p>
     * When the {@link Gui} is built, the {@link Button Buttons} will be placed in the empty
     * slots covered by the borders. If a border has been specified multiple times, the last
     * specified {@link Button} will be used. The same is the case for corners.
     *
     * @param button the button
     * @param borders the borders
     * @return this {@code Builder} instance (for chaining)
     * @throws IllegalArgumentException if there are no or duplicate borders.
     * @throws NullPointerException if the button is {@code null} or the borders is or contains
     * {@code null}.
     * @since 1.0
     * @vision.experimental because this may be changed, deleted or renamed.
     */
    @ApiStatus.Experimental
    Builder border(Button button, Border... borders);

    /**
     * Sets all the borders of the {@link Gui} to the specified {@link Button}.
     * <p>
     * When the {@link Gui} is built, the {@link Button Buttons} will be placed in all empty
     * border slots. If a border has been specified multiple times, the last specified
     * {@link Button} will be used. The same is the case for corners.
     *
     * @param button the button
     * @return this {@code Builder} instance (for chaining)
     * @throws NullPointerException if the button is {@code null}
     * @since 1.0
     * @vision.experimental because this may be changed, deleted or renamed.
     */
    @ApiStatus.Experimental
    Builder border(Button button);

    /**
     * Adds the specified {@link Close} handler to the {@code Gui}.
     *
     * @param handler the {@link Close} handler
     * @return this {@code Builder} instance (for chaining)
     * @throws NullPointerException if the {@link Click} handler is {@code null}.
     * @since 1.1
     * @vision.apiNote This method may be called multiple times to add multiple handlers.
     * @vision.examples <pre>
     *{@code Gui gui = Gui.chest()
     *        .onClick(close -> close.closer().sendMessage(Component.text("You closed me!")))
     *        .build()}</pre>
     */
    Builder onClose(Consumer<? super Close> handler);

    /**
     * Builds the {@link Gui}.
     * <p>
     * If both a {@link #fill(Button) fill} and a {@link #border(Button, Set) border} has been
     * specified, the {@link #border(Button, Set) border} will overlay the
     * {@link #fill(Button) fill} in the returned {@link Gui}.
     * <p>
     * All {@linkplain #onClose(Consumer) close handlers} will be subscribed in the order they were
     * added to this {@code Builder}.
     *
     * @return the built {@link Gui}
     * @throws IllegalStateException if any of the buttons are out of bounds.
     * @since 1.0
     */
    Gui build();
  }
}

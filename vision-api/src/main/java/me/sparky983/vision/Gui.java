package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Optional;

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
     *        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
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
     *        .button(Slot.of(1, 1), Button.of(ItemType.STONE))
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
     *        .button(Slot.of(0, 2), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     */
    static Hopper.Builder hopper() {

        return new HopperImpl.BuilderImpl();
    }

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
     * Sets the {@link Button} at the specified {@link Slot}.
     *
     * @param slot the slot
     * @param button the button or {@code null} to remove the button
     * @return this {@code Gui} instance (for chaining)
     * @throws IllegalArgumentException if the slot is out of bounds.
     * @throws NullPointerException if the slot is {@code null}.
     * @since 0.1
     */
    Gui button(Slot slot, @Nullable Button button);

    /**
     * Returns the {@link Button} at the specified {@link Slot}.
     *
     * @param slot the slot
     * @return the button at the specified slot or {@link Optional#empty()} if there is no button.
     * @throws IllegalArgumentException if the slot is out of bounds.
     * @throws NullPointerException if the slot is {@code null}.
     * @since 0.1
     */
    Optional<Button> button(Slot slot);

    /**
     * Returns the type of this {@code Gui}.
     *
     * @return the type of this {@code Gui}
     * @since 1.0
     */
    GuiType type();

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
     *    public void exception(RuntimeException thrown) {
     *    }
     *}}</pre>
     */
    @Override
    Subscription subscribe(Subscriber subscriber);

    /**
     * Represents a subscriber to a {@link Gui}.
     *
     * @see Gui#subscribe(Subscriber)
     * @since 0.1
     */
    interface Subscriber extends Subscribable.Subscriber {

        /**
         * Called when the specified {@link Slot} changes.
         *
         * @param slot the slot
         * @param button the new button or {@code null} if there is no new {@link Button}
         * @throws NullPointerException if the slot is {@code null} (optional).
         * @since 0.1
         */
        void button(Slot slot, @Nullable Button button);
    }

    /**
     * A {@link Gui} builder.
     *
     * @since 0.1
     * @vision.examples <pre>
     *Gui gui = Gui.chest()
     *        .title(Component.text("My Gui"))
     *        .rows(3)
     *        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     *<pre>
     *Gui gui = Gui.dropper()
     *        .title(Component.text("My Gui"))
     *        .button(Slot.of(1, 1), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     *<pre>
     *Gui gui = Gui.hopper()
     *        .title(Component.text("My Gui"))
     *        .button(Slot.of(0, 2), Button.of(ItemType.STONE))
     *        .build();
     *</pre>
     */
    interface Builder {

        /**
         * Sets the title of the {@link Gui}.
         *
         * @param title the title
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the title is {@code null}.
         * @since 0.1
         * @vision.apiNote After the {@link Gui} is built, the title cannot be changed, so it
         * must be specified before the {@link Gui} is built
         */
        Builder title(Component title);

        /**
         * Sets the {@link Button} at the specified {@link Slot} in the {@link Gui}.
         *
         * @param slot the slot
         * @param button the button
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the slot or button is {@code null}.
         * @since 1.0
         */
        Builder button(Slot slot, Button button);

        /**
         * Sets all current slots to the specified {@link Button} in the {@link Gui}.
         * <p>
         * This method will replace any preexisting {@link Button Buttons}.
         *
         * @param button the button
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the button is {@code null}.
         * @since 1.0
         * @vision.experimental because this may be changed, deleted or renamed.
         */
        @ApiStatus.Experimental
        Builder fill(Button button);
        // TODO: Figure out if we should keep preexisting buttons
        //  It would be more useful to keep preexisting buttons, but that isn't clearly communicated
        //  by the method name.

        /**
         * Builds the {@link Gui}.
         *
         * @return the built {@link Gui}
         * @throws IllegalStateException if any of the buttons are out of bounds.
         * @since 1.0
         */
        Gui build();
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Optional;

/**
 * Represents a GUI.
 *
 * @since 0.1
 */
@NullMarked
public interface Gui extends Subscribable<Gui.Subscriber> {

    /**
     * The maximum number of rows in a GUI.
     */
    int MAX_ROWS = 6;

    /**
     * The number of columns in a GUI.
     */
    int COLUMNS = 9;

    static Chest.Builder chest() {

        return null;
    }

    interface Chest extends Gui {

        int rows();

        interface Builder extends Gui.Builder {

            Builder rows(int rows);

            @Override
            Builder title(Component title);

            @Override
            Builder button(Slot slot, @Nullable Button button);

            @Override
            Chest build();
        }
    }

    static Hopper.Builder hopper() {

        return null;
    }

    interface Hopper extends Gui {

        interface Builder extends Gui.Builder {

            @Override
            Builder title(Component title);

            @Override
            Builder button(Slot slot, @Nullable Button button);

            @Override
            Hopper build();
        }
    }

    static Dropper.Builder dropper() {

        return null;
    }

    interface Dropper extends Gui {

        interface Builder extends Gui.Builder {

            @Override
            Builder title(Component title);

            @Override
            Builder button(Slot slot, @Nullable Button button);

            @Override
            Dropper build();
        }
    }

    /**
     * A {@link Gui} builder.
     *
     * @see #gui()
     * @see #rows(int)
     * @since 0.1
     * @vision.apiNote This builder is type-safe, so it cannot be built until the
     * {@link Builder#rows(int)} have been specified.
     * @vision.examples <pre>
     *Gui gui = Gui.gui()
     *        .title(Component.text("My Gui"))
     *        .rows(3)
     *        .button(Slot.of(0, 0), Button.of(ItemType.STONE);
     *</pre>
     *<pre>
     *Gui gui = Gui.gui().rows(3);
     *</pre>
     */
    interface Builder {

        /**
         * Specifies the title of the {@link Gui}.
         *
         * @param title the title
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the title is {@code null}.
         * @since 0.1
         * @vision.apiNote The title can't change, so you must specify it before specifying the
         * {@link #rows(int)}.
         */
        Builder title(Component title);

        Builder button(Slot slot, @Nullable Button button);

        Gui build();
    }

    /**
     * Gets the title of this {@code Gui}.
     * <p>
     * If this {@code Gui} is untitled, the returned component will match Minecraft's default
     * container title which is usually a translatable {@code Component} of the form
     * {@literal "container.<container>"}.
     *
     * @return the title of this {@code Gui}
     * @since 0.1
     */
    Component title();

    /**
     * Gets the amount of rows this {@code Gui} has.
     *
     * @return the amount of rows this {@code Gui} has
     * @since 0.1
     */
    int rows();

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
     * Gets the {@link Button} at the specified {@link Slot}.
     *
     * @param slot the slot
     * @return the button at the specified slot or {@link Optional#empty()} if there is no button.
     * @throws IllegalArgumentException if the slot is out of bounds.
     * @throws NullPointerException if the slot is {@code null}.
     * @since 0.1
     */
    Optional<Button> button(Slot slot);

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
}

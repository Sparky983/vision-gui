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

    /**
     * Creates a new {@link Gui.Builder}.
     *
     * @return the new {@link Gui.Builder}
     * @see Builder
     * @see #gui(Component, int)
     * @see #gui(int)
     * @since 0.1
     */
    static Builder gui() {

        return new GuiImpl.BuilderImpl();
    }

    /**
     * Creates a new {@code Gui} with the specified title and amount of rows.
     *
     * @param title the title or {@code null} to make the {@code Gui} untitled
     * @param rows the amount of rows
     * @return the new {@code Gui}
     * @throws IllegalArgumentException if the amount of rows is less than 1 or greater than 6.
     * @see #gui()
     * @see #gui(int)
     * @since 0.1
     */
    static Gui gui(final @Nullable Component title, int rows) {

        final Gui.Builder builder = gui();

        if (title != null) {
            builder.title(title);
        }

        return builder.rows(rows);
    }

    /**
     * Creates a new untitled {@code Gui} with the specified amount of rows.
     *
     * @param rows the amount of rows
     * @return the new {@code Gui}
     * @throws IllegalArgumentException if the amount of rows is less than 1 or greater than 6.
     * @see #gui()
     * @see #gui(Component, int)
     * @since 0.1
     */
    static Gui gui(final int rows) {

        return gui(null, rows);
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
     * Represents a subscriber to a {@link Gui}.
     *
     * @see Gui#subscribe(Subscribable.Subscriber)
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
     * A typesafe {@link Gui} builder.
     * <p>
     * To build the {@link Gui}, use {@link #rows(int)}.
     * <p>
     * Examples:
     * <pre>
     * Gui gui = Gui.gui()
     *         .title(Component.text("My GUI"))
     *         .button(Slot.of(0, 0), Button.of(ItemType.STONE))
     *         .rows(5);
     * </pre>
     * <pre>
     * Gui gui = Gui.gui()
     *          .title(Component.text("My GUI"))
     *          .rows(5)
     *          .button(Slot.of(0, 0), Button.of(ItemType.STONE));
     * </pre>
     */
    interface Builder {

        /**
         * Specifies the title of the {@link Gui}.
         *
         * @param title the title
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the title is {@code null}.
         * @since 0.1
         */
        Builder title(Component title);

        /**
         * Specifies the amount of rows of the {@link Gui} and returns the built {@link Gui}.
         *
         * @param rows the amount of rows
         * @return the built {@link Gui}
         * @throws IllegalArgumentException if the amount of rows is less than 1 or greater than 6.
         * @since 0.1
         */
        Gui rows(int rows);
    }
}

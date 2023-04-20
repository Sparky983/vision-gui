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
public interface Gui {

    /**
     * Creates a new GUI builder.
     *
     * @return the newly created GUI builder
     * @see Builder
     * @see #gui(Component, int)
     * @see #gui(int)
     * @since 0.1
     */
    static Builder gui() {

        return null;
    }

    /**
     * Creates a new GUI with the specified title and amount of rows.
     *
     * @param title the title or {@code null} to make the GUI untitled
     * @param rows the amount of rows
     * @return the newly created GUI
     * @throws IllegalArgumentException if the amount of rows is less than 1 or greater than 6.
     * @see #gui()
     * @see #gui(int)
     * @since 0.1
     */
    static Gui gui(final @Nullable Component title, int rows) {

        return null;
    }

    /**
     * Creates a new untitled GUI with the specified amount of rows.
     *
     * @param rows the amount of rows
     * @return the newly created GUI
     * @throws IllegalArgumentException if the amount of rows is less than 1 or greater than 6.
     * @see #gui()
     * @see #gui(Component, int)
     * @since 0.1
     */
    static Gui gui(int rows) {

        return null;
    }

    /**
     * Gets the title of this GUI.
     * <p>
     * If this GUI is untitled, the returned component will match Minecraft's default GUI title
     * which is usually a translatable component of the form {@literal "container.<container>"}.
     *
     * @return the title of this GUI
     * @since 0.1
     */
    Component title();

    /**
     * Gets the amount of rows this GUI has.
     *
     * @return the amount of rows this GUI has
     * @since 0.1
     */
    int rows();

    /**
     * Sets the button at the specified slot.
     *
     * @param slot the slot
     * @param button the button or {@code null} to remove the button
     * @return this GUI instance (for chaining)
     * @throws IllegalArgumentException if the slot is out of bounds.
     * @throws NullPointerException if the slot is {@code null}.
     * @since 0.1
     */
    Gui button(Slot slot, @Nullable Button button);

    /**
     * Gets the button at the specified slot.
     *
     * @param slot the slot
     * @return the button at the specified slot or {@link Optional#empty()} if there is no button.
     * @throws IllegalArgumentException if the slot is out of bounds.
     * @throws NullPointerException if the slot is {@code null}.
     * @since 0.1
     */
    Optional<Gui> button(Slot slot);

    /**
     * A typesafe GUI builder.
     * <p>
     * To build the GUI, use {@link #rows(int)}.
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
         * Specifies the title of the GUI.
         *
         * @param title the title
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the title is {@code null}.
         * @since 0.1
         */
        Builder title(Component title);

        /**
         * Specifies the button at the specified slot of the GUI.
         *
         * @param slot the slot
         * @param button the button
         * @return this builder instance (for chaining)
         * @throws NullPointerException if the slot or button is {@code null}.
         * @since 0.1
         */
        Builder button(Slot slot, Button button);

        /**
         * Specifies the amount of rows of the GUI and returns the built GUI.
         *
         * @param rows the amount of rows
         * @return the built GUI
         * @throws IllegalArgumentException if the amount of rows is less than 1 or greater than 6.
         * @since 0.1
         */
        Gui rows(int rows);
    }
}

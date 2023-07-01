package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * A representation of a {@link Gui}'s contents.
 * <p>
 * Used by all default implementations of each {@link Gui} variant.
 */
@NullMarked
final class Container implements Subscribable<Gui.Subscriber> {

    @VisibleForTesting
    static final String SLOT_OUT_OF_BOUNDS =
            "Button at (%s, %s) is out of bounds for %s rows and %s columns";

    private static final int MIN_ROWS = Chest.MIN_ROWS;
    private static final int MAX_ROWS = Chest.MAX_ROWS;

    private static final int MIN_COLUMNS = 1;
    private static final int MAX_COLUMNS = Chest.COLUMNS;

    private final SubscriptionManager<Gui.Subscriber> subscribers = new SubscriptionManager<>();

    private final Component title;
    private final int rows;
    private final int columns;
    private final Map<Slot, Button> buttons;

    private Container(final Component title, final int rows, final int columns, final Map<Slot, Button> buttons) {

        assert title != null;
        assert rows >= 1 && rows <= MAX_ROWS;
        assert columns >= 1 && columns <= MAX_COLUMNS;
        assert buttons.keySet().stream().allMatch(Objects::nonNull);
        assert buttons.values().stream().allMatch(Objects::nonNull);
        assert buttons.keySet().stream().allMatch((slot) -> slot.row() <= rows);
        assert buttons.keySet().stream().allMatch((slot) -> slot.column() <= columns);

        this.title = title;
        this.rows = rows;
        this.columns = columns;
        this.buttons = new HashMap<>(buttons);
    }

    /**
     * Creates a new {@code Container.Builder}.
     *
     * @param title the title
     * @param rows the number of rows
     * @param columns the number of columns
     * @return the newly created {@code Container}
     * @throws IllegalArgumentException if the number of rows is not from 1 to 6 or the number of
     * columns is not from 1 to 9.
     * @throws NullPointerException if the title is {@code null}.
     */
    static Container.Builder builder(final Component title, final int rows, final int columns) {

        return new Container.Builder(title, rows, columns);
    }

    Component title() {

        return title;
    }

    int columns() {

        return columns;
    }

    int rows() {

        return rows;
    }

    void button(final Slot slot, final @Nullable Button button) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.row() >= rows || slot.column() >= columns) {
            throw new IllegalArgumentException(
                    SLOT_OUT_OF_BOUNDS.formatted(slot.row(), slot.column(), rows, columns));
        }

        if (button == null) {
            buttons.remove(slot);
        } else {
            buttons.put(slot, button);
        }
        subscribers.notify((subscriber) -> subscriber.button(slot, button));
    }

    Optional<Button> button(final Slot slot) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.column() >= columns || slot.row() >= rows) {
            throw new IllegalArgumentException(
                    SLOT_OUT_OF_BOUNDS.formatted(slot.row(), slot.column(), rows, columns));
        }

        return Optional.ofNullable(buttons.get(slot));
    }

    @Override
    public Subscription subscribe(final Gui.Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        return subscribers.subscribe(subscriber);
    }

    /**
     * A {@link Container} builder.
     */
    static final class Builder {

        private Component title;
        private int rows;
        private int columns;
        private final Map<Slot, Button> buttons = new HashMap<>();

        private Builder(final Component title, final int rows, final int columns) {

            title(title);
            rows(rows);
            columns(columns);
        }

        Builder title(final Component title) {

            Objects.requireNonNull(title, "title cannot be null");

            this.title = title;
            return this;
        }

        Builder rows(final int rows) {

            if (rows < MIN_ROWS || rows > MAX_ROWS) {
                throw new IllegalArgumentException("rows must be between 1 and " + MAX_ROWS);
            }

            this.rows = rows;
            return this;
        }

        Builder columns(final int columns) {

            if (columns < MIN_COLUMNS || columns > MAX_COLUMNS) {
                throw new IllegalArgumentException("columns must be between 1 and " + MAX_COLUMNS);
            }

            this.columns = columns;
            return this;
        }

        Builder button(final Slot slot, final Button button) {

            Objects.requireNonNull(slot, "slot cannot be null");
            Objects.requireNonNull(button, "button cannot be null");

            buttons.put(slot, button);
            return this;
        }

        Container build() {

            for (final Slot slot : buttons.keySet()) {
                if (slot.row() >= rows || slot.column() >= columns) {
                    throw new IllegalStateException(
                            SLOT_OUT_OF_BOUNDS.formatted(slot.row(), slot.column(), rows, columns));
                }
            }

            return new Container(title, rows, columns, buttons);
        }
    }
}

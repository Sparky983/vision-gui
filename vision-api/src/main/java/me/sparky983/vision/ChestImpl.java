package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@NullMarked
final class ChestImpl implements Chest {

    @VisibleForTesting
    static final Component DEFAULT_TITLE = Component.translatable("container.chest");
    @VisibleForTesting
    static final int DEFAULT_ROWS = 1;
    @VisibleForTesting
    static final String SLOT_OUT_OF_BOUNDS = "Button at %s is out of bounds for %s rows";
    @VisibleForTesting
    static final String ROWS_OUT_OF_BOUNDS = "Rows must be between "
            + MIN_ROWS
            + " and "
            + MAX_ROWS
            + ", but was %s";

    private final SubscriptionManager<Subscriber> subscribers = new SubscriptionManager<>();

    private final Map<Slot, Button> buttons;
    private final int rows;
    private final Component title;

    private ChestImpl(final int rows,
                      final Component title,
                      final Map<Slot, Button> buttons) {

        assert title != null;
        assert buttons != null;
        assert buttons.keySet().stream().allMatch(Objects::nonNull);
        assert buttons.values().stream().allMatch(Objects::nonNull);
        assert buttons.keySet().stream().allMatch((slot) -> slot.row() <= rows);

        this.rows = rows;
        this.title = title;
        this.buttons = new HashMap<>(buttons);
    }

    @Override
    public int columns() {

        return COLUMNS;
    }

    @Override
    public int rows() {

        return rows;
    }

    @Override
    public Component title() {

        return title;
    }

    @Override
    public Gui button(final Slot slot, final @Nullable Button button) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.row() >= rows()) {
            throw new IllegalArgumentException(SLOT_OUT_OF_BOUNDS.formatted(slot, rows()));
        }

        if (button == null) {
            buttons.remove(slot);
        } else {
            buttons.put(slot, button);
        }
        subscribers.notify((subscriber) -> subscriber.button(slot, button));
        return this;
    }

    @Override
    public Optional<Button> button(final Slot slot) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.row() >= rows()) {
            throw new IllegalArgumentException(SLOT_OUT_OF_BOUNDS.formatted(slot, rows()));
        }

        return Optional.ofNullable(buttons.get(slot));
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        return subscribers.subscribe(subscriber);
    }

    final static class BuilderImpl implements Builder {

        private final Map<Slot, Button> buttons = new HashMap<>();

        private int rows = DEFAULT_ROWS;
        private Component title = DEFAULT_TITLE;

        @Override
        public Builder rows(final int rows) {

            if (rows < MIN_ROWS || rows > MAX_ROWS) {
                throw new IllegalArgumentException();
            }

            this.rows = rows;
            return this;
        }

        @Override
        public Builder title(final Component title) {

            Objects.requireNonNull(title, "title cannot be null");

            this.title = title;
            return this;
        }

        @Override
        public Builder button(final Slot slot, final Button button) {

            Objects.requireNonNull(slot, "slot cannot be null");
            Objects.requireNonNull(button, "button cannot be null");

            this.buttons.put(slot, button);
            return this;
        }

        @Override
        public Chest build() {

            for (final Slot slot : buttons.keySet()) {
                if (slot.row() >= rows) {
                    throw new IllegalStateException(SLOT_OUT_OF_BOUNDS.formatted(slot, rows));
                }
            }

            return new ChestImpl(rows, title, buttons);
        }
    }
}

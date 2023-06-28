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
final class HopperImpl implements Hopper {

    @VisibleForTesting
    static final Component DEFAULT_TITLE = Component.translatable("container.hopper");
    @VisibleForTesting
    static final String SLOT_OUT_OF_BOUNDS = "Button at %s is out of bounds for hopper";

    private final SubscriptionManager<Subscriber> subscribers = new SubscriptionManager<>();

    private final Component title;
    private final Map<Slot, Button> buttons;

    HopperImpl(final Component title, final Map<Slot, Button> buttons) {

        assert title != null;
        assert buttons != null;

        this.title = title;
        this.buttons = new HashMap<>(buttons);
    }

    @Override
    public Component title() {

        return title;
    }

    @Override
    public int columns() {

        return COLUMNS;
    }

    @Override
    public int rows() {

        return ROWS;
    }

    @Override
    public Gui button(final Slot slot, final @Nullable Button button) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.row() >= ROWS || slot.column() >= COLUMNS) {
            throw new IllegalArgumentException(SLOT_OUT_OF_BOUNDS.formatted(slot));
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

        if (slot.row() >= ROWS || slot.column() >= COLUMNS) {
            throw new IllegalArgumentException(SLOT_OUT_OF_BOUNDS.formatted(slot));
        }

        return Optional.ofNullable(buttons.get(slot));
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        return subscribers.subscribe(subscriber);
    }

    static final class BuilderImpl implements Builder {

        private Component title = DEFAULT_TITLE;

        private final Map<Slot, Button> buttons = new HashMap<>();

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
        public Hopper build() {

            for (final Slot slot : buttons.keySet()) {
                if (slot.row() >= ROWS || slot.column() >= COLUMNS) {
                    throw new IllegalStateException(SLOT_OUT_OF_BOUNDS.formatted(slot));
                }
            }

            return new HopperImpl(title, buttons);
        }
    }
}

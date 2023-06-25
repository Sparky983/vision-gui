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
    static final String SLOT_OUT_OF_BOUNDS = "Button at %s is out of bounds for %s rows";

    private final SubscriptionManager<Subscriber> subscribers = new SubscriptionManager<>();

    private final GuiType type;
    private final Component title;
    private final Map<Slot, Button> buttons;

    private ChestImpl(final GuiType type,
                      final Component title,
                      final Map<Slot, Button> buttons) {

        assert title != null;
        assert buttons != null;
        assert buttons.keySet().stream().allMatch(Objects::nonNull);
        assert buttons.values().stream().allMatch(Objects::nonNull);
        assert buttons.keySet().stream()
                .allMatch(type::allowsSlot);

        this.type = type;
        this.title = title;
        this.buttons = buttons;
    }

    @Override
    public GuiType type() {

        return type;
    }

    @Override
    public int columns() {

        return type().columns();
    }

    @Override
    public int rows() {

        return type().rows();
    }

    @Override
    public Component title() {

        return title;
    }

    @Override
    public Gui button(final Slot slot, final @Nullable Button button) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (!type().allowsSlot(slot)) {
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

        if (!type.allowsSlot(slot)) {
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

        @VisibleForTesting
        static final GuiType DEFAULT_ROWS = GuiTypeImpl.chest(1);

        private GuiType type = DEFAULT_ROWS;
        private Component title = GuiType.Chest.NAME;

        private final Map<Slot, Button> buttons = new HashMap<>();

        @Override
        public Builder rows(final int rows) {

            this.type = GuiTypeImpl.chest(rows);
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
                if (!type.allowsSlot(slot)) {
                    throw new IllegalStateException(
                            SLOT_OUT_OF_BOUNDS.formatted(slot, type.rows()));
                }
            }

            return new ChestImpl(type, title, buttons);
        }
    }
}

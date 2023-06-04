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
 * The default implementation of {@link Gui}.
 */
@NullMarked
final class GuiImpl implements Gui {

    @VisibleForTesting
    static final Component DEFAULT_NAME = Component.translatable("container.chest");

    private final SubscriptionManager<Subscriber> subscriptionManager = new SubscriptionManager<>();

    private final Map<Slot, Button> slots = new HashMap<>();
    private final Component title;
    private final int rows;

    private GuiImpl(final @Nullable Component title, final int rows) {

        assert rows >= 1 && rows <= MAX_ROWS;

        this.title = Objects.requireNonNullElse(title, DEFAULT_NAME);
        this.rows = rows;
    }

    @Override
    public Component title() {

        return title;
    }

    @Override
    public int rows() {

        return rows;
    }

    @Override
    public Gui button(final Slot slot, final @Nullable Button button) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.row() >= rows) {
            throw new IllegalArgumentException(
                    "slot (" + slot.row() + ", " + slot.column() + ") out of range for " +
                            rows + " rows");
        }

        slots.put(slot, button);
        subscriptionManager.notify((subscriber) -> subscriber.button(slot, button));
        return this;
    }

    @Override
    public Optional<Button> button(final Slot slot) {

        return Optional.ofNullable(slots.get(slot));
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        return subscriptionManager.subscribe(subscriber);
    }

    /**
     * The default implementation of {@link Gui.Builder}.
     *
     * @see Gui#gui()
     */
    static final class BuilderImpl implements Builder {

        private @Nullable Component title;

        @Override
        public Builder title(final Component title) {

            Objects.requireNonNull(title, "title cannot be null");

            this.title = title;
            return this;
        }

        @Override
        public Gui rows(final int rows) {

            if (rows <= 0 || rows > MAX_ROWS) {
                throw new IllegalArgumentException("rows must be between 1 and 6");
            }

            return new GuiImpl(title, rows);
        }
    }
}

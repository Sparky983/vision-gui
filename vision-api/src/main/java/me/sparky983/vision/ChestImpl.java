package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Objects;
import java.util.Optional;

@NullMarked
final class ChestImpl implements Chest {

    @VisibleForTesting
    static final Component DEFAULT_TITLE = Component.translatable("container.chest");
    @VisibleForTesting
    static final int DEFAULT_ROWS = 1;

    private final Container container;

    private ChestImpl(final Container container) {

        assert container != null;

        this.container = container;
    }

    @Override
    public Component title() {

        return container.title();
    }

    @Override
    public int columns() {

        return container.columns();
    }

    @Override
    public int rows() {

        return container.rows();
    }

    @Override
    public Gui button(final Slot slot, final @Nullable Button button) {

        Objects.requireNonNull(slot, "slot cannot be null");

        container.button(slot, button);
        return this;
    }

    @Override
    public Optional<Button> button(final Slot slot) {

        Objects.requireNonNull(slot, "slot cannot be null");

        if (slot.row() >= rows()) {
            throw new IllegalArgumentException(Container.SLOT_OUT_OF_BOUNDS.formatted(slot.row(), slot.column(), rows(), columns()));
        }

        return container.button(slot);
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        return container.subscribe(subscriber);
    }

    final static class BuilderImpl implements Builder {

        private final Container.Builder container =
                Container.builder(DEFAULT_TITLE, DEFAULT_ROWS, COLUMNS);

        @Override
        public Builder rows(final int rows) {

            if (rows < MIN_ROWS || rows > MAX_ROWS) {
                throw new IllegalArgumentException("rows must be between 1 and " + MAX_ROWS);
            }

            container.rows(rows);
            return this;
        }

        @Override
        public Builder title(final Component title) {

            Objects.requireNonNull(title, "title cannot be null");

            container.title(title);
            return this;
        }

        @Override
        public Builder button(final Slot slot, final Button button) {

            Objects.requireNonNull(slot, "slot cannot be null");
            Objects.requireNonNull(button, "button cannot be null");

            container.button(slot, button);
            return this;
        }

        @Override
        public Chest build() {

            return new ChestImpl(container.build());
        }
    }
}

package me.sparky983.vision;

import static me.sparky983.vision.Container.SLOT_OUT_OF_BOUNDS;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@NullMarked
final class DropperImpl implements Dropper {

    @VisibleForTesting
    static final Component DEFAULT_TITLE = Component.translatable("container.dropper");

    private final Container container;

    DropperImpl(final Container container) {

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

        if (slot.row() >= ROWS || slot.column() >= COLUMNS) {
            throw new IllegalArgumentException(SLOT_OUT_OF_BOUNDS.formatted(slot.row(), slot.column(), rows(), columns()));
        }

        return container.button(slot);
    }

    @Override
    public Subscription subscribe(final Gui.Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        return container.subscribe(subscriber);
    }

    static final class BuilderImpl implements Builder {

        private final Container.Builder container = Container.builder(DEFAULT_TITLE, ROWS, COLUMNS);

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
        public Dropper build() {

            return new DropperImpl(container.build());
        }
    }
}

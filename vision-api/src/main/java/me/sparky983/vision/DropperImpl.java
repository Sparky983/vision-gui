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
    public int rows() {

        return container.rows();
    }

    @Override
    public int columns() {

        return container.columns();
    }

    @Override
    public Gui button(final Slot slot, final @Nullable Button button) {

        container.button(slot, button);
        return this;
    }

    @Override
    public Optional<Button> button(final Slot slot) {

        return container.button(slot);
    }

    @Override
    public Subscription subscribe(final Gui.Subscriber subscriber) {

        return container.subscribe(subscriber);
    }

    static final class BuilderImpl implements Builder {

        private final Container.Builder container = Container.builder(DEFAULT_TITLE, ROWS, COLUMNS);

        @Override
        public Builder title(final Component title) {

            container.title(title);
            return this;
        }

        @Override
        public Builder button(final Slot slot, final Button button) {

            container.button(slot, button);
            return this;
        }

        @Override
        public Dropper build() {

            return new DropperImpl(container.build());
        }
    }
}

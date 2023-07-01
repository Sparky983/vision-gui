package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Optional;

/**
 * The default implementation of {@link Hopper}.
 *
 * @see Gui#hopper()
 */
@NullMarked
final class HopperImpl implements Hopper {

    @VisibleForTesting
    static final Component DEFAULT_TITLE = Component.translatable("container.hopper");

    private final Container container;

    HopperImpl(final Container container) {

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
    public Subscription subscribe(final Subscriber subscriber) {

        return container.subscribe(subscriber);
    }

    /**
     * The default implementation of {@link Hopper.Builder}.
     *
     * @see Gui#hopper()
     */
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
        public Hopper build() {

            return new HopperImpl(container.build());
        }
    }
}

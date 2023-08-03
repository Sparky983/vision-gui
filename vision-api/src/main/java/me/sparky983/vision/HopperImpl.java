package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public GuiType type() {

        return GuiType.HOPPER;
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
    public Optional<Button> button(final Slot slot) {

        return container.button(slot);
    }

    @Override
    public Hopper button(final Slot slot, final @Nullable Button button) {

        container.button(slot, button);
        return this;
    }

    @Override
    public List<Slot> slots() {

        return container.slots();
    }

    @Override
    public Publisher publisher() {

        return container.publisher();
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        return container.subscribe(subscriber);
    }

    @Override
    public String toString() {

        return String.format("HopperImpl[title=%s]", title());
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
        public Builder fill(final Button button) {

            container.fill(button);
            return this;
        }

        @Override
        public Builder border(final Button button, final Set<? extends Border> borders) {

            container.border(button, borders);
            return this;
        }

        @Override
        public Builder border(final Button button, final Border... borders) {

            container.border(button, borders);
            return this;
        }

        @Override
        public Builder border(final Button button) {

            container.border(button);
            return this;
        }

        @Override
        public Hopper build() {

            return new HopperImpl(container.build());
        }
    }
}

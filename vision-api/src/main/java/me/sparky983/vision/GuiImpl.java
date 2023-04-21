package me.sparky983.vision;

import net.kyori.adventure.text.Component;
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

    /**
     * Visible for testing
     */
    static final Component DEFAULT_NAME = Component.translatable("container.chest");

    private final Map<Slot, Button> slots = new HashMap<>();
    private final Component title;
    private final int rows;

    private GuiImpl(final @Nullable Component title, final int rows) {

        assert rows >= 1 && rows <= 6;

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
                    "slot (" + slot.column() + ", " + slot.row() + ") out of range for " +
                            rows + " rows");
        }

        slots.put(slot, button);
        return this;
    }

    @Override
    public Optional<Button> button(final Slot slot) {

        return Optional.ofNullable(slots.get(slot));
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

            if (rows < 1 || rows > 6) {
                throw new IllegalArgumentException("rows must be between 1 and 6");
            }

            return new GuiImpl(title, rows);
        }
    }
}

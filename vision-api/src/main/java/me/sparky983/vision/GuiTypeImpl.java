package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;

final class GuiTypeImpl {

    @VisibleForTesting
    static final String INCORRECT_ROWS = "rows must be between "
            + GuiType.Chest.MIN_ROWS
            + " and "
            + GuiType.Chest.MAX_ROWS
            + " (got %s)";

    private GuiTypeImpl() {

    }

    /**
     * Creates a new {@link GuiType.Chest} with the specified number of rows.
     *
     * @param rows the number of rows
     * @return the new {@link GuiType.Chest}
     * @throws IllegalArgumentException if the number of rows is less than 1 or greater than 6.
     */
    static GuiType.Chest chest(final int rows) {

        return new ChestImpl(rows);
    }

    private record ChestImpl(@Override int rows) implements GuiType.Chest {

        @VisibleForTesting
        static final Component NAME = Component.translatable("container.chest");

        ChestImpl {

            if (rows < MIN_ROWS || rows > MAX_ROWS) {
                throw new IllegalArgumentException(INCORRECT_ROWS.formatted(rows));
            }
        }

        @Override
        public int columns() {

            return COLUMNS;
        }

        @Override
        public boolean allowsSlot(final Slot slot) {

            return slot.row() < rows;
        }

        @Override
        public Component name() {

            return NAME;
        }
    }
}

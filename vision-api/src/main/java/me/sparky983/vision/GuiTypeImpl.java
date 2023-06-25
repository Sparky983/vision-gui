package me.sparky983.vision;

final class GuiTypeImpl {

    private GuiTypeImpl() {

    }

    static GuiType.Chest chest(final int rows) {

        return new ChestImpl(rows);
    }

    private record ChestImpl(@Override int rows) implements GuiType.Chest {

        ChestImpl {

            if (rows < 0 || rows > 6) {
                throw new IllegalArgumentException();
            }
            // TODO(Sparky983): add an exception message and move constants so they can be used here
        }

        @Override
        public int columns() {

            return COLUMNS;
        }
    }
}

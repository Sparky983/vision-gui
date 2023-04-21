package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The default implementation of {@link Button}.
 */
@NullMarked
final class ButtonImpl implements Button {

    private ItemType type;
    private @Nullable Component name;
    private List<Component> lore;
    private int amount;

    private ButtonImpl(final ItemType type,
                       final @Nullable Component name,
                       final List<Component> lore,
                       final int amount) {

        assert type != null;
        assert lore != null;
        assert lore.stream().noneMatch(Objects::isNull);
        assert amount > 0 && amount <= 64;

        this.type = type;
        this.name = name;
        this.lore = lore;
        this.amount = amount;
    }

    @Override
    public Button name(final @Nullable Component name) {

        this.name = name;
        return this;
    }

    @Override
    public Component name() {

        if (name != null) {
            return name;
        }

        return Component.translatable(type.translationKey());
    }

    @Override
    public Button lore(final Component... lore) {

        Objects.requireNonNull(lore, "lore cannot be null");

        return lore(Arrays.asList(lore));
    }

    @Override
    public Button lore(final List<Component> lore) {

        Objects.requireNonNull(lore, "lore cannot be null");

        for (int i = 0; i < lore.size(); i++) {
            Objects.requireNonNull(lore.get(i), "lore[" + i + "] cannot be null");
        }

        this.lore = List.copyOf(lore);
        return this;
    }

    @Override
    public List<Component> lore() {

        return lore;
    }

    @Override
    public Button amount(final int amount) {

        if (amount <= 0 || amount > 64) {
            throw new IllegalArgumentException("amount must be between 1 and 64");
        }

        this.amount = amount;
        return this;
    }

    @Override
    public int amount() {

        return amount;
    }

    @Override
    public Button type(final ItemType type) {

        Objects.requireNonNull(type, "type cannot be null");

        this.type = type;
        return this;
    }

    @Override
    public ItemType type() {

        return type;
    }

    /**
     * The default implementation of {@link Button.Builder}.
     *
     * @see Button#button()
     */
    static final class BuilderImpl implements Builder {

        private @Nullable Component name;
        private List<Component> lore = List.of();
        private int amount = 1;

        @Override
        public Builder name(final Component name) {

            Objects.requireNonNull(name, "name cannot be null");

            this.name = name;
            return this;
        }

        @Override
        public Builder lore(final Component... lore) {

            Objects.requireNonNull(lore, "lore cannot be null");

            return lore(Arrays.asList(lore));
        }

        @Override
        public Builder lore(final List<Component> lore) {

            Objects.requireNonNull(lore, "lore cannot be null");

            for (int i = 0; i < lore.size(); i++) {
                Objects.requireNonNull(lore.get(i), "lore[" + i + "] cannot be null");
            }

            this.lore = List.copyOf(lore);
            return this;
        }

        @Override
        public Builder amount(final int amount) {

            if (amount <= 0 || amount > 64) {
                throw new IllegalArgumentException("amount must be between 1 and 64");
            }

            this.amount = amount;
            return this;
        }

        @Override
        public Button type(final ItemType item) {

            Objects.requireNonNull(item, "type cannot be null");

            return new ButtonImpl(
                    item,
                    name,
                    lore,
                    amount
            );
        }
    }
}

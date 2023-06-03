package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * The default implementation of {@link Button}.
 *
 * @see Button#of(ItemType)
 * @see Button#button()
 */
@NullMarked
final class ButtonImpl implements Button {

    private final SubscriptionManager<Subscriber> subscriptionManager = new SubscriptionManager<>();

    private ItemType type;
    private Component name;
    private List<Component> lore;
    private int amount;

    private ButtonImpl(final ItemType type,
                       final Component name,
                       final List<Component> lore,
                       final int amount,
                       final List<Consumer<Click>> clickHandlers) {

        assert type != null;
        assert lore != null;
        assert lore.stream().noneMatch(Objects::isNull);
        assert amount > 0 && amount <= 64;
        assert clickHandlers != null;
        assert clickHandlers.stream().noneMatch(Objects::isNull);

        this.type = type;
        this.name = name;
        this.lore = lore;
        this.amount = amount;
        clickHandlers.forEach(this::onClick);
    }

    @Override
    public Button name(final @Nullable Component name) {

        final Component nameToUse;
        if (name != null) {
            nameToUse = name;
        } else {
            nameToUse = Component.translatable(type.translationKey());
        }
        this.name = nameToUse;
        subscriptionManager.notify((subscriber) -> subscriber.name(nameToUse));
        return this;
    }

    @Override
    public Component name() {

        return name;
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

        final List<Component> loreToUse = List.copyOf(lore);

        this.lore = loreToUse;
        subscriptionManager.notify((subscriber) -> subscriber.lore(loreToUse));
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
        subscriptionManager.notify((subscriber) -> subscriber.amount(amount));
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
        subscriptionManager.notify((subscriber) -> subscriber.type(type));
        return this;
    }

    @Override
    public ItemType type() {

        return type;
    }

    @Override
    public void click(final Click click) {

        Objects.requireNonNull(click, "click cannot be null");

        subscriptionManager.notify((subscriber) -> subscriber.click(click));
    }

    @Override
    public Button onClick(final Consumer<Click> handler) {

        Objects.requireNonNull(handler, "handler cannot be null");

        subscribe(new Subscriber() {
            @Override
            public void exception(final RuntimeException thrown) {

            }

            @Override
            public void name(final Component name) {

            }

            @Override
            public void lore(final List<Component> lore) {

            }

            @Override
            public void amount(final int amount) {

            }

            @Override
            public void type(final ItemType type) {

            }

            @Override
            public void click(final Click click) {

                handler.accept(click);
            }
        });

        return this;
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        return subscriptionManager.subscribe(subscriber);
    }

    /**
     * The default implementation of {@link Button.Builder}.
     *
     * @see Button#button()
     */
    static final class BuilderImpl implements Builder {

        private final List<Consumer<Click>> clickHandlers = new ArrayList<>(0);
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
        public Builder onClick(final Consumer<Click> handler) {

            Objects.requireNonNull(handler, "handler cannot be null");

            clickHandlers.add(handler);
            return this;
        }

        @Override
        public Button type(final ItemType type) {

            Objects.requireNonNull(type, "type cannot be null");

            return new ButtonImpl(
                    type,
                    name == null ? Component.translatable(type.translationKey()) : name,
                    lore,
                    amount,
                    clickHandlers);
        }
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;
import org.jspecify.nullness.Nullable;

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

    static final Button.Factory FACTORY = ButtonImpl::new;

    private final Subscribers<Subscriber> subscribers = new Subscribers<>();

    private ItemType type;
    private Component name;
    private List<Component> lore = List.of();
    private int amount = 1;
    private boolean glow = false;

    ButtonImpl(final ItemType type) {

        Objects.requireNonNull(type, "type cannot be null");

        this.type = type;
        this.name = Component.translatable(type);
    }

    @Override
    public Button name(final @Nullable Component name) {

        if (name != null) {
            this.name = name;
        } else {
            this.name = Component.translatable(type);
        }
        subscribers.notify((subscriber) -> subscriber.name(this.name));
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

        this.lore = List.copyOf(lore);
        subscribers.notify((subscriber) -> subscriber.lore(this.lore));
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
        subscribers.notify((subscriber) -> subscriber.amount(amount));
        return this;
    }

    @Override
    public int amount() {

        return amount;
    }

    @Override
    public Button glow(final boolean glow) {

        this.glow = glow;
        subscribers.notify((subscriber) -> subscriber.glow(glow));
        return this;
    }

    @Override
    public boolean glow() {

        return glow;
    }

    @Override
    public Button type(final ItemType type) {

        Objects.requireNonNull(type, "type cannot be null");

        this.type = type;
        subscribers.notify((subscriber) -> subscriber.type(type));
        return this;
    }

    @Override
    public ItemType type() {

        return type;
    }

    @Override
    public void click(final Click click) {

        Objects.requireNonNull(click, "click cannot be null");

        subscribers.notify((subscriber) -> subscriber.click(click));
    }

    @Override
    public Button onClick(final Consumer<Click> handler) {

        Objects.requireNonNull(handler, "handler cannot be null");

        subscribe(new Subscriber() {

            @Override
            public void click(final Click click) {

                handler.accept(click);
            }
        });

        return this;
    }

    @Override
    public Subscription subscribe(final Subscriber subscriber) {

        return subscribers.subscribe(subscriber);
    }

    @Override
    public String toString() {

        return String.format(
                "ButtonImpl[type=%s, name=%s, lore=%s, amount=%s, glow=%s]",
                type,
                name,
                lore,
                amount,
                glow);
    }
}

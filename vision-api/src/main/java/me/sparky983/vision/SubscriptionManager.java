package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jspecify.nullness.NullMarked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Manages subscriptions for a button and provides a simple API for notifying subscribers.
 */
@NullMarked
final class SubscriptionManager implements Button.Subscriber {

    private final Map<Button.Subscription, Button.Subscriber> subscribers = new HashMap<>();

    public Button.Subscription subscribe(final Button.Subscriber subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        final Button.Subscription subscription = new Button.Subscription() {
            @Override
            public void cancel() {
                subscribers.remove(this);
            }

            @Override
            public boolean isCancelled() {
                return !subscribers.containsKey(this);
            }
        };
        subscribers.put(subscription, subscriber);
        return subscription;
    }

    @Override
    public void name(final Component name) {

        Objects.requireNonNull(name, "name cannot be null");

        for (final Button.Subscriber subscriber : subscribers.values()) {
            subscriber.name(name);
        }
    }

    @Override
    public void lore(final List<Component> lore) {

        Objects.requireNonNull(lore, "lore cannot be null");

        for (int i = 0; i < lore.size(); i++) {
            Objects.requireNonNull(lore.get(i), "lore[" + i + "] cannot be null");
        }

        for (final Button.Subscriber subscriber : subscribers.values()) {
            subscriber.lore(lore);
        }
    }

    @Override
    public void amount(final int amount) {

        if (amount <= 0 || amount > 64) {
            throw new IllegalArgumentException("amount must be between 1 and 64");
        }

        for (final Button.Subscriber subscriber : subscribers.values()) {
            subscriber.amount(amount);
        }
    }

    @Override
    public void type(final ItemType type) {

        Objects.requireNonNull(type, "type cannot be null");

        for (final Button.Subscriber subscriber : subscribers.values()) {
            subscriber.type(type);
        }
    }
}

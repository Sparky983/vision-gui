package me.sparky983.vision;

import org.jspecify.nullness.NullMarked;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Manages subscriptions for a button and provides a simple API for notifying subscribers.
 */
@NullMarked
final class SubscriptionManager<T extends Subscribable.Subscriber> {

    private final Map<Subscription, T> subscribers = new HashMap<>();

    Subscription subscribe(final T subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        final Subscription subscription = new Subscription() {
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

    void notify(Consumer<? super T> consumer) {
        for (final T subscriber : subscribers.values()) {
            try {
                consumer.accept(subscriber);
            } catch (final RuntimeException e) {
                exception(e);
            }
        }
    }

    private void exception(final RuntimeException thrown) {
        for (final T subscriber : subscribers.values()) {
            try {
                subscriber.exception(thrown);
            } catch (final RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}

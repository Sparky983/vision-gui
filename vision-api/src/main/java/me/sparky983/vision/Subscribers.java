package me.sparky983.vision;

import org.jspecify.nullness.NullMarked;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A representation of a {@link Subscribable}'s
 * {@link Subscribable.Subscriber Subscribable.Subscribers}.
 */
@NullMarked
final class Subscribers<T extends Subscribable.Subscriber> implements Subscribable<T> {

    private final Map<Subscription, T> subscribers = new HashMap<>();

    @Override
    public Subscription subscribe(final T subscriber) {

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

    void notify(final Consumer<? super T> consumer) {
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

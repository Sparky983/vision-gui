package me.sparky983.vision;

import org.jspecify.nullness.NullMarked;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A representation of a {@link Publisher}'s
 * {@link Publisher.Subscriber Publisher.Subscribers}.
 */
@NullMarked
final class Subscribers<T extends Publisher.Subscriber> implements Publisher<T> {

    private final Map<Subscription, T> subscribers = new HashMap<>();

    @Override
    public Subscription subscribe(final T subscriber) {

        Objects.requireNonNull(subscriber, "subscriber cannot be null");

        final Subscription subscription = new Subscription() {
            @Override
            public void cancel() {

                if (subscribers.remove(this) == null) {
                    throw new IllegalStateException("Subscription has already been cancelled");
                }
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
            } catch (final Throwable e) {
                exception(e);
            }
        }
    }

    private void exception(final Throwable thrown) {

        for (final T subscriber : subscribers.values()) {
            try {
                subscriber.exception(thrown);
            } catch (final Throwable e) {
                e.printStackTrace();
            }
        }
    }
}

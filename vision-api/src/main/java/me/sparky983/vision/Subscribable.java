package me.sparky983.vision;

import org.jspecify.annotations.NullMarked;

/**
 * Represents an object that publishes events.
 *
 * @param <T> the type of subscriber
 * @see Button
 * @see Gui
 * @since 0.1
 */
@NullMarked
public interface Subscribable<T extends Subscribable.Subscriber> {

    /**
     * Subscribes the specified subscriber to this {@code Subscribable} object.
     *
     * @param subscriber the subscriber
     * @return a subscription that can be used to unsubscribe the subscriber
     * @throws NullPointerException if the subscriber is {@code null}.
     * @since 0.1
     */
    Subscription subscribe(T subscriber);

    /**
     * Represents a subscriber to a {@link Subscribable} object.
     *
     * @see Button.Subscriber
     * @see Gui.Subscriber
     * @since 0.1
     */
    interface Subscriber {

    }
}

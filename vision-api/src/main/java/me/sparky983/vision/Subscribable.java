package me.sparky983.vision;

/**
 * Represents a subscribable object.
 *
 * @param <T> the type of subscriber
 * @since 0.1
 */
public interface Subscribable<T extends Subscriber> {

    /**
     * Subscribes the specified subscriber to this button.
     *
     * @param subscriber the subscriber
     * @return a subscription that can be used to unsubscribe the subscriber
     * @throws NullPointerException if the subscriber is {@code null}.
     * @since 0.1
     */
    Subscription subscribe(T subscriber);
}

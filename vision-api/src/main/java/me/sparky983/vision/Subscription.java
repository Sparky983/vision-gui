package me.sparky983.vision;


/**
 * Represents a subscription to a {@link Subscribable} object.
 *
 * @see Subscribable#subscribe(Subscribable.Subscriber)
 * @since 0.1
 */
public interface Subscription {

    /**
     * Cancels this {@code Subscription}.
     *
     * @since 0.1
     */
    void cancel();

    /**
     * Checks whether this {@code Subscription} is cancelled.
     *
     * @return whether this {@code Subscription} is cancelled
     * @since 0.1
     */
    boolean isCancelled();
}

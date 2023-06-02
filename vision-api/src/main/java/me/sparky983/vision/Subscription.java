package me.sparky983.vision;


/**
 * Represents a subscription to a {@link Subscribable subscribable object}.
 *
 * @see Subscribable#subscribe(Subscriber)
 * @since 0.1
 */
public interface Subscription {

    /**
     * Cancels this subscription.
     *
     * @since 0.1
     */
    void cancel();

    /**
     * Checks whether this subscription is cancelled.
     *
     * @return whether this subscription is cancelled
     * @since 0.1
     */
    boolean isCancelled();
}

package me.sparky983.vision;

/**
 * Represents a subscribable object.
 *
 * @param <T> the type of subscriber
 * @since 0.1
 */
public interface Subscribable<T extends Subscribable.Subscriber> {

    /**
     * Subscribes the specified subscriber to this button.
     *
     * @param subscriber the subscriber
     * @return a subscription that can be used to unsubscribe the subscriber
     * @throws NullPointerException if the subscriber is {@code null}.
     * @since 0.1
     */
    Subscription subscribe(T subscriber);

    /**
     * Represents a subscriber to a {@link Subscribable subscribable object}.
     */
    interface Subscriber {

        /**
         * Called when a handling an event throws an exception.
         * <p>
         * If this method throws an exception, the exception may be
         * <a href="https://en.wikipedia.org/wiki/Error_hiding">swallowed</a>.
         *
         * @param thrown the thrown exception
         * @throws NullPointerException if the thrown exception is {@code null} (optional).
         * @since 0.1
         */
        void exception(RuntimeException thrown);
    }
}

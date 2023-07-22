package me.sparky983.vision;

import org.jspecify.nullness.NullMarked;

/**
 * Represents a subscribable object.
 *
 * @param <T> the type of subscriber
 * @see Button
 * @see Gui
 * @since 0.1
 */
@NullMarked
public interface Publisher<T extends Publisher.Subscriber> {

    /**
     * Subscribes the specified subscriber to this {@code Publisher} object.
     *
     * @param subscriber the subscriber
     * @return a subscription that can be used to unsubscribe the subscriber
     * @throws NullPointerException if the subscriber is {@code null}.
     * @since 0.1
     */
    Subscription subscribe(T subscriber);

    /**
     * Represents a subscriber to a {@link Publisher} object.
     *
     * @see Button.Subscriber
     * @see Gui.Subscriber
     * @since 0.1
     */
    interface Subscriber {

        /**
         * Called when a handling an event throws.
         * <p>
         * If this method throws an exception, the exception may be
         * <a href="https://en.wikipedia.org/wiki/Error_hiding">swallowed</a>.
         * <p>
         * The default implementation does nothing.
         *
         * @param thrown the thrown exception
         * @throws NullPointerException if the thrown exception is {@code null} (optional).
         * @since 0.1
         */
        default void exception(final Throwable thrown) {

        }
    }
}

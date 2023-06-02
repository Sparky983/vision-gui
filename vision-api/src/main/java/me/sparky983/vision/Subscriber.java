package me.sparky983.vision;

/**
 * Represents a subscriber to a {@link Subscribable subscribable object}.
 */
public interface Subscriber {

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

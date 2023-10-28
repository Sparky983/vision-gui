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
   * @throws IllegalStateException if this {@code Subscription} has already been cancelled.
   */
  void cancel();

  /**
   * Checks whether this {@code Subscription} is canceled.
   *
   * @return whether this {@code Subscription} is canceled
   * @since 0.1
   */
  @Deprecated(forRemoval = true)
  default boolean isCancelled() {
    return isCanceled();
  }

  /**
   * Checks whether this {@code Subscription} is canceled.
   *
   * @return whether this {@code Subscription} is canceled
   * @since 1.1
   */
  boolean isCanceled();
}

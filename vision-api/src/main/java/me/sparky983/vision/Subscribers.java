package me.sparky983.vision;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import org.jspecify.annotations.NullMarked;

/**
 * A representation of a {@link Subscribable}'s
 * {@link Subscribable.Subscriber Subscribable.Subscribers}.
 */
@NullMarked
final class Subscribers<T extends Subscribable.Subscriber> implements Subscribable<T> {
  private Map<Subscription, T> subscribers = new HashMap<>();

  @Override
  public Subscription subscribe(final T subscriber) {
    Objects.requireNonNull(subscriber, "subscriber cannot be null");

    final Subscription subscription = new Subscription() {
      @Override
      public void cancel() {
        final Map<Subscription, T> copy = new HashMap<>(subscribers);
        if (copy.remove(this) == null) {
          throw new IllegalStateException("Subscription has already been cancelled");
        }
        subscribers = copy;
      }

      @Override
      public boolean isCancelled() {
        return !subscribers.containsKey(this);
      }
    };

    final Map<Subscription, T> copy = new HashMap<>(subscribers);
    copy.put(subscription, subscriber);
    subscribers = copy;
    return subscription;
  }

  void notify(final Consumer<? super T> consumer) {
    for (final T subscriber : subscribers.values()) {
      try {
        consumer.accept(subscriber);
      } catch (final Throwable e) {
        e.printStackTrace();
      }
    }
  }
}

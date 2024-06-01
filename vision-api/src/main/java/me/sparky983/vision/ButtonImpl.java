package me.sparky983.vision;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import me.sparky983.state.State;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * The default implementation of {@link Button}.
 *
 * @see Button#of(ItemType)
 */
@NullMarked
final class ButtonImpl implements Button {
  private final Subscribers<Subscriber> subscribers = new Subscribers<>();
  private final Publisher publisher = new PublisherImpl();

  private ItemType type;
  private Component name;
  private List<Component> lore;
  private int amount;
  private boolean glow;

  ButtonImpl(final ItemType type) {
    Objects.requireNonNull(type, "type cannot be null");

    this.type = type;
    this.name = Component.translatable(type);
    this.lore = List.of();
    this.amount = 1;
    this.glow = false;
  }

  ButtonImpl(final Button button) {
    Objects.requireNonNull(button, "button cannot be null");

    this.type = button.type();
    this.name = button.name();
    this.lore = button.lore();
    this.amount = button.amount();
    this.glow = button.glow();
  }

  @Override
  public ItemType type() {
    return type;
  }

  @Override
  public Button type(final ItemType type) {
    Objects.requireNonNull(type, "type cannot be null");

    this.type = type;
    subscribers.notify((subscriber) -> subscriber.type(type));
    return this;
  }

  @Override
  public Button type(final State<? extends ItemType> type) {
    Objects.requireNonNull(type, "type cannot be null");

    type.subscribe(this::type);
    return this;
  }

  @Override
  public Component name() {
    return name;
  }

  @Override
  public Button name(final @Nullable Component name) {
    if (name != null) {
      this.name = name;
    } else {
      this.name = Component.translatable(type);
    }
    subscribers.notify((subscriber) -> subscriber.name(this.name));
    return this;
  }

  @Override
  public Button name(final State<? extends @Nullable Component> type) {
    Objects.requireNonNull(type, "type");

    type.subscribe(this::name);
    return this;
  }

  @Override
  public List<Component> lore() {
    return lore;
  }

  @Override
  public Button lore(final Component... lore) {
    Objects.requireNonNull(lore, "lore cannot be null");

    return lore(Arrays.asList(lore));
  }

  @Override
  public Button lore(final List<? extends Component> lore) {
    Objects.requireNonNull(lore, "lore cannot be null");

    for (int i = 0; i < lore.size(); i++) {
      Objects.requireNonNull(lore.get(i), "lore[" + i + "] cannot be null");
    }

    this.lore = List.copyOf(lore);
    subscribers.notify((subscriber) -> subscriber.lore(this.lore));
    return this;
  }

  @Override
  public Button lore(final State<? extends List<? extends Component>> lore) {
    Objects.requireNonNull(lore, "lore cannot be null");

    lore.subscribe(this::lore);
    return this;
  }

  @Override
  public int amount() {
    return amount;
  }

  @Override
  public Button amount(final int amount) {
    if (amount <= 0 || amount > 64) {
      throw new IllegalArgumentException("amount must be between 1 and 64");
    }

    this.amount = amount;
    subscribers.notify((subscriber) -> subscriber.amount(amount));
    return this;
  }

  @Override
  public Button amount(final State<Integer> amount) {
    Objects.requireNonNull(amount, "amount cannot be null");

    amount.subscribe(this::amount);
    return this;
  }

  @Override
  public boolean glow() {
    return glow;
  }

  @Override
  public Button glow(final boolean glow) {
    this.glow = glow;
    subscribers.notify((subscriber) -> subscriber.glow(glow));
    return this;
  }

  @Override
  public Button glow(final State<Boolean> glow) {
    Objects.requireNonNull(glow, "glow cannot be null");

    glow.subscribe(this::glow);
    return this;
  }

  @Override
  public Button onClick(final Consumer<? super Click> handler) {
    Objects.requireNonNull(handler, "handler cannot be null");

    subscribe(new Subscriber() {
      @Override
      public void click(final Click click) {
        handler.accept(click);
      }
    });

    return this;
  }

  @Override
  public Publisher publisher() {
    return publisher;
  }

  @Override
  public Subscription subscribe(final Subscriber subscriber) {
    return subscribers.subscribe(subscriber);
  }

  @Override
  public String toString() {
    return String.format(
        "ButtonImpl[type=%s, name=%s, lore=%s, amount=%s, glow=%s]",
        type, name, lore, amount, glow);
  }

  private final class PublisherImpl implements Publisher {
    @Override
    public void click(final Click click) {
      Objects.requireNonNull(click, "click cannot be null");

      subscribers.notify((subscriber) -> subscriber.click(click));
    }
  }
}

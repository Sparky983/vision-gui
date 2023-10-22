package me.sparky983.vision;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * The default implementation of {@link Chest}.
 *
 * @see Gui#chest()
 */
@NullMarked
final class ChestImpl implements Chest {
  @VisibleForTesting
  static final Component DEFAULT_TITLE = Component.translatable("container.chest");

  @VisibleForTesting
  static final int DEFAULT_ROWS = 1;

  private final Container container;

  private ChestImpl(final Container container) {
    assert container != null;

    this.container = container;
  }

  @Override
  public GuiType type() {
    return GuiType.CHEST;
  }

  @Override
  public Component title() {
    return container.title();
  }

  @Override
  public int columns() {
    return container.columns();
  }

  @Override
  public int rows() {
    return container.rows();
  }

  @Override
  public Optional<Button> button(final Slot slot) {
    return container.button(slot);
  }

  @Override
  public Chest button(final Slot slot, final @Nullable Button button) {
    container.button(slot, button);
    return this;
  }

  @Override
  public List<Slot> slots() {
    return container.slots();
  }

  @Override
  public Gui onClose(final Consumer<? super Close> handler) {
    container.onClose(handler);
    return this;
  }

  @Override
  public Publisher publisher() {
    return container.publisher();
  }

  @Override
  public Subscription subscribe(final Subscriber subscriber) {
    return container.subscribe(subscriber);
  }

  @Override
  public String toString() {
    return String.format("ChestImpl[title=%s, rows=%s]", title(), rows());
  }

  /**
   * The default implementation of {@link Chest.Builder}.
   *
   * @see Gui#chest()
   */
  static final class BuilderImpl implements Builder {
    private final Container.Builder container =
        Container.builder(DEFAULT_TITLE, DEFAULT_ROWS, COLUMNS);

    @Override
    public Builder rows(final int rows) {
      container.rows(rows);
      return this;
    }

    @Override
    public Builder title(final Component title) {
      container.title(title);
      return this;
    }

    @Override
    public Builder button(final Slot slot, final Button button) {
      container.button(slot, button);
      return this;
    }

    @Override
    public Builder fill(final Button button) {
      container.fill(button);
      return this;
    }

    @Override
    public Builder border(final Button button, final Set<? extends Border> borders) {
      container.border(button, borders);
      return this;
    }

    @Override
    public Builder border(final Button button, final Border... borders) {
      container.border(button, borders);
      return this;
    }

    @Override
    public Builder border(final Button button) {
      container.border(button);
      return this;
    }

    @Override
    public Chest build() {
      return new ChestImpl(container.build());
    }
  }
}

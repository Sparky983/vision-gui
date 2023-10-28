package me.sparky983.vision;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * The default implementation of {@link Dropper}.
 *
 * @see Gui#dropper()
 */
@NullMarked
final class DropperImpl implements Dropper {
  @VisibleForTesting
  static final Component DEFAULT_TITLE = Component.translatable("container.dropper");

  private final Container container;

  DropperImpl(final Container container) {
    assert container != null;

    this.container = container;
  }

  @Override
  public GuiType type() {
    return GuiType.DROPPER;
  }

  @Override
  public Component title() {
    return container.title();
  }

  @Override
  public int rows() {
    return container.rows();
  }

  @Override
  public int columns() {
    return container.columns();
  }

  @Override
  public Optional<Button> slot(final Slot slot) {
    return container.button(slot);
  }

  @Override
  public Dropper slot(final Slot slot, final @Nullable Button button) {
    container.button(slot, button);
    return this;
  }

  @Override
  public List<Slot> slots() {
    return container.slots();
  }

  @Override
  public Subscription subscribe(final Gui.Subscriber subscriber) {
    return container.subscribe(subscriber);
  }

  @Override
  public String toString() {
    return String.format("DropperImpl[title=%s]", title());
  }

  /**
   * The default implementation of {@link Dropper.Builder}.
   *
   * @see Gui#dropper()
   */
  static final class BuilderImpl implements Builder {
    private final Container.Builder container = Container.builder(DEFAULT_TITLE, ROWS, COLUMNS);

    @Override
    public Builder title(final Component title) {
      container.title(title);
      return this;
    }

    @Override
    public Builder slot(final Slot slot, final Button button) {
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
    public Dropper build() {
      return new DropperImpl(container.build());
    }
  }
}

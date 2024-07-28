package me.sparky983.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A representation of a {@link Gui}'s contents.
 * <p>
 * Used by all default implementations of each {@link Gui} variant.
 *
 * @see Container#builder(Component, int, int)
 */
@NullMarked
final class Container implements Subscribable<Gui.Subscriber> {
  @VisibleForTesting
  static final String SLOT_OUT_OF_BOUNDS =
      "Button at (%s, %s) is out of bounds for %s rows and %s columns";

  /**
   * The minimum number of rows a {@link Container} can have.
   */
  private static final int MIN_ROWS = Chest.MIN_ROWS;

  /**
   * The maximum number of rows a {@link Container} can have.
   */
  private static final int MAX_ROWS = Chest.MAX_ROWS;

  /**
   * The minimum number of columns a {@link Container} can have.
   */
  private static final int MIN_COLUMNS = 1;

  /**
   * The maximum number of columns a {@link Container} can have.
   */
  private static final int MAX_COLUMNS = Chest.COLUMNS;

  private final Subscribers<Gui.Subscriber> subscribers = new Subscribers<>();
  private final Gui.Publisher publisher = new PublisherImpl();

  private final Map<Slot, Button> buttons;
  private final Component title;
  private final int rows;
  private final int columns;
  private final List<Slot> slots;

  private Container(
      final Component title, final int rows, final int columns, final Map<Slot, Button> buttons) {
    assert title != null;
    assert rows >= 1 && rows <= MAX_ROWS;
    assert columns >= 1 && columns <= MAX_COLUMNS;
    assert buttons.keySet().stream().allMatch(Objects::nonNull);
    assert buttons.values().stream().allMatch(Objects::nonNull);
    assert buttons.keySet().stream().allMatch((slot) -> slot.row() <= rows);
    assert buttons.keySet().stream().allMatch((slot) -> slot.column() <= columns);

    this.title = title;
    this.rows = rows;
    this.columns = columns;
    this.buttons = buttons;

    final List<Slot> slots = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        slots.add(Slot.of(row, column));
      }
    }
    this.slots = Collections.unmodifiableList(slots);
  }

  /**
   * Creates a new {@code Container.Builder}.
   *
   * @param title the title
   * @param rows the number of rows
   * @param columns the number of columns
   * @return the newly created {@code Container}
   * @throws IllegalArgumentException if the number of rows is not from 1 to 6 or the number of
   * columns is not from 1 to 9.
   * @throws NullPointerException if the title is {@code null}.
   */
  static Container.Builder builder(final Component title, final int rows, final int columns) {
    return new Container.Builder(title, rows, columns);
  }

  Component title() {
    return title;
  }

  int columns() {
    return columns;
  }

  int rows() {
    return rows;
  }

  Optional<Button> slot(final Slot slot) {
    Objects.requireNonNull(slot, "slot cannot be null");

    if (slot.column() >= columns || slot.row() >= rows) {
      throw new IllegalArgumentException(
          String.format(SLOT_OUT_OF_BOUNDS, slot.row(), slot.column(), rows, columns));
    }

    return Optional.ofNullable(buttons.get(slot));
  }

  void slot(final Slot slot, final @Nullable Button button) {
    Objects.requireNonNull(slot, "slot cannot be null");

    if (slot.row() >= rows || slot.column() >= columns) {
      throw new IllegalArgumentException(
          String.format(SLOT_OUT_OF_BOUNDS, slot.row(), slot.column(), rows, columns));
    }

    if (button == null) {
      buttons.remove(slot);
    } else {
      buttons.put(slot, button);
    }
    subscribers.notify(
        (subscriber) -> {
          subscriber.button(slot, button); // Backwards compatibility
          subscriber.slot(slot, button);
        });
  }

  List<Slot> slots() {
    return slots;
  }

  void onClose(final Consumer<? super Close> handler) {
    Objects.requireNonNull(handler, "handler cannot be null");

    subscribers.subscribe(
        new Gui.Subscriber() {
          @Override
          public void close(final Close close) {
            handler.accept(close);
          }
        });
  }

  Gui.Publisher publisher() {
    return publisher;
  }

  @Override
  public Subscription subscribe(final Gui.Subscriber subscriber) {
    Objects.requireNonNull(subscriber, "subscriber cannot be null");

    return subscribers.subscribe(subscriber);
  }

  /**
   * A {@link Container} builder.
   */
  static final class Builder {
    private final Map<Slot, Button> buttons = new HashMap<>();
    private final Map<Border, Button> borders = new LinkedHashMap<>();
    private final List<Consumer<? super Close>> closeHandlers = new ArrayList<>(1);
    private @Nullable Button filler = null;
    private Component title;
    private int rows;
    private int columns;

    private Builder(final Component title, final int rows, final int columns) {
      title(title);
      rows(rows);
      columns(columns);
    }

    Builder title(final Component title) {
      Objects.requireNonNull(title, "title cannot be null");

      this.title = title;
      return this;
    }

    Builder rows(final int rows) {
      if (rows < MIN_ROWS || rows > MAX_ROWS) {
        throw new IllegalArgumentException("rows must be between 1 and " + MAX_ROWS);
      }

      this.rows = rows;
      return this;
    }

    Builder columns(final int columns) {
      if (columns < MIN_COLUMNS || columns > MAX_COLUMNS) {
        throw new IllegalArgumentException("columns must be between 1 and " + MAX_COLUMNS);
      }

      this.columns = columns;
      return this;
    }

    Builder slot(final Slot slot, final Button button) {
      Objects.requireNonNull(slot, "slot cannot be null");
      Objects.requireNonNull(button, "button cannot be null");

      buttons.put(slot, button);
      return this;
    }

    Builder fill(final Button button) {
      Objects.requireNonNull(button, "button cannot be null");

      this.filler = button;
      return this;
    }

    Builder border(final Set<? extends Border> borders, final Button button) {
      Objects.requireNonNull(button, "button cannot be null");
      Objects.requireNonNull(borders, "borders cannot be null");

      for (final Border border : borders) {
        Objects.requireNonNull(border, "borders cannot contain null");
      }

      if (borders.isEmpty()) {
        throw new IllegalArgumentException(
            """
                        borders cannot be empty
                        to set all borders, use Gui.Builder.border(Button) instead""");
      }

      for (final Border border : borders) {
        this.borders.remove(border); // remove so that the last one wins
        this.borders.put(border, button);
      }
      return this;
    }

    Builder border(final Border border, final Button button) {
      Objects.requireNonNull(border, "border cannot be null");

      return border(Set.of(border), button);
    }

    Builder border(final Button button) {
      return border(Border.all(), button);
    }

    Builder onClose(final Consumer<? super Close> handler) {
      Objects.requireNonNull(handler, "handler cannot be null");

      closeHandlers.add(handler);
      return this;
    }

    Container build() {
      final Map<Slot, Button> buttons = new HashMap<>();

      for (final Slot slot : this.buttons.keySet()) {
        if (slot.row() >= rows || slot.column() >= columns) {
          throw new IllegalStateException(
              String.format(SLOT_OUT_OF_BOUNDS, slot.row(), slot.column(), rows, columns));
        }
      }

      if (filler != null) {
        for (int row = 0; row < rows; row++) {
          for (int column = 0; column < columns; column++) {
            buttons.put(Slot.of(row, column), filler);
          }
        }
      }

      for (final Map.Entry<Border, Button> entry : borders.entrySet()) {
        final Button button = entry.getValue();
        switch (entry.getKey()) {
          case TOP -> {
            for (int column = 0; column < columns; column++) {
              buttons.put(Slot.of(0, column), button);
            }
          }
          case BOTTOM -> {
            for (int column = 0; column < columns; column++) {
              buttons.put(Slot.of(rows - 1, column), button);
            }
          }
          case LEFT -> {
            for (int row = 0; row < rows; row++) {
              buttons.put(Slot.of(row, 0), button);
            }
          }
          case RIGHT -> {
            for (int row = 0; row < rows; row++) {
              buttons.put(Slot.of(row, columns - 1), button);
            }
          }
        }
      }

      buttons.putAll(this.buttons);

      final Container container = new Container(title, rows, columns, buttons);
      closeHandlers.forEach(container::onClose);
      return container;
    }
  }

  private final class PublisherImpl implements Gui.Publisher {
    @Override
    public void close(final Close close) {
      Objects.requireNonNull(close, "close cannot be null");

      subscribers.notify((subscriber) -> subscriber.close(close));
    }
  }
}

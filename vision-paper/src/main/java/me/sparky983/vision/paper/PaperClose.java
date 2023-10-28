package me.sparky983.vision.paper;

import java.util.Objects;
import me.sparky983.vision.Close;
import me.sparky983.vision.Gui;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

/**
 * The paper implementation of {@link Close}.
 */
@NullMarked
final class PaperClose implements Close {
  private final Player closer;
  private final Gui gui;
  private final PaperVision vision;

  /**
   * Creates a new {@code PaperClose}.
   *
   * @param closer the closer
   * @param gui the {@link Gui} that was closed
   * @throws NullPointerException if the closer or the GUI is {@code null}.
   */
  PaperClose(final Player closer, final Gui gui, final PaperVision vision) {
    Objects.requireNonNull(closer, "closer cannot be null");
    Objects.requireNonNull(gui, "gui cannot be null");
    Objects.requireNonNull(vision, "vision cannot be null");

    this.closer = closer;
    this.gui = gui;
    this.vision = vision;
  }

  @Override
  public void open(final Gui gui) {
    vision.open(closer, gui);
  }

  @Override
  public Player closer() {
    return closer;
  }

  @Override
  public Gui gui() {
    return gui;
  }
}

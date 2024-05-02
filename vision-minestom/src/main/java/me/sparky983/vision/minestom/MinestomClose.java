package me.sparky983.vision.minestom;

import java.util.Objects;
import me.sparky983.vision.Close;
import me.sparky983.vision.Gui;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.entity.Player;

final class MinestomClose implements Close {
  private final Player closer;
  private final Gui gui;
  private final MinestomVision vision;

  MinestomClose(final Player closer, final Gui gui, final MinestomVision vision) {
    this.closer = Objects.requireNonNull(closer, "closer cannot be null");
    this.gui = Objects.requireNonNull(gui, "gui cannot be null");
    this.vision = Objects.requireNonNull(vision, "vision cannot be null");
  }

  @Override
  public Audience closer() {
    return closer;
  }

  @Override
  public void open(final Gui gui) {
    Objects.requireNonNull(gui, "gui cannot be null");

    vision.open(closer, gui);
  }

  @Override
  public Gui gui() {
    return gui;
  }
}

package me.sparky983.vision.minestom;

import me.sparky983.vision.Gui;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

@ApiStatus.NonExtendable
@NullMarked
public interface MinestomVision {
  static MinestomVision create() {
    return new MinestomVisionImpl();
  }

  void open(Player player, Gui gui);
}

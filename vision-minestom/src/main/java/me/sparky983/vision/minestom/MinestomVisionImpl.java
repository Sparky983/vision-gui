package me.sparky983.vision.minestom;

import java.util.Objects;
import me.sparky983.vision.Gui;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class MinestomVisionImpl implements MinestomVision {
  private final MirroredInventoryFactory inventoryFactory =
      new SubscribingMirroredInventoryFactory(this);

  @Override
  public void open(final Player player, final Gui gui) {
    Objects.requireNonNull(player, "player cannot be null");
    Objects.requireNonNull(gui, "gui cannot be null");

    final Inventory inventory = inventoryFactory.create(gui, player.getLocale());

    player.openInventory(inventory);
  }
}

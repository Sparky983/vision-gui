package me.sparky983.vision.minestom;

import java.util.Locale;
import java.util.Objects;
import me.sparky983.vision.Gui;
import net.minestom.server.MinecraftServer;
import net.minestom.server.ServerProcess;
import net.minestom.server.entity.Player;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.trait.InventoryEvent;
import net.minestom.server.inventory.Inventory;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class MinestomVisionImpl implements MinestomVision {

  private final MirroredInventoryFactory inventoryFactory;

  MinestomVisionImpl() {
    final EventNode<InventoryEvent> inventoryNode = EventNode.type("inventory", EventFilter.INVENTORY);
    inventoryFactory = new SubscribingMirroredInventoryFactory(
        this,
        new MinestomComponentRenderer(),
        inventoryNode);
    MinecraftServer.getGlobalEventHandler().addChild(inventoryNode);
  }

  @Override
  public void open(final Player player, final Gui gui) {
    Objects.requireNonNull(player, "player cannot be null");
    Objects.requireNonNull(gui, "gui cannot be null");

    final Locale locale = player.getLocale();

    final Inventory inventory = inventoryFactory.create(gui,
        locale != null ? locale : Locale.getDefault());

    player.openInventory(inventory);
  }
}

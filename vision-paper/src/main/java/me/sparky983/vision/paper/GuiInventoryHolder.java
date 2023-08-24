package me.sparky983.vision.paper;

import java.util.Objects;
import java.util.function.Function;
import me.sparky983.vision.Gui;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class GuiInventoryHolder implements InventoryHolder {
  private final Gui gui;
  private final Inventory inventory;

  GuiInventoryHolder(
      final Gui gui, final Function<? super InventoryHolder, Inventory> inventoryFactory) {
    Objects.requireNonNull(gui, "gui cannot be null");
    Objects.requireNonNull(inventoryFactory, "inventory cannot be null");

    this.gui = gui;
    this.inventory = inventoryFactory.apply(this);
  }

  @Override
  public Inventory getInventory() {
    return inventory;
  }

  public Gui gui() {
    return gui;
  }
}

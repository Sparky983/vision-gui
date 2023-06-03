package me.sparky983.vision;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jspecify.nullness.NullMarked;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

@NullMarked
final class GuiInventoryHolder implements InventoryHolder {

    private final Gui gui;
    private final Inventory inventory;

    GuiInventoryHolder(final Gui gui,
                       final Function<? super InventoryHolder, Inventory> inventoryFactory) {

        Objects.requireNonNull(gui, "gui cannot be null");
        Objects.requireNonNull(inventoryFactory, "inventory cannot be null");

        this.gui = gui;
        this.inventory = inventoryFactory.apply(this);
    }

    @Override
    public @NotNull Inventory getInventory() {

        return inventory;
    }

    public Gui gui() {

        return gui;
    }
}

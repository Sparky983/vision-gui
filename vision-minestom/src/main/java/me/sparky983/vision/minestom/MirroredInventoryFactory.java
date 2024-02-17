package me.sparky983.vision.minestom;

import java.util.Locale;
import me.sparky983.vision.Gui;
import net.minestom.server.inventory.Inventory;
import org.jspecify.annotations.NullMarked;

@NullMarked
interface MirroredInventoryFactory {
  Inventory create(Gui gui, Locale locale);
}

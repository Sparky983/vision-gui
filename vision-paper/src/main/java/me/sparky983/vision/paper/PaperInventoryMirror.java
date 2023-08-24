package me.sparky983.vision.paper;

import java.util.Locale;
import me.sparky983.vision.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NullMarked;

/**
 * Mirrors {@link Gui} to {@link Inventory Inventories}.
 */
@NullMarked
interface PaperInventoryMirror {
  /**
   * Mirrors the specified {@link Gui} to the specified {@link Inventory}.
   *
   * @param gui the gui to be mirrored
   * @param locale the locale to render {@link Component Components} with
   * @return the mirroring inventory
   * @throws NullPointerException if the gui or the locale is {@code null}.
   */
  Inventory mirror(Gui gui, Locale locale);
}

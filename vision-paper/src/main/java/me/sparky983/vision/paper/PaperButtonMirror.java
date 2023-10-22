package me.sparky983.vision.paper;

import java.util.Locale;
import me.sparky983.vision.Button;
import me.sparky983.vision.Subscription;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NullMarked;

/**
 * Mirrors {@link Button Buttons} to {@link ItemStack ItemStacks}.
 */
@NullMarked
interface PaperButtonMirror {
  /**
   * Mirrors all the changes to the specified {@link Button} to the specified {@link ItemStack}.
   * <p>
   * The button is a parameter because we need to mirror buttons that weren't created by us.
   *
   * @param button the button to be mirrored
   * @param item the item stack to be mirrored to
   * @param locale the locale to render {@link Component Components} with
   * @throws NullPointerException if the button, the item or the locale is {@code null}.
   */
  Subscription mirror(Button button, ItemStack item, Locale locale);
}

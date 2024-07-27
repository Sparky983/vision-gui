package me.sparky983.vision.paper;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import me.sparky983.vision.Button;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.Subscription;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.renderer.ComponentRenderer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class ButtonMirror {
  private static final ItemFlag[] ITEM_FLAGS = ItemFlag.values();

  private final ComponentRenderer<Locale> componentRenderer;
  private final ItemTypeConverter itemTypeConverter;

  ButtonMirror(
      final ComponentRenderer<Locale> componentRenderer,
      final ItemTypeConverter itemTypeConverter) {
    Objects.requireNonNull(componentRenderer, "componentFixer cannot be null");
    Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

    this.componentRenderer = componentRenderer;
    this.itemTypeConverter = itemTypeConverter;
  }

  Subscription mirror(final Button button, final ItemStack item, final Locale locale) {
    Objects.requireNonNull(button, "button cannot be null");
    Objects.requireNonNull(item, "item cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    item.addItemFlags(ITEM_FLAGS);

    final Button.Subscriber subscriber =
        new Button.Subscriber() {
          @Override
          public void type(final ItemType type) {
            itemTypeConverter.convert(type).ifPresent(item::setType);
          }

          @Override
          public void name(final Component name) {
            item.editMeta((meta) -> meta.displayName(componentRenderer.render(name, locale)));
          }

          @Override
          public void lore(final List<Component> lore) {
            item.editMeta(
                (meta) ->
                    meta.lore(
                        lore.stream()
                            .map((line) -> componentRenderer.render(line, locale))
                            .toList()));
          }

          @Override
          public void amount(final int amount) {
            item.setAmount(amount);
          }

          @Override
          public void glow(final boolean glow) {
            if (glow) {
              item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            } else {
              item.removeEnchantment(Enchantment.DURABILITY);
            }
          }
        };

    // Essentially replay the button's state to the subscriber
    // Ensures that the ItemStack and Button are consistent
    subscriber.type(button.type());
    subscriber.name(button.name());
    subscriber.lore(button.lore());
    subscriber.amount(button.amount());
    subscriber.glow(button.glow());

    return button.subscribe(subscriber);
  }
}

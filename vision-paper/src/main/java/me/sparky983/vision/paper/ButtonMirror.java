package me.sparky983.vision.paper;

import com.google.common.collect.ImmutableMultimap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import me.sparky983.vision.Button;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.Subscription;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.renderer.ComponentRenderer;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class ButtonMirror {
  private static final String UNABLE_TO_MIRROR_MESSAGE =
      """
            Unable to converter item type "%s". Possible causes:
            - The item is not available in this version of Minecraft
            - Legacy materials are enabled
            """;
  private final ComponentRenderer<Locale> componentRenderer;
  private final ItemTypeConverter itemTypeConverter;

  ButtonMirror(
      final ComponentRenderer<Locale> componentRenderer,
      final ItemTypeConverter itemTypeConverter) {
    Objects.requireNonNull(componentRenderer, "componentRenderer cannot be null");
    Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

    this.componentRenderer = componentRenderer;
    this.itemTypeConverter = itemTypeConverter;
  }

  Subscription mirror(
      final Inventory inventory, final int slot, final Button button, final Locale locale) {
    Objects.requireNonNull(inventory, "inventory cannot be null");
    Objects.requireNonNull(button, "button cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    final Material material =
        itemTypeConverter
            .convert(button.type())
            .orElseThrow(
                () ->
                    new IllegalStateException(
                        String.format(UNABLE_TO_MIRROR_MESSAGE, button.type())));
    final ItemStack item = new ItemStack(material, button.amount());
    item.editMeta(
        (meta) -> {
          editName(meta, button.name(), locale);
          editLore(meta, button.lore(), locale);
          meta.setAttributeModifiers(ImmutableMultimap.of());
          meta.setEnchantmentGlintOverride(button.glow());
        });
    inventory.setItem(slot, item);

    // When we call setItem, Bukkit sets the slot to a CraftItemStack with the same properties
    //  which can be mutated and have its changes reflected
    final ItemStack craftItem = inventory.getItem(slot);
    assert craftItem != null;

    final Button.Subscriber subscriber =
        new Button.Subscriber() {
          private ItemStack currentItem = craftItem;

          @Override
          public void type(final ItemType type) {
            itemTypeConverter
                .convert(type)
                .ifPresent(
                    (material) -> {
                      currentItem = currentItem.withType(material);
                      inventory.setItem(slot, item);
                    });
          }

          @Override
          public void name(final Component name) {
            currentItem.editMeta((meta) -> editName(meta, name, locale));
          }

          @Override
          public void lore(final List<Component> lore) {
            currentItem.editMeta((meta) -> editLore(meta, lore, locale));
          }

          @Override
          public void amount(final int amount) {
            currentItem.setAmount(amount);
          }

          @Override
          public void glow(final boolean glow) {
            item.editMeta((meta) -> meta.setEnchantmentGlintOverride(glow));
          }
        };

    return button.subscribe(subscriber);
  }

  private void editName(final ItemMeta meta, final Component name, final Locale locale) {
    meta.displayName(componentRenderer.render(name, locale));
  }

  private void editLore(final ItemMeta meta, final List<Component> lore, final Locale locale) {
    final List<Component> renderedLore =
        lore.stream().map((line) -> componentRenderer.render(line, locale)).toList();
    meta.lore(renderedLore);
  }
}

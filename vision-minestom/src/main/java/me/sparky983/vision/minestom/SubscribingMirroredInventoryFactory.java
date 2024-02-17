package me.sparky983.vision.minestom;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import me.sparky983.vision.Button;
import me.sparky983.vision.ClickType;
import me.sparky983.vision.Gui;
import me.sparky983.vision.Gui.Subscriber;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.Slot;
import me.sparky983.vision.Subscription;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.renderer.ComponentRenderer;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.item.Enchantment;
import net.minestom.server.item.ItemHideFlag;
import net.minestom.server.item.ItemMeta.Builder;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
final class SubscribingMirroredInventoryFactory implements MirroredInventoryFactory {

  private final MinestomVision vision;
  private final ComponentRenderer<Locale> componentRenderer;

  SubscribingMirroredInventoryFactory(final MinestomVision vision,
      final ComponentRenderer<Locale> componentRenderer) {
    this.vision = vision;
    this.componentRenderer = componentRenderer;
  }

  @Override
  public Inventory create(final Gui gui, final Locale locale) {
    Objects.requireNonNull(gui, "gui cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    final InventoryType inventoryType = switch (gui.type()) {
      case CHEST -> switch (gui.rows()) {
        case 1 -> InventoryType.CHEST_1_ROW;
        case 2 -> InventoryType.CHEST_2_ROW;
        case 3 -> InventoryType.CHEST_3_ROW;
        case 4 -> InventoryType.CHEST_4_ROW;
        case 5 -> InventoryType.CHEST_5_ROW;
        case 6 -> InventoryType.CHEST_6_ROW;
        default -> throw new AssertionError("Unexpected value: " + gui.rows());
      };
      case HOPPER -> InventoryType.HOPPER;
      case DROPPER -> InventoryType.WINDOW_3X3;
    };

    final Inventory inventory = new Inventory(inventoryType, gui.title());

    inventory.addInventoryCondition(
        (player, rawSlot, minestomClickType, inventoryConditionResult) -> {
          inventoryConditionResult.setCancel(true);

          final Slot slot = gui.slots().get(rawSlot);
          final ClickType clickType = switch (minestomClickType) {
            case LEFT_CLICK, START_LEFT_DRAGGING -> ClickType.LEFT;
            case RIGHT_CLICK, START_RIGHT_DRAGGING -> ClickType.RIGHT;
            case CHANGE_HELD -> ClickType.NUMBER_KEY;
            case START_SHIFT_CLICK ->
                ClickType.SHIFT_LEFT; // TODO: pr minestom so we can see if it's a left or right click
            case START_DOUBLE_CLICK -> ClickType.DOUBLE_CLICK;
            case DROP -> ClickType.DROP;
            default -> null; // TODO: what triggers half of these
          };

          if (clickType == null) {
            return;
          }

          gui.slot(slot).ifPresent((button) -> button.publisher()
              .click(new MinestomClick(player, button, slot, clickType, vision)));
        });

    final Subscriber subscriber = new Subscriber() {
      private final Map<Slot, Subscription> subscriptions = new HashMap<>();

      @Override
      public void slot(final Slot slot, final @Nullable Button button) {
        final Subscription subscription = subscriptions.get(slot);
        if (subscription != null) {
          subscription.cancel();
        }

        final int rawSlot = slot.column() + (slot.row() * gui.columns());

        if (button == null) {
          inventory.setItemStack(rawSlot, ItemStack.AIR);
          subscriptions.remove(slot);
          return;
        }

        inventory.setItemStack(rawSlot, createItemStack(button, locale));

        subscriptions.put(slot, mirror(inventory, rawSlot, button, locale));
      }
    };

    synchronized (gui) {
      for (final Slot slot : gui.slots()) {
        gui.slot(slot).ifPresent((button) -> {
          // Essentially replaying the button sets
          subscriber.slot(slot, button);
        });
      }

      gui.subscribe(subscriber);
    }

    return inventory;
  }

  private ItemStack createItemStack(final Button button, final Locale locale) {
    return ItemStack.builder(convertItemType(button.type()))
        .displayName(componentRenderer.render(button.name(), locale))
        .lore(button.lore().stream()
            .map((component) -> componentRenderer.render(component, locale)).toList())
        .amount(button.amount())
        .meta((meta) -> {
          meta.hideFlag(ItemHideFlag.values());
          makeGlow(meta, button.glow());
        })
        .build();
  }

  private Material convertItemType(final ItemType type) {
    final Material material = Material.fromNamespaceId(NamespaceID.from(type.key()));

    if (material == null) {
      throw new RuntimeException(); // TODO
    }

    return material;
  }

  private static void makeGlow(final Builder meta, final boolean glow) {
    if (glow) {
      meta.enchantment(Enchantment.UNBREAKING, (short) 1);
    } else {
      meta.clearEnchantment();
    }
  }

  private Subscription mirror(final Inventory inventory, final int slot, final Button button,
      final Locale locale) {
    return button.subscribe(new Button.Subscriber() {
      @Override
      public void type(final ItemType type) {
        inventory.replaceItemStack(slot,
            (itemStack) -> itemStack.withMaterial(convertItemType(type)));
      }

      @Override
      public void name(final Component name) {
        inventory.replaceItemStack(slot, (itemStack) -> itemStack.withDisplayName(
            componentRenderer.render(name, locale)));
      }

      @Override
      public void lore(final List<Component> lore) {
        inventory.replaceItemStack(slot, (itemStack) -> itemStack.withLore(
            lore.stream().map((component) -> componentRenderer.render(component, locale))
                .toList()));
      }

      @Override
      public void amount(final int amount) {
        inventory.replaceItemStack(slot, (itemStack) -> itemStack.withAmount(amount));
      }

      @Override
      public void glow(final boolean glow) {
        inventory.replaceItemStack(slot,
            (itemStack) -> itemStack.withMeta((meta) -> makeGlow(meta, glow)));
      }
    });
  }
}

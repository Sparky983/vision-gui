package me.sparky983.vision.minestom;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import me.sparky983.vision.Button;
import me.sparky983.vision.ClickType;
import me.sparky983.vision.Gui;
import me.sparky983.vision.Gui.Subscriber;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.Slot;
import me.sparky983.vision.Subscription;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.renderer.ComponentRenderer;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.inventory.InventoryCloseEvent;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import net.minestom.server.event.trait.InventoryEvent;
import net.minestom.server.inventory.ContainerInventory;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.inventory.click.Click;
import net.minestom.server.item.ItemComponent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
final class MirroredInventoryFactory {
  private final MinestomVision vision;
  private final ComponentRenderer<Locale> componentRenderer;
  private final EventNode<InventoryEvent> inventoryNode;

  MirroredInventoryFactory(
      final MinestomVision vision,
      final ComponentRenderer<Locale> componentRenderer,
      final EventNode<InventoryEvent> inventoryNode) {
    Objects.requireNonNull(vision, "vision cannot be null");
    Objects.requireNonNull(componentRenderer, "componentRenderer cannot be null");
    Objects.requireNonNull(inventoryNode, "inventoryNode cannot be null");

    this.vision = vision;
    this.componentRenderer = componentRenderer;
    this.inventoryNode = inventoryNode;
  }

  Inventory create(final Gui gui, final Locale locale) {
    Objects.requireNonNull(gui, "gui cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    final InventoryType inventoryType =
        switch (gui.type()) {
          case CHEST ->
              switch (gui.rows()) {
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

    final ContainerInventory guiInventory = new ContainerInventory(inventoryType, gui.title());

    EventNode<InventoryEvent> guiNode =
        EventNode.value("gui-click", EventFilter.INVENTORY, Predicate.isEqual(guiInventory));

    guiNode.addListener(
        InventoryPreClickEvent.class,
        (event) -> {
          event.setCancelled(true);

          record SlotClick(ClickType type, int rawSlot) {}

          final SlotClick slotClick =
              switch (event.getClickInfo()) {
                case Click.Info.Left(int slot) -> new SlotClick(ClickType.LEFT, slot);
                case Click.Info.LeftShift(int slot) -> new SlotClick(ClickType.SHIFT_LEFT, slot);
                case Click.Info.Right(int slot) -> new SlotClick(ClickType.RIGHT, slot);
                case Click.Info.RightShift(int slot) -> new SlotClick(ClickType.SHIFT_LEFT, slot);
                case Click.Info.Middle(int slot) -> new SlotClick(ClickType.MIDDLE, slot);
                case Click.Info.DropSlot(int slot, boolean control) ->
                    new SlotClick(control ? ClickType.CONTROL_DROP : ClickType.DROP, slot);
                case Click.Info.Double(int slot) -> new SlotClick(ClickType.DOUBLE_CLICK, slot);
                case Click.Info.HotbarSwap(int hotbarSlot, int slot) ->
                    new SlotClick(ClickType.NUMBER_KEY, slot);
                default -> null;
              };

          if (slotClick == null) {
            return;
          }

          if (slotClick.rawSlot >= gui.slots().size()) {
            return;
          }

          final Slot slot = gui.slots().get(slotClick.rawSlot);

          gui.slot(slot)
              .ifPresent(
                  (button) ->
                      button
                          .publisher()
                          .click(
                              new MinestomClick(
                                  event.getPlayer(), button, slot, slotClick.type(), vision)));
        });

    guiNode.addListener(
        InventoryCloseEvent.class,
        (event) -> {
          gui.publisher().close(new MinestomClose(event.getPlayer(), gui, vision));
        });

    inventoryNode.addChild(guiNode);

    final Subscriber subscriber =
        new Subscriber() {
          private final Map<Slot, Subscription> subscriptions = new HashMap<>();

          @Override
          public void slot(final Slot slot, final @Nullable Button button) {
            final Subscription subscription = subscriptions.get(slot);
            if (subscription != null) {
              subscription.cancel();
            }

            final int rawSlot = slot.column() + (slot.row() * gui.columns());

            if (button == null) {
              guiInventory.setItemStack(rawSlot, ItemStack.AIR);
              subscriptions.remove(slot);
              return;
            }

            guiInventory.setItemStack(rawSlot, createItemStack(button, locale));

            subscriptions.put(slot, mirror(guiInventory, rawSlot, button, locale));
          }
        };

    synchronized (gui) {
      for (final Slot slot : gui.slots()) {
        gui.slot(slot)
            .ifPresent(
                (button) -> {
                  // Essentially replaying the button sets
                  subscriber.slot(slot, button);
                });
      }

      gui.subscribe(subscriber);
    }

    return guiInventory;
  }

  private ItemStack createItemStack(final Button button, final Locale locale) {
    return ItemStack.builder(convertItemType(button.type()))
        .set(ItemComponent.ITEM_NAME, componentRenderer.render(button.name(), locale))
        .set(
            ItemComponent.LORE,
            button.lore().stream()
                .map((component) -> componentRenderer.render(component, locale))
                .toList())
        .set(ItemComponent.ENCHANTMENT_GLINT_OVERRIDE, button.glow())
        .amount(button.amount())
        .build();
  }

  private Material convertItemType(final ItemType type) {
    final Material material = Material.fromNamespaceId(type.key().toString());

    if (material == null) {
      throw new RuntimeException(); // TODO
    }

    return material;
  }

  private Subscription mirror(
      final Inventory inventory, final int slot, final Button button, final Locale locale) {
    return button.subscribe(
        new Button.Subscriber() {
          @Override
          public void type(final ItemType type) {
            inventory.replaceItemStack(
                slot, (itemStack) -> itemStack.withMaterial(convertItemType(type)));
          }

          @Override
          public void name(final Component name) {
            inventory.replaceItemStack(
                slot,
                (itemStack) ->
                    itemStack.with(
                        ItemComponent.ITEM_NAME, componentRenderer.render(name, locale)));
          }

          @Override
          public void lore(final List<Component> lore) {
            inventory.replaceItemStack(
                slot,
                (itemStack) ->
                    itemStack.with(
                        ItemComponent.LORE,
                        lore.stream()
                            .map((component) -> componentRenderer.render(component, locale))
                            .toList()));
          }

          @Override
          public void amount(final int amount) {
            inventory.replaceItemStack(slot, (itemStack) -> itemStack.withAmount(amount));
          }

          @Override
          public void glow(final boolean glow) {
            inventory.replaceItemStack(
                slot,
                (itemStack) -> itemStack.with(ItemComponent.ENCHANTMENT_GLINT_OVERRIDE, glow));
          }
        });
  }
}

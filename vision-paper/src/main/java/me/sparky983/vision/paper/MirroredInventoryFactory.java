package me.sparky983.vision.paper;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import me.sparky983.vision.Button;
import me.sparky983.vision.Gui;
import me.sparky983.vision.Slot;
import me.sparky983.vision.Subscription;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.GlobalTranslator;
import org.bukkit.Server;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
final class MirroredInventoryFactory {
  private static final String UNABLE_TO_MIRROR_MESSAGE =
      """
            Unable to converter item type "%s". Possible causes:
            - The item is not available in this version of Minecraft
            - Legacy materials are enabled
            """;

  private final Server server;
  private final ItemTypeConverter itemTypeConverter;
  private final ButtonMirror buttonMirror;

  MirroredInventoryFactory(
      final Server server,
      final ItemTypeConverter itemTypeConverter,
      final ButtonMirror buttonMirror) {
    Objects.requireNonNull(server, "server cannot be null");
    Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");
    Objects.requireNonNull(buttonMirror, "buttonMirror cannot be null");

    this.server = server;
    this.itemTypeConverter = itemTypeConverter;
    this.buttonMirror = buttonMirror;
  }

  Inventory mirror(final Gui gui, final Locale locale) {
    Objects.requireNonNull(gui, "gui cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    final Component title = GlobalTranslator.render(gui.title(), locale);

    final Function<InventoryHolder, Inventory> inventoryFactory =
        (inventoryHolder) ->
            switch (gui.type()) {
              case CHEST ->
                  server.createInventory(inventoryHolder, gui.rows() * gui.columns(), title);
              case HOPPER -> server.createInventory(inventoryHolder, InventoryType.HOPPER, title);
              case DROPPER -> server.createInventory(inventoryHolder, InventoryType.DROPPER, title);
            };

    final Inventory inventory = new GuiInventoryHolder(gui, inventoryFactory).getInventory();

    final Gui.Subscriber subscriber =
        new Gui.Subscriber() {
          private final Map<Slot, Subscription> subscriptions = new HashMap<>();

          @Override
          public void slot(final Slot slot, final @Nullable Button button) {
            final Subscription subscription = subscriptions.get(slot);
            if (subscription != null) {
              subscription.cancel();
            }

            final int rawSlot = slot.column() + (slot.row() * gui.columns());
            if (button == null) {
              inventory.setItem(rawSlot, null);
              subscriptions.remove(slot);
              return;
            }
            final ItemStack item =
                itemTypeConverter
                    .convert(button.type())
                    .map(ItemStack::new)
                    .orElseThrow(
                        () ->
                            new IllegalStateException(
                                String.format(UNABLE_TO_MIRROR_MESSAGE, button.type())));
            inventory.setItem(rawSlot, item);

            final ItemStack craftItem = inventory.getItem(rawSlot);
            // We need to get the item from the inventory because the item is cloned
            assert craftItem != null;
            subscriptions.put(slot, buttonMirror.mirror(button, craftItem, locale));
          }
        };

    for (final Slot slot : gui.slots()) {
      gui.slot(slot)
          .ifPresent(
              (button) -> {
                // Essentially replaying the button sets
                subscriber.slot(slot, button);
              });
    }

    gui.subscribe(subscriber);

    return inventory;
  }
}

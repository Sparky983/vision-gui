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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
final class MirroredInventoryFactory {

  private final Server server;
  private final ButtonMirror buttonMirror;

  MirroredInventoryFactory(final Server server, final ButtonMirror buttonMirror) {
    Objects.requireNonNull(server, "server cannot be null");
    Objects.requireNonNull(buttonMirror, "buttonMirror cannot be null");

    this.server = server;
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

            subscriptions.put(slot, buttonMirror.mirror(inventory, rawSlot, button, locale));
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

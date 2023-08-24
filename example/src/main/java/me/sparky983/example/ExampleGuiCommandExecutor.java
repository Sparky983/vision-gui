package me.sparky983.example;

import java.util.concurrent.atomic.AtomicInteger;
import me.sparky983.vision.Button;
import me.sparky983.vision.Gui;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.Slot;
import me.sparky983.vision.paper.PaperVision;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class ExampleGuiCommandExecutor implements CommandExecutor {
  private final PaperVision vision;
  private final Plugin plugin;
  private final BukkitScheduler scheduler;

  public ExampleGuiCommandExecutor(final PaperVision vision, final Plugin plugin,
      final BukkitScheduler scheduler) {
    this.vision = vision;
    this.plugin = plugin;
    this.scheduler = scheduler;
  }

  @Override
  public boolean onCommand(final CommandSender sender,
      final Command command,
      final String label,
      final String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage(Component.text("Only players can use this command"));
      return false;
    }

    final AtomicInteger count = new AtomicInteger(0);

    final Button counter = Button.button()
        .type(ItemType.DIAMOND)
        .onClick((click) -> click.clicker().sendMessage(click.button().name()));

    scheduler.runTaskTimer(plugin, () -> {
      counter.name(Component.text("Counter: " + count.incrementAndGet()));
    }, 20, 10);

    final Gui gui = Gui.chest()
        .title(Component.text("Test GUI"))
        .rows(3)
        .button(Slot.of(1, 4), counter)
        .build();

    vision.open(player, gui);

    return true;
  }
}

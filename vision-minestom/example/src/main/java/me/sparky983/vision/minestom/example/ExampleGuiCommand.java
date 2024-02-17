package me.sparky983.vision.minestom.example;

import java.util.concurrent.atomic.AtomicInteger;
import me.sparky983.vision.Button;
import me.sparky983.vision.Gui;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.Slot;
import me.sparky983.vision.minestom.MinestomVision;
import net.kyori.adventure.text.Component;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;
import net.minestom.server.timer.Scheduler;
import net.minestom.server.timer.TaskSchedule;

public final class ExampleGuiCommand extends Command {
  public ExampleGuiCommand(final MinestomVision vision, final Scheduler scheduler) {
    super("example-gui");

    setDefaultExecutor((sender, context) -> {
      if (!(sender instanceof final Player player)) {
        sender.sendMessage(Component.text("Only players can use this command"));
        return;
      }

      final AtomicInteger count = new AtomicInteger(0);

      final Button counter = Button.of(ItemType.DIAMOND)
          .onClick((click) -> click.clicker().sendMessage(click.button().name()));

      scheduler.scheduleTask(
          () -> {
            counter.name(Component.text("Counter: " + count.incrementAndGet()));
          },
          TaskSchedule.seconds(1),
          TaskSchedule.millis(500));

      final Gui gui = Gui.chest()
          .title(Component.text("Test GUI"))
          .rows(3)
          .slot(Slot.of(1, 4), counter)
          .build();

      vision.open(player, gui);
    });
  }
}

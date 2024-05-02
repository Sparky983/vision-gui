package me.sparky983.vision.examples.minestom;

import me.sparky983.vision.minestom.MinestomVision;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.block.Block;
import net.minestom.server.timer.SchedulerManager;

public final class Example {
  public static void main(final String... args) {
    final MinecraftServer server = MinecraftServer.init();

    final InstanceManager instanceManager = MinecraftServer.getInstanceManager();
    final InstanceContainer instanceContainer = instanceManager.createInstanceContainer();
    instanceContainer.setGenerator(unit -> unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));
    final GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();

    final CommandManager commandManager = MinecraftServer.getCommandManager();
    final MinestomVision vision = MinestomVision.create();
    final SchedulerManager scheduler = MinecraftServer.getSchedulerManager();
    commandManager.register(new ExampleGuiCommand(vision, scheduler));

    globalEventHandler.addListener(
        AsyncPlayerConfigurationEvent.class,
        event -> {
          final Player player = event.getPlayer();
          player.setGameMode(GameMode.CREATIVE);
          event.setSpawningInstance(instanceContainer);
          player.setRespawnPoint(new Pos(0, 42, 0));
        });

    server.start("0.0.0.0", 8113);
  }
}

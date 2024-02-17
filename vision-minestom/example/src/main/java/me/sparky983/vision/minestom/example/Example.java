package me.sparky983.vision.minestom.example;

import me.sparky983.vision.minestom.MinestomVision;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.block.Block;

public final class Example {
  public static void main(final String... args) {
    final MinecraftServer server = MinecraftServer.init();

    final InstanceManager instanceManager = MinecraftServer.getInstanceManager();
    // Create the instance
    final InstanceContainer instanceContainer = instanceManager.createInstanceContainer();
    // Set the ChunkGenerator
    instanceContainer.setGenerator(unit -> unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));
    // Add an event callback to specify the spawning instance (and the spawn position)
    final GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();

    MinecraftServer.getCommandManager()
        .register(
            new ExampleGuiCommand(MinestomVision.create(), MinecraftServer.getSchedulerManager()));

    globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
      final Player player = event.getPlayer();
      event.setSpawningInstance(instanceContainer);
      player.setRespawnPoint(new Pos(0, 42, 0));
    });

    server.start("0.0.0.0", 8113);
  }
}

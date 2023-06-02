package me.sparky983.example;

import me.sparky983.vision.PaperVision;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        final PaperVision vision = PaperVision.create(this);

        final CommandExecutor testGuiCommandExecutor = new ExampleGuiCommandExecutor(vision);

        final PluginCommand testGuiCommand = getCommand("example-gui");
        assert testGuiCommand != null;
        testGuiCommand.setExecutor(testGuiCommandExecutor);
    }
}
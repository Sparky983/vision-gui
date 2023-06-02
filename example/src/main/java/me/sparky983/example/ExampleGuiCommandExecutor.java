package me.sparky983.example;

import me.sparky983.vision.Button;
import me.sparky983.vision.Gui;
import me.sparky983.vision.ItemType;
import me.sparky983.vision.PaperVision;
import me.sparky983.vision.Slot;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class ExampleGuiCommandExecutor implements CommandExecutor {

    private final PaperVision vision;

    public ExampleGuiCommandExecutor(final PaperVision vision) {

        this.vision = vision;
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

        final Gui gui = Gui.gui()
                .title(Component.text("Test GUI"))
                .rows(3)
                .button(Slot.of(1, 4), Button.button()
                        .name(Component.text("DIAMOND")
                                .color(NamedTextColor.AQUA)
                                .decorate(TextDecoration.BOLD))
                        .type(ItemType.DIAMOND));

        vision.open(player, gui);

        return false;
    }
}

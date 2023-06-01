package me.sparky983.vision;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.stream.IntStream;

@NullMarked
final class PaperVisionImpl implements PaperVision {

    private final PaperItemFactory paperButtonMirror;

    PaperVisionImpl(final PaperItemFactory paperButtonMirror) {

        Objects.requireNonNull(paperButtonMirror, "paperButtonMirror cannot be null");

        this.paperButtonMirror = paperButtonMirror;
    }

    @Override
    public void open(final Player player, final Gui gui) {

        Objects.requireNonNull(player, "player cannot be null");
        Objects.requireNonNull(gui, "gui cannot be null");

        final Inventory inventory = Bukkit.createInventory(null, gui.rows() * 9, gui.title());

        IntStream.range(0, gui.rows())
                .forEach((row) -> IntStream.range(0, 9).forEach((column) ->
                        gui.button(Slot.of(column, row)).ifPresent((button) ->
                                inventory.setItem(column + (row * 9), paperButtonMirror.mirror(button)))));

        player.openInventory(inventory);
    }
}

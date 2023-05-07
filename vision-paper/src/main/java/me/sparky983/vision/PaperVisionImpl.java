package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

@NullMarked
final class PaperVisionImpl implements PaperVision {

    private static final Style DEFAULT_STYLE = Style.style()
            .color(NamedTextColor.WHITE)
            .decorations(Set.of(TextDecoration.values()), false)
            .build();

    private final PaperItemTypeConverter itemTypeConverter;

    PaperVisionImpl(final PaperItemTypeConverter itemTypeConverter) {

        Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

        this.itemTypeConverter = itemTypeConverter;
    }

    @Override
    public void open(final Player player, final Gui gui) {

        Objects.requireNonNull(player, "player cannot be null");
        Objects.requireNonNull(gui, "gui cannot be null");

        final Inventory inventory = Bukkit.createInventory(null, gui.rows() * 9, gui.title());

        IntStream.range(0, gui.rows())
                .forEach((row) -> IntStream.range(0, 9).forEach((column) ->
                        gui.button(Slot.of(column, row)).ifPresent((button) -> {
                            final Material material = itemTypeConverter.fromItemType(button.type())
                                    .orElseThrow(() -> new IllegalStateException(
                                            "Unsupported item type: " + button.type()));

                            final ItemStack itemStack = new ItemStack(material, button.amount());
                            itemStack.editMeta((itemMeta) -> {
                                itemMeta.displayName(Component.empty()
                                        .style(DEFAULT_STYLE)
                                        .append(button.name()));
                                itemMeta.lore(button.lore()
                                        .stream()
                                        .<Component>map((line) -> Component.empty()
                                                .style(DEFAULT_STYLE)
                                                .append(line))
                                        .toList());
                            });
                            inventory.setItem(column + (row * 9), itemStack);
                        })));

        player.openInventory(inventory);
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.Set;

/**
 * Creates Paper {@link ItemStack ItemStacks} that mirror {@link Button Buttons} by cloning them.
 * This means changes to the {@link Button} won't be reflected in the {@link ItemStack}.
 */
@NullMarked
final class CloningPaperItemFactory implements PaperItemFactory {

    static final String UNABLE_TO_MIRROR_MESSAGE = """
            Unable to converter item type "%s". Possible causes:
            - Item is not available in this version of Minecraft.
            - Legacy materials are enabled
            """;

    /**
     * Visible for testing.
     */
    static final Style DEFAULT_STYLE = Style.style()
            .color(NamedTextColor.WHITE)
            .decorations(Set.of(TextDecoration.values()), false)
            .build();

    private final PaperItemTypeConverter itemTypeConverter;

    CloningPaperItemFactory(final PaperItemTypeConverter itemTypeConverter) {

        Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

        this.itemTypeConverter = itemTypeConverter;
    }

    @Override
    public ItemStack mirror(final Button button) {

        Objects.requireNonNull(button, "button cannot be null");

        return itemTypeConverter.fromItemType(button.type())
                .map((material) -> {
                    final ItemStack mirror = new ItemStack(material, button.amount());
                    mirror.editMeta((itemMeta) -> {
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
                    return mirror;
                })
                .orElseThrow(() -> new IllegalArgumentException(
                        UNABLE_TO_MIRROR_MESSAGE.formatted(button.type())));
    }
}

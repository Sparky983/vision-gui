package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

/**
 * Creates Paper {@link ItemStack ItemStacks} that mirror {@link Button Buttons} by cloning them.
 * This means changes to the {@link Button} won't be reflected in the {@link ItemStack}.
 */
@NullMarked
final class CloningPaperItemFactory implements PaperItemFactory {

    /**
     * Visible for testing.
     */
    static final String UNABLE_TO_MIRROR_MESSAGE = """
            Unable to converter item type "%s". Possible causes:
            - The item is not available in this version of Minecraft
            - Legacy materials are enabled
            """;

    private final PaperItemTypeConverter itemTypeConverter;

    CloningPaperItemFactory(final PaperItemTypeConverter itemTypeConverter) {

        Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

        this.itemTypeConverter = itemTypeConverter;
    }

    @Override
    public ItemStack create(final Button button) {

        Objects.requireNonNull(button, "button cannot be null");

        return itemTypeConverter.convert(button.type())
                .map((material) -> {
                    final ItemStack item = new ItemStack(material, button.amount());
                    item.editMeta((itemMeta) -> {
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
                    return item;
                })
                .orElseThrow(() -> new IllegalArgumentException(
                        UNABLE_TO_MIRROR_MESSAGE.formatted(button.type())));
    }
}

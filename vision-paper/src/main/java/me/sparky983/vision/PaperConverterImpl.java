package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;
import java.util.Optional;

@NullMarked
final class PaperConverterImpl implements PaperConverter {

    /**
     * The style Vision uses for all items.
     */
    @VisibleForTesting
    static final Style VISION_STYLE = Style.style()
            .color(NamedTextColor.WHITE)
            .decorations(TextDecoration.NAMES.values(), false)
            .build();

    private final PaperItemTypeConverter itemTypeConverter;

    PaperConverterImpl(final PaperItemTypeConverter itemTypeConverter) {

        Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

        this.itemTypeConverter = itemTypeConverter;
    }

    @Override
    public Optional<ItemStack> convert(final Button button) {

        Objects.requireNonNull(button, "button cannot be null");

        return convert(button.type())
                .map((material) -> {
                    final ItemStack item = new ItemStack(material, button.amount());
                    item.editMeta((itemMeta) -> {
                        itemMeta.displayName(convert(button.name()));
                        itemMeta.lore(button.lore()
                                .stream()
                                .map(this::convert)
                                .toList());
                    });
                    return item;
                });
    }

    @Override
    public Component convert(final Component component) {

        Objects.requireNonNull(component, "component cannot be null");

        return Component.text()
                .style(VISION_STYLE)
                .append(component)
                .build();
    }

    @Override
    public Optional<Material> convert(final ItemType itemType) {

        Objects.requireNonNull(itemType, "itemType cannot be null");

        return itemTypeConverter.convert(itemType);
    }
}

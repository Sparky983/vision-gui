package me.sparky983.vision.paper;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.translation.GlobalTranslator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.nullness.NullMarked;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import me.sparky983.vision.Button;
import me.sparky983.vision.ItemType;

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
    public Optional<ItemStack> convert(final Button button, final Locale locale) {

        Objects.requireNonNull(button, "button cannot be null");
        Objects.requireNonNull(locale, "locale cannot be null");

        return convert(button.type())
                .map((material) -> {
                    final ItemStack item = new ItemStack(material, button.amount());
                    item.editMeta((itemMeta) -> {
                        itemMeta.displayName(convert(button.name(), locale));
                        itemMeta.lore(button.lore()
                                .stream()
                                .map((line) -> convert(line, locale))
                                .toList());
                    });
                    return item;
                });
    }

    @Override
    public Component convert(final Component component, final Locale locale) {

        Objects.requireNonNull(component, "component cannot be null");
        Objects.requireNonNull(locale, "locale cannot be null");

        return GlobalTranslator.render(Component.text()
                .style(VISION_STYLE)
                .append(component)
                .build(), locale);
    }

    @Override
    public Optional<Material> convert(final ItemType itemType) {

        Objects.requireNonNull(itemType, "itemType cannot be null");

        return itemTypeConverter.convert(itemType);
    }
}

package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.List;
import java.util.Objects;

@NullMarked
final class SubscribingPaperButtonMirror implements PaperButtonMirror {

    private final PaperItemTypeConverter itemTypeConverter;

    SubscribingPaperButtonMirror(final PaperItemTypeConverter itemTypeConverter) {

        Objects.requireNonNull(itemTypeConverter, "itemTypeConverter cannot be null");

        this.itemTypeConverter = itemTypeConverter;
    }

    @Override
    public void mirror(final Button button, final ItemStack item) {

        Objects.requireNonNull(button, "button cannot be null");
        Objects.requireNonNull(item, "item cannot be null");

        button.subscribe(new Button.Subscriber() {
            @Override
            public void name(final Component name) {

                item.editMeta((meta) -> meta.displayName(Component.empty()
                        .style(PaperItemFactory.DEFAULT_STYLE)
                        .append(name)));
            }

            @Override
            public void lore(final List<Component> lore) {

                item.editMeta((meta) -> meta.lore(lore
                        .stream()
                        .<Component>map((line) -> Component.empty()
                                .style(PaperItemFactory.DEFAULT_STYLE)
                                .append(line))
                        .toList()));
            }

            @Override
            public void amount(final int amount) {

                item.setAmount(amount);
            }

            @Override
            public void type(final ItemType type) {

                itemTypeConverter.fromItemType(type)
                        .ifPresent(item::setType);
            }

            @Override
            public void click(final Click click) {

            }

            @Override
            public void exception(final RuntimeException thrown) {

            }
        });
    }
}

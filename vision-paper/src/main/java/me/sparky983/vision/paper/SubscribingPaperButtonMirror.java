package me.sparky983.vision.paper;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.List;
import java.util.Objects;

import me.sparky983.vision.Button;
import me.sparky983.vision.Click;
import me.sparky983.vision.ItemType;

@NullMarked
final class SubscribingPaperButtonMirror implements PaperButtonMirror {

    private final PaperConverter paperConverter;

    SubscribingPaperButtonMirror(final PaperConverter paperConverter) {

        Objects.requireNonNull(paperConverter, "paperConverter cannot be null");

        this.paperConverter = paperConverter;
    }

    @Override
    public void mirror(final Button button, final ItemStack item) {

        Objects.requireNonNull(button, "button cannot be null");
        Objects.requireNonNull(item, "item cannot be null");

        button.subscribe(new Button.Subscriber() {
            @Override
            public void name(final Component name) {

                item.editMeta((meta) ->
                        meta.displayName(paperConverter.convert(name))
                );
            }

            @Override
            public void lore(final List<Component> lore) {

                item.editMeta((meta) -> meta.lore(lore
                        .stream()
                        .map(paperConverter::convert)
                        .toList()));
            }

            @Override
            public void amount(final int amount) {

                item.setAmount(amount);
            }

            @Override
            public void type(final ItemType type) {

                paperConverter.convert(type).ifPresent(item::setType);
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

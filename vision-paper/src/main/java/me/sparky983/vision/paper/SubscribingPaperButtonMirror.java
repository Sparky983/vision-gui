package me.sparky983.vision.paper;

import net.kyori.adventure.text.Component;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jspecify.nullness.NullMarked;

import java.util.List;
import java.util.Locale;
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
    public void mirror(final Button button, final ItemStack item, final Locale locale) {

        Objects.requireNonNull(button, "button cannot be null");
        Objects.requireNonNull(item, "item cannot be null");
        Objects.requireNonNull(locale, "locale cannot be null");

        item.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        final Button.Subscriber subscriber = new Button.Subscriber() {
            @Override
            public void name(final Component name) {

                item.editMeta((meta) ->
                        meta.displayName(paperConverter.convert(name, locale))
                );
            }

            @Override
            public void lore(final List<Component> lore) {

                item.editMeta((meta) -> meta.lore(lore
                        .stream()
                        .map((line) -> paperConverter.convert(line, locale))
                        .toList()));
            }

            @Override
            public void amount(final int amount) {

                item.setAmount(amount);
            }

            @Override
            public void glow(final boolean glow) {

                if (glow) {
                    item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                } else {
                    item.removeEnchantment(Enchantment.DURABILITY);
                }
            }

            @Override
            public void type(final ItemType type) {

                paperConverter.convert(type).ifPresent(item::setType);
            }
        };

        // Essentially replay the button's state to the subscriber
        // Ensures that the ItemStack and Button are consistent
        subscriber.name(button.name());
        subscriber.lore(button.lore());
        subscriber.amount(button.amount());
        subscriber.glow(button.glow());
        subscriber.type(button.type());

        button.subscribe(subscriber);
    }
}

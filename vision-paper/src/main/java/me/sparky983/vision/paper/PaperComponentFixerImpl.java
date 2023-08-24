package me.sparky983.vision.paper;

import java.util.Locale;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.translation.GlobalTranslator;
import org.jetbrains.annotations.VisibleForTesting;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class PaperComponentFixerImpl implements PaperComponentFixer {
  /**
   * The style Vision uses for all items.
   */
  @VisibleForTesting
  static final Style VISION_STYLE = Style.style()
      .color(NamedTextColor.WHITE)
      .decorations(TextDecoration.NAMES.values(), false)
      .build();

  @Override
  public Component convert(final Component component, final Locale locale) {
    Objects.requireNonNull(component, "component cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    return Component.text()
        .style(VISION_STYLE)
        .append(GlobalTranslator.render(component, locale))
        .build();
  }
}

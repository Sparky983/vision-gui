package me.sparky983.vision.minestom;

import java.util.Locale;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.renderer.ComponentRenderer;
import net.kyori.adventure.translation.GlobalTranslator;
import org.jspecify.annotations.NullMarked;

/**
 * Removes the style from a {@link Component} and translates it.
 */
@NullMarked
final class MinestomComponentRenderer implements ComponentRenderer<Locale> {
  static final Style VISION_STYLE = Style.style()
      .color(NamedTextColor.WHITE)
      .decorations(TextDecoration.NAMES.values(), false)
      .build();

  /**
   * Fixes the given {@link Component}.
   *
   * @param component the component to be converted
   * @param locale the locale to render {@link Component Components} with
   * @return the fixed component
   * @throws NullPointerException if the component or the locale is {@code null}.
   */
  @Override
  public Component render(final Component component, final Locale locale) {
    Objects.requireNonNull(component, "component cannot be null");
    Objects.requireNonNull(locale, "locale cannot be null");

    return Component.text()
        .style(VISION_STYLE)
        .append(GlobalTranslator.render(component, locale))
        .build();
  }
}

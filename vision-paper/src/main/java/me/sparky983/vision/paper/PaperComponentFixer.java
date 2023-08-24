package me.sparky983.vision.paper;

import java.util.Locale;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;

/**
 * Removes the style from a {@link Component} and translates it.
 */
@NullMarked
interface PaperComponentFixer {
  /**
   * Fixes the given {@link Component}.
   *
   * @param component the component to be converted
   * @param locale the locale to render {@link Component Components} with
   * @return the fixed component
   * @throws NullPointerException if the component or the locale is {@code null}.
   */
  Component convert(Component component, Locale locale);
}

package me.sparky983.vision

import net.kyori.adventure.text.Component

/**
 * The title of this [Gui].
 *
 * If this [Gui] is untitled, the title will match Minecraft's default container title which is
 * usually a translatable [Component] of the form "container.<container>".
 *
 * @see Gui.title
 * @since 0.2
 */
public val Gui.title: Component
    get() = title()

/**
 * The amount of rows in this [Gui].
 *
 * @see Gui.rows
 * @since 0.2
 */
public val Gui.rows: Int
    get() = rows()

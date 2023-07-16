package me.sparky983.vision

import net.kyori.adventure.audience.Audience

/**
 * The [Audience] who clicked the [Button].
 *
 * @see Click.clicker
 * @since 1.0
 */
public val Click.clicker: Audience
    get() = clicker()

/**
 * The [Button] that was clicked.
 *
 * @see Click.button
 * @since 1.0
 */
public val Click.button: Button
    get() = button()

/**
 * The [Slot] that was clicked.
 *
 * @see Click.slot
 * @since 1.0
 */
public val Click.slot: Slot
    get() = slot()

/**
 * The [type][ClickType] of this click.
 *
 * @see Click.type
 * @since 1.0
 */
public val Click.type: ClickType
    get() = type()

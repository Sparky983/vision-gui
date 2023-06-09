package me.sparky983.vision

import net.kyori.adventure.text.Component

/**
 * The type of this [Button].
 *
 * @see Button.type
 * @since 0.2
 */
public var Button.type: ItemType
    get() = type()
    set(type) { type(type) }

/**
 * The name of this [Button].
 *
 * If this [Button] is untitled, the name will match Minecraft's default item name which is usually
 * a translatable component of the form "item.minecraft.<item_id>" or "block.minecraft.<item_id>".
 *
 * @see Button.name
 * @since 0.2
 */
public var Button.name: Component
    get() = name()
    set(name) { name(name) }

/**
 * The lore of this [Button].
 *
 * If this [Button] is lore-less, the lore will be empty.
 *
 * Changes to the set lore will not be reflected in the returned list.
 *
 * @see Button.lore
 * @since 0.2
 */
public var Button.lore: List<Component>
    get() = lore()
    set(lore) { lore(lore) }

/**
 * The amount items in this [Button].
 *
 * @see Button.amount
 * @since 0.2
 */
public var Button.amount: Int
    get() = amount()
    set(amount) { amount(amount) }

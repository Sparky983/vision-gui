package me.sparky983.vision

import net.kyori.adventure.text.Component

public var Button.name: Component
    get() = name()
    set(name) { name(name) }

public var Button.lore: List<Component>
    get() = lore()
    set(lore) { lore(lore) }

public var Button.amount: Int
    get() = amount()
    set(amount) { amount(amount) }

public var Button.type: ItemType
    get() = type()
    set(type) { type(type) }

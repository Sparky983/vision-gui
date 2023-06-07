package me.sparky983.vision

import net.kyori.adventure.text.Component

public inline fun gui(title: Component?, rows: Int, init: Gui.() -> Unit): Gui {
    return Gui.gui(title, rows).apply(init)
}

public inline fun gui(rows: Int, init: Gui.() -> Unit): Gui {
    return gui(title = null, rows, init)
}

public inline fun Gui.button(slot: Slot, type: ItemType, init: Button.() -> Unit): Button {
    return Button.of(type).apply(init).apply { button(slot, this) }
}

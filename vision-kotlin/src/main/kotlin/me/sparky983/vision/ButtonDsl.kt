package me.sparky983.vision

public inline fun button(type: ItemType, init: Button.() -> Unit): Button {
    return Button.of(type).apply(init)
}

public inline fun button(type: ItemType): Button {
    return Button.of(type)
}

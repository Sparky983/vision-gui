package me.sparky983.vision

import net.kyori.adventure.text.Component
import java.lang.IllegalStateException

@DslMarker
private annotation class GuiDslMarker

@GuiDslMarker
public interface GuiDsl {
    public var title: Component?
    public var rows: Int

    public fun button(slot: Slot, button: Button)

    public fun button(slot: Slot): Button?
}

private class GuiDslImpl : GuiDsl {
    public override var title: Component? = null
    public override var rows: Int = 1

    private val buttons: MutableMap<Slot, Button> = hashMapOf()

    public override fun button(slot: Slot, button: Button) {
        buttons[slot] = button
    }

    public override fun button(slot: Slot): Button? {
        return buttons[slot]
    }

    @PublishedApi
    internal fun build(): Gui {
        val gui = Gui.gui(title, rows)

        buttons.forEach(gui::button)

        return gui
    }
}

public fun gui(init: GuiDsl.() -> Unit): Gui {
    return GuiDslImpl().apply(init).build()
}

@GuiDslMarker
public interface ButtonDsl {
    public var type: ItemType?
    public var name: Component?
    public var lore: List<Component>
    public var amount: Int

    public fun onClick(handler: (Click) -> Unit)
}

private class ButtonDslImpl : ButtonDsl {
    public override var type: ItemType? = null
    public override var name: Component? = null
    public override var lore: List<Component> = listOf()
    public override var amount: Int = 1

    private val clickHandlers: MutableList<(Click) -> Unit> = mutableListOf()

    public override fun onClick(handler: (Click) -> Unit) {
        clickHandlers.add(handler)
    }

    internal fun build(): Button {
        val type = type ?:
            throw IllegalStateException("type property must be specified and non-null")

        val button = Button.of(type)
            .name(name)
            .lore(lore)
            .amount(amount)

        clickHandlers.forEach(button::onClick)

        return button
    }
}

public fun button(init: ButtonDsl.() -> Unit): Button {
    return ButtonDslImpl().apply(init).build()
}

public fun GuiDsl.button(slot: Slot, init: ButtonDsl.() -> Unit) {
    button(slot, button(init))
}

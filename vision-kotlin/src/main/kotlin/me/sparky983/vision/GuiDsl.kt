package me.sparky983.vision

import net.kyori.adventure.text.Component
import java.lang.IllegalStateException

/**
 * The DSL marker for the [Gui] DSL.
 */
@DslMarker
private annotation class GuiDslMarker

/**
 * The [Gui] DSL receiver.
 *
 * @see gui
 * @since 0.2
 */
@GuiDslMarker
public interface GuiDsl {
    /**
     * The title of the [Gui].
     *
     * @since 0.2
     */
    public var title: Component?

    /**
     * The amount of rows in the [Gui].
     *
     * @since 0.2
     */
    public var rows: Int

    /**
     * Sets the value of the [slot] the the [Button] in the [Gui].
     *
     * @param slot the slot
     * @param button the [Button]
     * @see Gui.button
     * @since 0.2
     */
    public fun button(slot: Slot, button: Button?)

    /**
     * Gets the [Button] in the [Gui] at the [slot].
     *
     * @param slot the slot
     * @return the [Button] or `null` if there is no [Button] at the [slot]
     * @see Gui.button
     * @since 0.2
     */
    public fun button(slot: Slot): Button?
}

/**
 * The implementation of the [GuiDsl] used by [gui].
 *
 * @see gui
 */
private class GuiDslImpl : GuiDsl {
    public override var title: Component? = null
    public override var rows: Int = 1

    private val buttons: MutableMap<Slot, Button?> = hashMapOf()

    public override fun button(slot: Slot, button: Button?) {
        buttons[slot] = button
    }

    public override fun button(slot: Slot): Button? {
        return buttons[slot]
    }

    internal fun build(): Gui {
        val gui = Gui.gui(title, rows)

        buttons.forEach(gui::button)

        return gui
    }
}

/**
 * Creates a new [Gui] using the [GuiDsl].
 *
 * @param init the initializer block
 * @return the created [Gui]
 * @since 0.2
 */
public fun gui(init: GuiDsl.() -> Unit): Gui {
    return GuiDslImpl().apply(init).build()
}

/**
 * The [Button] DSL receiver.
 *
 * @see button
 * @since 0.2
 */
@GuiDslMarker
public interface ButtonDsl {

    /**
     * The type of the [Button]
     *
     * @see Button.type
     * @since 0.2
     */
    public var type: ItemType?

    /**
     * The name of the [Button].
     *
     * If the [Button] is untitled, the name will match Minecraft's default item name which is
     * usually a translatable component of the form "item.minecraft.<item_id>" or
     * "block.minecraft.<item_id>".
     *
     * @see Button.name
     * @since 0.2
     */
    public var name: Component?

    /**
     * The lore of the [Button].
     *
     * If the [Button] is lore-less, the lore will be empty.
     *
     * Changes to the set lore will not be reflected in the returned list.
     *
     * @see Button.lore
     * @since 0.2
     */
    public var lore: List<Component>

    /**
     * The amount items in the [Button].
     *
     * @see Button.amount
     * @since 0.2
     */
    public var amount: Int

    /**
     * Adds a click handler to the [Button].
     *
     * @param handler the click handler
     * @see Button.onClick
     * @since 0.2
     */
    public fun onClick(handler: (Click) -> Unit)
}

/**
 * The implementation of the [ButtonDsl] used by [button].
 *
 * @see button
 */
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

/**
 * Creates a new [Button] using the [ButtonDsl].
 *
 * @param init the initializer block
 * @return the created [Button]
 * @since 0.2
 */
public fun button(init: ButtonDsl.() -> Unit): Button {
    return ButtonDslImpl().apply(init).build()
}

/**
 * Adds a [Button] to the [Gui] using the [ButtonDsl].
 *
 * @param slot the slot of the [Button]
 * @param init the initializer block
 * @since 0.2
 */
public fun GuiDsl.button(slot: Slot, init: ButtonDsl.() -> Unit) {
    button(slot, button(init))
}

package me.sparky983.vision

import net.kyori.adventure.text.Component

/**
 * The DSL marker for the [Gui] DSL.
 */
@DslMarker
private annotation class GuiDslMarker

/**
 * The [Gui] DSL receiver.
 *
 * @see chest
 * @see hopper
 * @see dropper
 * @since 1.0
 */
@GuiDslMarker
public sealed interface GuiDsl {
    /**
     * The title of the [Gui].
     *
     * If unspecified, the value is `null`.
     *
     * @see Gui.title
     * @since 1.0
     */
    public var title: Component?

    /**
     * Adds a button to the [Gui].
     *
     * @param slot the slot of the button
     * @param button the button
     * @see Gui.button
     * @since 1.0
     */
    public fun button(slot: Slot, button: Button)
}

/**
 * The [Chest] DSL receiver.
 *
 * @see chest
 * @since 1.0
 */
public interface ChestDsl : GuiDsl {
    /**
     * The number of rows in the [Chest].
     *
     * If unspecified, the value is `1`.
     *
     * @see Chest.rows
     * @since 1.0
     */
    public var rows: Int
}

/**
 * The [Hopper] DSL receiver.
 *
 * @see hopper
 * @since 1.0
 */
public interface HopperDsl : GuiDsl

/**
 * The [Dropper] DSL receiver.
 *
 * @see dropper
 * @since 1.0
 */
public interface DropperDsl : GuiDsl

/**
 * The implementation of the [ChestDsl] used by [chest].
 *
 * @see chest
 */
private class ChestDslImpl : ChestDsl {
    public override var title: Component? = null
    public override var rows: Int = 1
    private val buttons: MutableMap<Slot, Button> = hashMapOf()

    public override fun button(slot: Slot, button: Button) {
        buttons[slot] = button
    }

    internal fun build(): Chest =
        Gui.chest()
            .apply { title?.let(this::title) }
            .rows(rows)
            .apply { buttons.forEach(this::button) }
            .build()
}

/**
 * The implementation of the [HopperDsl] used by [hopper].
 *
 * @see hopper
 */
private class HopperDslImpl : HopperDsl {
    public override var title: Component? = null
    private val buttons: MutableMap<Slot, Button> = hashMapOf()

    public override fun button(slot: Slot, button: Button) {
        buttons[slot] = button
    }

    internal fun build(): Hopper =
        Gui.hopper()
            .apply { title?.let(this::title) }
            .apply { buttons.forEach(this::button) }
            .build()
}

/**
 * The implementation of the [DropperDsl] used by [dropper].
 *
 * @see dropper
 */
private class DropperDslImpl : DropperDsl {
    public override var title: Component? = null
    private val buttons: MutableMap<Slot, Button> = hashMapOf()

    public override fun button(slot: Slot, button: Button) {
        buttons[slot] = button
    }

    internal fun build(): Dropper =
        Gui.dropper()
            .apply { title?.let(this::title) }
            .apply { buttons.forEach(this::button) }
            .build()
}

/**
 * Builds a [Chest] using the [ChestDsl].
 *
 * @param init the initializer block
 * @return the created [Chest]
 * @since 1.0
 */
public fun chest(init: ChestDsl.() -> Unit): Chest = ChestDslImpl().apply(init).build()

/**
 * Builds a [Hopper] using the [HopperDsl].
 *
 * @param init the initializer block
 * @return the created [Hopper]
 * @since 1.0
 */
public fun hopper(init: HopperDsl.() -> Unit): Hopper = HopperDslImpl().apply(init).build()

/**
 * Builds a [Dropper] using the [DropperDsl].
 *
 * @param init the initializer block
 * @return the created [Dropper]
 * @since 1.0
 */
public fun dropper(init: DropperDsl.() -> Unit): Dropper = DropperDslImpl().apply(init).build()

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
     * If unspecified, the value is `null`.
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
    private var _lore: List<Component> = listOf()
    public override var lore: List<Component>
        get() = _lore
        set(lore) { _lore = lore.toList() }
    public override var amount: Int = 1

    private val clickHandlers: MutableList<(Click) -> Unit> = mutableListOf()

    public override fun onClick(handler: (Click) -> Unit) {
        clickHandlers.add(handler)
    }

    internal fun build(): Button {
        val type =
            type ?: throw IllegalStateException("type property must be specified and non-null")

        val button = Button.of(type)
            .name(name)
            .lore(lore)
            .amount(amount)

        clickHandlers.forEach(button::onClick)

        return button
    }
}

/**
 * Builds a [Button] by applying the [init] block to a new [ButtonDsl].
 *
 * @param init the initializer block
 * @return the created [Button]
 * @since 0.2
 */
public fun button(init: ButtonDsl.() -> Unit): Button = ButtonDslImpl().apply(init).build()

/**
 * Adds a [Button] to the [Gui] using the [ButtonDsl].
 *
 * @param slot the slot of the [Button]
 * @param init the initializer block
 * @return the created [Button]
 * @throws IllegalStateException if the [type] was not set in the initializer block.
 * @since 1.0
 */
public fun Gui.button(slot: Slot, init: ButtonDsl.() -> Unit): Button =
    button(init).also { button(slot, it) }

/**
 * Adds a [Button] to the [Gui.Builder] using the [ButtonDsl].
 *
 * @param slot the slot of the [Button]
 * @param init the initializer block
 * @return the created [Button]
 * @throws IllegalStateException if the [type] was not set in the initializer block.
 * @since 1.0
 */
public fun Gui.Builder.button(slot: Slot, init: ButtonDsl.() -> Unit): Button =
    button(init).also { button(slot, it) }

/**
 * Adds a [Button] to the [GuiDsl] using the [ButtonDsl].
 *
 * @param slot the slot of the [Button]
 * @param init the initializer block
 * @return the created [Button]
 * @throws IllegalStateException if the [type] was not set in the initializer block.
 * @since 1.0
 */
public fun GuiDsl.button(slot: Slot, init: ButtonDsl.() -> Unit): Button =
    button(init).also { button(slot, it) }

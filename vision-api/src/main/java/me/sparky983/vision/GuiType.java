package me.sparky983.vision;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents a type of {@link Gui}.
 * <p>
 * Contains information about the size and shape of a {@link Gui}.
 *
 * @see Gui
 * @see me.sparky983.vision.Chest
 * @see me.sparky983.vision.Hopper
 * @see me.sparky983.vision.Dropper
 * @since 1.0
 */
public sealed interface GuiType permits GuiType.Chest, GuiType.Hopper, GuiType.Dropper {

    /**
     * Gets the number of columns {@link Gui Guis} of this type have.
     * <p>
     * The following table shows the number of columns for each {@link GuiType}:
     * <table>
     *     <caption>Number of columns</caption>
     *     <tr>
     *         <th>Type</th>
     *         <th>Columns</th>
     *     </tr>
     *     <tr>
     *         <td>{@link GuiType.Chest}</td>
     *         <td>9</td>
     *     </tr>
     *     <tr>
     *         <td>{@link GuiType.Hopper}</td>
     *         <td>5</td>
     *     </tr>
     *     <tr>
     *         <td>{@link GuiType.Dropper}</td>
     *         <td>3</td>
     *     </tr>
     * </table>
     *
     * @return the number of columns
     * @see Gui#columns()
     * @since 1.0
     */
    int columns();

    /**
     * Gets the number of rows {@link Gui Guis} of this type have.
     * <p>
     * The following table shows the number of rows for each {@link GuiType}:
     * <table>
     *     <caption>Number of rows</caption>
     *     <tr>
     *         <th>Type</th>
     *         <th>Rows</th>
     *     </tr>
     *     <tr>
     *         <td>{@link GuiType.Chest}</td>
     *         <td>1-6</td>
     *     </tr>
     *     <tr>
     *         <td>{@link GuiType.Hopper}</td>
     *         <td>1</td>
     *     </tr>
     *     <tr>
     *         <td>{@link GuiType.Dropper}</td>
     *         <td>3</td>
     *     </tr>
     * </table>
     *
     * @return the number of rows
     * @see Gui#rows()
     * @since 1.0
     */
    int rows();

    /**
     * Checks whether the specified slot would fit in a {@link Gui} of this type.
     *
     * @param slot the slot
     * @return whether the slot would fit in a {@link Gui} of this type
     * @throws NullPointerException if the slot is {@code null}.
     * @since 1.0
     * @vision.experimental because this may be renamed or removed.
     */
    @ApiStatus.Experimental
    boolean allowsSlot(Slot slot);

    /**
     * Gets the name of this type.
     *
     * @return the name of this type
     * @since 1.0
     * @vision.experimental because this may be renamed.
     */
    @ApiStatus.Experimental
    Component name();

    /**
     * The {@link me.sparky983.vision.Chest} type.
     *
     * @see me.sparky983.vision.Chest
     * @since 1.0
     */
    non-sealed interface Chest extends GuiType {

        /**
         * The name of this type.
         *
         * @since 1.0
         * @vision.experimental because this may be renamed or removed.
         */
        @ApiStatus.Experimental
        Component NAME = Component.translatable("container.chest");

        /**
         * The number of columns {@link me.sparky983.vision.Chest Gui.Chests} have.
         *
         * @see Gui#columns()
         * @since 1.0
         */
        int COLUMNS = 9;

        /**
         * The minimum number of rows that a {@link me.sparky983.vision.Chest} can have.
         *
         * @see Gui#rows()
         * @since 1.0
         * @vision.experimental because this may be deleted, renamed or moved.
         */
        @ApiStatus.Experimental
        int MIN_ROWS = 1;

        /**
         * The maximum number of rows that a {@link me.sparky983.vision.Chest} can have.
         *
         * @see Gui#rows()
         * @since 1.0
         * @vision.experimental because this may be renamed or moved.
         */
        @ApiStatus.Experimental
        int MAX_ROWS = 6;
    }

    /**
     * The {@link me.sparky983.vision.Hopper} type.
     *
     * @see me.sparky983.vision.Hopper
     * @since 1.0
     */
    non-sealed interface Hopper extends GuiType {

        /**
         * The name of this type.
         *
         * @since 1.0
         * @vision.experimental because this may be renamed or removed.
         */
        @ApiStatus.Experimental
        Component NAME = Component.translatable("container.hopper");

        /**
         * The number of columns {@link me.sparky983.vision.Hopper Gui.Hoppers} have.
         *
         * @see Gui#columns()
         * @since 1.0
         */
        int COLUMNS = 5;

        /**
         * The number of rows {@link me.sparky983.vision.Hopper Gui.Hoppers} have.
         *
         * @see Gui#rows()
         * @since 1.0
         */
        int ROWS = 1;
    }

    /**
     * The {@link me.sparky983.vision.Dropper} type.
     *
     * @see me.sparky983.vision.Dropper
     * @since 1.0
     */
    non-sealed interface Dropper extends GuiType {

        /**
         * The name of this type.
         *
         * @since 1.0
         * @vision.experimental because this may be renamed or removed.
         */
        @ApiStatus.Experimental
        Component NAME = Component.translatable("container.dropper");

        /**
         * The number of columns {@link me.sparky983.vision.Dropper Gui.Droppers} have.
         *
         * @see Gui#columns()
         * @since 1.0
         */
        int COLUMNS = 3;

        /**
         * The number of rows {@link me.sparky983.vision.Dropper Gui.Droppers} have.
         *
         * @see Gui#rows()
         * @since 1.0
         */
        int ROWS = 3;
    }
}

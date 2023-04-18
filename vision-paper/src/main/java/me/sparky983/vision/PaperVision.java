package me.sparky983.vision;

import org.bukkit.entity.Player;
import org.jspecify.nullness.NullMarked;
import sun.misc.Unsafe;

/**
 * The paper gui manager.
 *
 * @since 0.1
 */
@NullMarked
public interface PaperVision extends Vision {

    /**
     * Creates a new paper gui manager.
     *
     * @return the newly created paper gui manager
     * @since 0.1
     */
    static PaperVision create() {
        
        return null;
    }

    /**
     * Opens the specified GUI for the specified player.
     *
     * @param player the player
     * @param gui the GUI
     * @since 0.1
     */
    void open(Player player, Gui gui);
}

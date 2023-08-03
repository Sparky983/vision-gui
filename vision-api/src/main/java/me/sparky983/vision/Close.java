package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;

/**
 * Represents the closing of a {@link Gui}.
 *
 * @see Gui.Publisher#close(Close)
 * @since 1.1
 */
public interface Close {

    /**
     * Returns the {@link Audience} who closed the {@link Gui}.
     *
     * @return the {@link Audience} who closed the {@link Gui}.
     * @since 1.1
     */
    Audience closer();

    /**
     * Returns the {@link Gui} that was closed.
     *
     * @return the {@link Gui} that was closed.
     * @since 1.1
     */
    Gui gui();

    /**
     * Cancels the closing of the {@link Gui}.
     *
     * @vision.apiNote This method cannot be undone, nor can the cancellation state be queried. This
     * is to ensure isolation between subscribers. This may change in the future.
     * @since 1.1
     */
    void cancel();
}

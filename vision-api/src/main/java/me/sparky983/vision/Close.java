package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.ApiStatus;

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
     * Opens the specified {@link Gui} for the clicker.
     *
     * @param gui the {@link Gui} to open
     * @throws NullPointerException if the {@link Gui} is {@code null}.
     * @since 1.1
     * @vision.experimental because this may be removed or renamed.
     */
    @ApiStatus.Experimental
    void open(Gui gui);

    /**
     * Returns the {@link Gui} that was closed.
     *
     * @return the {@link Gui} that was closed.
     * @since 1.1
     */
    Gui gui();
}

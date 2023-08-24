package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

/**
 * Represents the clicking of a {@link Button}.
 *
 * @see Button.Publisher#click(Click)
 */
@NullMarked
public interface Click {
    /**
     * Returns the {@link Audience} who clicked the {@link Button}.
     *
     * @return the {@link Audience} who clicked the {@link Button}
     * @since 0.1
     */
    Audience clicker();

    /**
     * Opens the specified {@link Gui} for the clicker.
     *
     * @param gui the {@link Gui} to open
     * @throws NullPointerException if the {@link Gui} is {@code null}.
     * @since 1.0
     * @vision.experimental because this may be removed or renamed.
     */
    @ApiStatus.Experimental
    void open(Gui gui);

    /**
     * Returns the {@link Button} that was clicked.
     *
     * @return the {@link Button} that was clicked
     * @since 0.1
     */
    Button button();

    /**
     * Returns the {@link Slot} that was clicked.
     *
     * @return the {@link Slot} that was clicked
     * @since 0.1
     */
    Slot slot();

    /**
     * Returns the {@link ClickType} of this click.
     *
     * @return the {@link ClickType} of this click
     * @since 0.1
     */
    ClickType type();
}

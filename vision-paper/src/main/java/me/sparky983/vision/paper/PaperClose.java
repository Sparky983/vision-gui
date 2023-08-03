package me.sparky983.vision.paper;

import me.sparky983.vision.Close;
import me.sparky983.vision.Gui;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.Objects;

/**
 * The paper implementation of {@link Close}.
 *
 * @param closer the closer
 * @param gui the {@link Gui} that was closed
 */
@NullMarked
record PaperClose(@Override Player closer, @Override Gui gui, PaperVision vision) implements Close {

    /**
     * Creates a new {@code PaperClose}.
     *
     * @param closer the closer
     * @param gui the {@link Gui} that was closed
     * @throws NullPointerException if the closer or the GUI is {@code null}.
     */
    PaperClose {

        Objects.requireNonNull(closer, "closer cannot be null");
        Objects.requireNonNull(gui, "gui cannot be null");
    }

    @Override
    public void open(final Gui gui) {

        vision.open(closer, gui);
    }
}

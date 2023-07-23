package me.sparky983.vision.paper;

import me.sparky983.vision.Button;
import me.sparky983.vision.Click;
import me.sparky983.vision.ClickType;
import me.sparky983.vision.Gui;
import me.sparky983.vision.Slot;
import net.kyori.adventure.audience.Audience;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.Objects;

/**
 * The paper implementation of {@link Click}.
 */
@NullMarked
final class PaperClick implements Click {

    private final Player clicker;
    private final Button button;
    private final Slot slot;
    private final ClickType type;
    private final PaperVision vision;

    /**
     * Creates a new {@code PaperClick}.
     *
     * @param clicker the audience who clicked the {@link Button}
     * @param button the {@link Button} that was clicked
     * @param slot the {@link Slot} that was clicked
     * @param type the type of this click
     * @param vision the vision
     * @throws NullPointerException if the clicker, button, slot or type is {@code null}.
     */
    PaperClick(final Player clicker,
               final Button button,
               final Slot slot,
               final ClickType type,
               final PaperVision vision) {

        Objects.requireNonNull(clicker, "clicker cannot be null");
        Objects.requireNonNull(button, "button cannot be null");
        Objects.requireNonNull(slot, "slot cannot be null");
        Objects.requireNonNull(type, "type cannot be null");
        Objects.requireNonNull(vision, "vision cannot be null");

        this.clicker = clicker;
        this.button = button;
        this.slot = slot;
        this.type = type;
        this.vision = vision;
    }

    @Override
    public Audience clicker() {

        return clicker;
    }

    @Override
    public void open(final Gui gui) {

        Objects.requireNonNull(gui, "gui cannot be null");

        vision.open(clicker, gui);
    }

    @Override
    public Button button() {

        return button;
    }

    @Override
    public Slot slot() {

        return slot;
    }

    @Override
    public ClickType type() {

        return type;
    }
}

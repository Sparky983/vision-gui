package me.sparky983.vision;

import net.kyori.adventure.audience.Audience;
import org.jspecify.nullness.NullMarked;

import java.util.Objects;

/**
 * The default implementation of {@link Click}.
 */
@NullMarked
record ClickImpl(@Override Audience clicker,
                 @Override Button button,
                 @Override Slot slot,
                 @Override Type type) implements Click {

    /**
     * Creates a new {@code ClickImpl}.
     *
     * @param clicker the audience who clicked the {@link Button}
     * @param button the {@link Button} that was clicked
     * @param slot the {@link Slot} that was clicked
     * @param type the type of this click
     * @throws NullPointerException if the clicker, button, slot or type is {@code null}.
     */
    ClickImpl {

        Objects.requireNonNull(clicker, "clicker cannot be null");
        Objects.requireNonNull(button, "button cannot be null");
        Objects.requireNonNull(slot, "slot cannot be null");
        Objects.requireNonNull(type, "type cannot be null");
    }
}

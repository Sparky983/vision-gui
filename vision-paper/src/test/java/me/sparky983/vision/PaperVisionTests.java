package me.sparky983.vision;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class PaperVisionTests {

    Plugin plugin;
    PaperVision paperVision;

    @BeforeEach
    void setUp() {

        plugin = mock(Answers.RETURNS_MOCKS);
        paperVision = PaperVision.create(plugin);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testCreateWhenPluginIsNull() {

        final Exception e =
                assertThrows(NullPointerException.class, () -> PaperVision.create(null));
        assertEquals("plugin cannot be null", e.getMessage());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testOpenWhenPlayerIsNull() {

        final Exception e =
                assertThrows(NullPointerException.class, () -> paperVision.open(null, Gui.chest().build()));
        assertEquals("player cannot be null", e.getMessage());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testOpenWhenGuiIsNull() {

        final Player player = mock();

        final Exception e =
                assertThrows(NullPointerException.class, () -> paperVision.open(player, null));
        assertEquals("gui cannot be null", e.getMessage());
    }
}

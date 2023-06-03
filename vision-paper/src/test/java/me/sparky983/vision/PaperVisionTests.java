package me.sparky983.vision;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaperVisionTests {

    Plugin plugin;
    Server server;
    PluginManager pluginManager;
    PaperVision paperVision;

    @BeforeEach
    void setUp() {

        plugin = mock();
        server = mock();
        pluginManager = mock();
        when(server.getPluginManager()).thenReturn(pluginManager);
        when(plugin.getServer()).thenReturn(server);
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
                assertThrows(NullPointerException.class, () -> paperVision.open(null, Gui.gui(1)));
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

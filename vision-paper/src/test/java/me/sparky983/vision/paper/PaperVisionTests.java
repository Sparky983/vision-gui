package me.sparky983.vision.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import me.sparky983.vision.Chest;
import me.sparky983.vision.Gui;
import me.sparky983.vision.GuiLike;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

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
    final Exception e = assertThrows(NullPointerException.class, () -> PaperVision.create(null));
    assertEquals("plugin cannot be null", e.getMessage());
  }

  @SuppressWarnings("ConstantConditions")
  @Test
  void testOpenGuiWhenPlayerIsNull() {
    final Gui gui = Gui.chest().build();

    final Exception e = assertThrows(NullPointerException.class, () -> paperVision.open(null, gui));
    assertEquals("player cannot be null", e.getMessage());
  }

  @SuppressWarnings("ConstantConditions")
  @Test
  void testOpenGuiWhenGuiIsNull() {
    final Player player = mock();

    final Exception e =
        assertThrows(NullPointerException.class, () -> paperVision.open(player, (Gui) null));
    assertEquals("gui cannot be null", e.getMessage());
  }

  @SuppressWarnings("ConstantConditions")
  @Test
  void testOpenGuiLikeWhenPlayerIsNull() {
    final GuiLike gui = mock();

    final Exception e = assertThrows(NullPointerException.class, () -> paperVision.open(null, gui));
    assertEquals("player cannot be null", e.getMessage());
  }

  @SuppressWarnings("ConstantConditions")
  @Test
  void testOpenGuiLikeWhenGuiLikeIsNull() {
    final Player player = mock();

    final Exception e =
        assertThrows(NullPointerException.class, () -> paperVision.open(player, (GuiLike) null));
    assertEquals("gui cannot be null", e.getMessage());
  }

  @Test
  void testOpenGuiLike() {
    final PaperVision paperVision = spy(PaperVision.class);
    final Player player = mock();
    final Chest gui = mock();
    final GuiLike guiLike = mock();

    when(guiLike.asGui()).thenReturn(gui);

    paperVision.open(player, guiLike);

    verify(paperVision).open(player, guiLike);
    verify(paperVision).open(player, gui);
    verify(guiLike).asGui();
    verifyNoMoreInteractions(paperVision, player, gui, guiLike);
  }
}

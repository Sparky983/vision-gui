package me.sparky983.vision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

class BorderTest {
  @Test
  void testAll() {
    assertEquals(Set.of(Border.TOP, Border.BOTTOM, Border.LEFT, Border.RIGHT), Border.all());
  }
}

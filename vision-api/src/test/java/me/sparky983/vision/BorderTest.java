package me.sparky983.vision;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BorderTest {

    @Test
    void testAll() {

        assertEquals(Set.of(Border.TOP, Border.BOTTOM, Border.LEFT, Border.RIGHT), Border.all());
    }
}

package dev.forbit.tests;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.implementation.Level;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestFloor {

    @Test public void testDimensions() {
        Level level = new Level(8, 8);

        assertAll(() -> assertEquals(level.getWidth(), 8), () -> assertEquals(level.getHeight(), 8));
    }

    @Test public void addingCell() {
        Level level = new Level(8, 8);
        level.createCell(4, 4, new HashSet<>());
        level.createCell(0, 0, new HashSet<>());
        level.createCell(6, 7, new HashSet<>());

        assertEquals(level.getCells().size(), 3);
        assertTrue(level.getCell(6, 7).isPresent());
        assertFalse(level.getCell(1, 1).isPresent());
    }

    @Test public void testingBitwiseValues() {
        Level level = new Level(8, 8);
        level.createCell(4, 4, new HashSet<>());
        level.createCell(3, 4, new HashSet<>());
        level.createCell(4, 5, new HashSet<>());
        level.createCell(0, 0, new HashSet<>());
        level.createCell(0, 1, new HashSet<>());

        assertEquals(level.getSurroundingCells(4, 4).getBitwiseValue(), 6);
        assertEquals(level.getSurroundingCells(0, 1).getBitwiseValue(), 8);

    }

    @Test public void testSurroundingCells() {
        Level level = new Level(8, 8);
        level.createCell(4, 4, new HashSet<>());
        level.createCell(3, 4, new HashSet<>());
        level.createCell(4, 5, new HashSet<>());
        level.createCell(0, 0, new HashSet<>());
        level.createCell(0, 1, new HashSet<>());

        assertEquals(level.getSurroundingCells(4, 4).getCells().size(), 2);
        assertEquals(level.getSurroundingCells(0, 0).getCells().size(), 1);
    }

    @Test public void testAttributeSetting() {
        Level level = new Level(8, 8);
        level.createCell(4, 4, new HashSet<>(Set.of(DefaultAttributes.START_ROOM)));
        level.createCell(3, 4, new HashSet<>());
        level.createCell(4, 5, new HashSet<>());
        level.createCell(0, 0, new HashSet<>());
        level.createCell(0, 1, new HashSet<>());

        var surrounding = level.getSurroundingCells(4, 4);
        assertTrue(surrounding.getCentre().isPresent());
        assertTrue(surrounding.getCentre().get().getAttributes().contains(DefaultAttributes.START_ROOM));
        assertEquals(surrounding.getCentre().get(), level.getCell(4, 4).get());


    }
}

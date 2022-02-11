package dev.forbit.tests;

import dev.forbit.implementation.Tile;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

;

public class TestCell {

    @Test public void verifyOptionals() {
        Tile cell = new Tile(1, 1);
        cell.setDown(null);
        cell.setUp(new Tile(1, 2));
        cell.setLeft(new Tile(0, 1));
        cell.setRight(null);

        assertAll(() -> assertEquals(cell.getRight(), Optional.empty()),
                  () -> assertEquals(cell.getDown(), Optional.empty()),
                  () -> assertTrue(cell.getLeft().isPresent()),
                  () -> assertTrue(cell.getUp().isPresent()));
    }

    @Test public void verifyGetString() {
        Tile cell = new Tile(1, 1);
        cell.setDown(null);
        cell.setUp(new Tile(1, 2));
        cell.setLeft(new Tile(0, 1));
        cell.setRight(null);

        assertEquals(cell.getString(), "Cell{ bitwise=12, x=1, y=1, neighbouring=[ left=true, right=false, up=true, down=false ] }");
    }

    @Test public void verifyXandY() {
        Tile cell = new Tile(13834, 399931);
        assertAll(() -> assertEquals(cell.getX(), 13834),
                  () -> assertEquals(cell.getY(), 399931));

        Tile cell2 = new Tile(-Integer.MAX_VALUE, Integer.MAX_VALUE - 2);
        assertAll(() -> assertEquals(cell2.getX(), -2147483647),
                  () -> assertEquals(cell2.getY(), 2147483645));
    }
}

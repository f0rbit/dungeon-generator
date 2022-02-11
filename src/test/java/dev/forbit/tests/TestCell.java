package dev.forbit.tests;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.implementation.Tile;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

;

public class TestCell {


    @Test public void verifyGetString() {
        Tile cell = new Tile(1, 1);

        cell.getAttributes().add(DefaultAttributes.END_ROOM);
        cell.getAttributes().add(TestAttributeRegister.AdditionalAttributes.MAGIC_PORTAL_ROOM);

        assertEquals(cell.getString(), "Cell{ x=1, y=1, attributes=[MAGIC_PORTAL_ROOM, END_ROOM] }");
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

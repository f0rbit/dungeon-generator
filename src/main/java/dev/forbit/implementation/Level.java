package dev.forbit.implementation;

import dev.forbit.interfaces.Attribute;
import dev.forbit.interfaces.Cell;
import dev.forbit.interfaces.Floor;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of the Floor interface
 */
public class Level implements Floor {
    @Getter final int width;
    @Getter final int height;

    Cell[][] cells;


    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        cells = new Cell[width][height];
    }

    @Override public Optional<Cell> getCell(int x, int y) {
        if (x < 0 || x >= getWidth()) return Optional.empty();
        if (y < 0 || y >= getHeight()) return Optional.empty();
        return Optional.ofNullable(cells[x][y]);
    }


    public SurroundingCells getSurroundingCells(int x, int y) {
        return new SurroundingCells(getCell(x, y).orElseGet(() -> null),
                                    getCell(x - 1, y).orElseGet(() -> null),
                                    getCell(x + 1, y).orElseGet(() -> null),
                                    getCell(x, y - 1).orElseGet(() -> null),
                                    getCell(x, y + 1).orElseGet(() -> null));
    }

    @Override public Collection<Cell> getCells() {
        return Arrays.stream(cells).flatMap(Arrays::stream).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    private void addCell(int x, int y, @NonNull Cell cell) {
        cells[x][y] = cell;
    }

    public Cell createCell(int x, int y, Set<Attribute> attributes) {
        Tile tile = new Tile(x, y);
        tile.setAttributes(attributes);

        addCell(x, y, tile);
        return tile;
    }
}

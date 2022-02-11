package dev.forbit.implementation;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.interfaces.Cell;
import dev.forbit.interfaces.Floor;
import dev.forbit.interfaces.Generator;
import dev.forbit.interfaces.ValidationRule;
import dev.forbit.util.AttributeRegister;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class RandomGeneration implements Generator {

    @Getter @Setter AttributeRegister attributeRegister = new AttributeRegister();
    @Getter @Setter Set<ValidationRule> validationRules = new HashSet<>(Set.of(new DensityRule(0.3f, 0.6f)));

    @Override public Floor postGeneration(Floor floor) {
        // set end rooms
        floor.getCells().stream().filter((cell -> isDeadEnd(floor.getSurroundingCells(cell.getX(), cell.getY()).getBitwiseValue()))).forEach(cell -> cell.getAttributes()
                                                                                                                                                         .add(DefaultAttributes.END_ROOM));

        List<Cell> endCells = floor.getCells(DefaultAttributes.END_ROOM);
        if (endCells.isEmpty()) { return floor; }
        // choose random end cell to be the start_room
        Random random = new Random();
        endCells.get(random.nextInt(endCells.size())).getAttributes().add(DefaultAttributes.START_ROOM);

        // recursively fill on the start room
        Cell start = floor.getCells(DefaultAttributes.START_ROOM).get(0);
        List<Cell> cells = new ArrayList<>();

        boolean[][] visited = new boolean[floor.getWidth()][floor.getHeight()];
        List<Cell> visitedCells = fill(floor, cells, start);

        // cull all that arent in list
        for (int x = 0; x < floor.getWidth(); x++) {
            for (int y = 0; y < floor.getHeight(); y++) {
                Optional<Cell> cell = floor.getCell(x, y);
                if (cell.isEmpty()) { continue; }
                if (!visitedCells.contains(cell.get())) {
                    floor.removeCell(x, y);
                }
            }
        }
        return floor;
    }

    private List<Cell> fill(Floor floor, List<Cell> cells, Cell cell) {
        if (cells.contains(cell)) { return cells; }
        cells.add(cell);
        for (Cell c : floor.getSurroundingCells(cell.getX(), cell.getY()).getCells()) {
            cells = fill(floor, cells, c);
        }
        return cells;

    }

    private boolean isDeadEnd(int bitwise) {
        return bitwise == 1 || bitwise == 2 || bitwise == 4 || bitwise == 8;
    }


    @Override public Floor initialGeneration(int width, int height) {
        Level level = new Level(width, height);
        Random random = new Random();
        // generate level
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (random.nextBoolean()) {
                    level.createCell(x, y, new HashSet<>());
                }
            }
        }
        return level;
    }
}

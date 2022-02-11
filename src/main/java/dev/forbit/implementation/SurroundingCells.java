package dev.forbit.implementation;

import dev.forbit.interfaces.Cell;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SurroundingCells {
    final Cell left;
    final Cell right;
    final Cell up;
    final Cell down;
    final Cell centre;

    public SurroundingCells(Cell centre, Cell left, Cell right, Cell up, Cell down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.centre = centre;
    }

    public Optional<Cell> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<Cell> getRight() {
        return Optional.ofNullable(right);
    }

    public Optional<Cell> getUp() {
        return Optional.ofNullable(up);
    }

    public Optional<Cell> getDown() {
        return Optional.ofNullable(down);
    }

    public Optional<Cell> getCentre() {
        return Optional.ofNullable(centre);
    }

    /**
     * Returns the bitwise value with right being the first direction
     * <pre>
     * 1 - right
     * 2 - below
     * 4 - left
     * 8 - above
     * </pre>
     *
     * @return the bitwise value of the cell
     */
    public int getBitwiseValue() {
        return (getRight().isPresent() ? 1 : 0) + (getDown().isPresent() ? 2 : 0) + (getLeft().isPresent() ? 4 : 0) + (getUp().isPresent() ? 8 : 0);
    }

    /**
     * Gets a set of the surrounding cells, with null cells excluded.
     *
     * @return the set of cells
     */
    public Set<Cell> getCells() {
        Set<Cell> set = new HashSet<>();
        getLeft().ifPresent(set::add);
        getRight().ifPresent(set::add);
        getUp().ifPresent(set::add);
        getDown().ifPresent(set::add);
        return set;
    }
}

package dev.forbit.implementation;

import dev.forbit.interfaces.Cell;
import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SurroundingCells {
    Cell left;
    Cell right;
    Cell up;
    Cell down;

    public SurroundingCells(Cell left, Cell right, Cell up, Cell down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
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

    /**
     * Returns the bitwise value with right being the first direction
     * 1 - right
     * 2 - below
     * 4 - left
     * 8 - above
     *
     * @return the bitwise value of the cell
     */
    public int getBitwiseValue() {
        return (getRight().isPresent() ? 1 : 0) + (getDown().isPresent() ? 2 : 0) + (getLeft().isPresent() ? 4 : 0) + (getUp().isPresent() ? 8 : 0);
    }

    /**
     * Gets a set of the surrounding cells, with null cells excluded.
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

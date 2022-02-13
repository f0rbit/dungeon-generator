package dev.forbit.implementation;

import dev.forbit.interfaces.Cell;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Data class for defining behaviour of surrounding cells
 */
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

    /**
     * Gets the cell to the left of the centre
     *
     * @return left cell
     */
    public Optional<Cell> getLeft() {
        return Optional.ofNullable(left);
    }

    /**
     * Gets the cell to the right of the centre
     *
     * @return right cell
     */
    public Optional<Cell> getRight() {
        return Optional.ofNullable(right);
    }

    /**
     * Gets the cell above the centre
     *
     * @return above cell
     */
    public Optional<Cell> getUp() {
        return Optional.ofNullable(up);
    }

    /**
     * Gets the cell below the centre
     *
     * @return below cell
     */
    public Optional<Cell> getDown() {
        return Optional.ofNullable(down);
    }

    /**
     * Gets the centre cell
     *
     * @return
     */
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

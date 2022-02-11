package dev.forbit.interfaces;

import lombok.NonNull;

import java.util.Optional;
import java.util.Set;


/**
 * Defines the function that a cell should implement
 */
public interface Cell {

    /**
     * Get the X coordinate of the cell relative to the floor
     * @return x
     */
    @NonNull int getX();

    /**
     * Get the y coordinate of the cell relative to the floor
     * @return y
     */
    @NonNull int getY();

    /*-------- DIRECTIONAL VARIABLES ----------- */

    /**
     * Gets the cell to the left, or empty if null
     *
     * @return left cell
     */
    @NonNull Optional<Cell> getLeft();

    /**
     * Gets the cell to the right, or empty if null
     *
     * @return right cell
     */
    @NonNull Optional<Cell> getRight();

    /**
     * Gets the cell above, or empty if null
     *
     * @return above cell
     */
    @NonNull Optional<Cell> getUp();

    /**
     * Gets the cell underneath, or empty if null
     *
     * @return underneath cell
     */
    @NonNull Optional<Cell> getDown();

    /**
     * Returns the bitwise value with right being the first direction
     * 1 - right
     * 2 - below
     * 4 - left
     * 8 - above
     *
     * @return the bitwise value of the cell
     */
    @NonNull default int getBitwiseValue() {
        return (getRight().isPresent() ? 1 : 0) + (getDown().isPresent() ? 2 : 0) + (getLeft().isPresent() ? 4 : 0) + (getUp().isPresent() ? 8 : 0);
    }


    /**
     * Gets a list of attributes that this cell has.
     * @return a set of attributes
     */
    @NonNull Set<Attribute> getAttributes();


}

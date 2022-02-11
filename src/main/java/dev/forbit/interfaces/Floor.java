package dev.forbit.interfaces;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;


/**
 * Defines the function that a floor should implement
 */
public interface Floor {

    /**
     * Gets a cell instance from the given position
     * @param x the x coordinate
     * @param y the y coordinate
     * @return an optional with the cell contained, or empty if null.
     */
    Optional<Cell> getCell(int x, int y);

    /**
     * Gets the width of the floor
     * @return width
     */
    int getWidth();

    /**
     * Gets the height of the floor
     * @return height
     */
    int getHeight();

    /**
     * Gets the seed used to generate the floor
     * @return seed
     */
    long getSeed();

    /**
     * Gets a 2d array of cells
     * @return the cells
     */
    Collection<Cell> getCells();
}
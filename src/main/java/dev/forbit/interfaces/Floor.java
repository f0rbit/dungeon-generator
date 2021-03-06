package dev.forbit.interfaces;

import dev.forbit.implementation.SurroundingCells;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * Defines the function that a floor should implement
 */
public interface Floor {

    /**
     * Gets a cell instance from the given position
     *
     * @param x the x coordinate
     * @param y the y coordinate
     *
     * @return an optional with the cell contained, or empty if null.
     */
    Optional<Cell> getCell(int x, int y);

    /**
     * Gets the width of the floor
     *
     * @return width
     */
    int getWidth();

    /**
     * Gets the height of the floor
     *
     * @return height
     */
    int getHeight();

    /**
     * Gets a 2d array of cells
     *
     * @return the cells
     */
    List<Cell> getCells();


    /**
     * Gets a list of cells with a given attribute
     * @param attribute
     * @return
     */
    List<Cell> getCells(Attribute attribute);


    /**
     * Adds a cell to the floor
     *
     * @param x          x coordinate
     * @param y          y coordinate
     * @param attributes the set of attribute for the tile to have initially
     */
    Cell createCell(int x, int y, @NonNull Set<Attribute> attributes);


    SurroundingCells getSurroundingCells(int x, int y);

    void removeCell(int x, int y);
}

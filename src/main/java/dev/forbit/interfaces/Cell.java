package dev.forbit.interfaces;

import lombok.NonNull;

import java.util.Set;


/**
 * Defines the function that a cell should implement
 */
public interface Cell {

    /**
     * Get the X coordinate of the cell relative to the floor
     *
     * @return x
     */
    @NonNull int getX();

    /**
     * Get the y coordinate of the cell relative to the floor
     *
     * @return y
     */
    @NonNull int getY();


    /**
     * Gets a list of attributes that this cell has.
     *
     * @return a set of attributes
     */
    @NonNull Set<Attribute> getAttributes();


    default String getString() {
        return String.format("Cell{ x=%s, y=%s, attributes=%s }", getX(), getY(), getAttributes());

    }

}

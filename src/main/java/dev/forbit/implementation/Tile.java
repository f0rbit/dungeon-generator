package dev.forbit.implementation;

import dev.forbit.interfaces.Attribute;
import dev.forbit.interfaces.Cell;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Tile implements Cell {
    @Getter final int x;
    @Getter final int y;
    @Getter Set<Attribute> attributes = new HashSet<>();

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

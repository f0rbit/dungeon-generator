package dev.forbit.implementation;

import dev.forbit.interfaces.Attribute;
import dev.forbit.interfaces.Cell;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Tile implements Cell {
    @Getter @Setter int x;
    @Getter @Setter int y;
    @Setter Cell left;
    @Setter Cell right;
    @Setter Cell up;
    @Setter Cell down;
    @Getter Set<Attribute> attributes = new HashSet<>();

    public Tile(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override public Optional<Cell> getLeft() {
        return Optional.ofNullable(left);
    }

    @Override public Optional<Cell> getRight() {
        return Optional.ofNullable(right);
    }

    @Override public Optional<Cell> getUp() {
        return Optional.ofNullable(up);
    }

    @Override public Optional<Cell> getDown() {
        return Optional.ofNullable(down);
    } }

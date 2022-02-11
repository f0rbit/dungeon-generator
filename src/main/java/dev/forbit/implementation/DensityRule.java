package dev.forbit.implementation;

import dev.forbit.interfaces.Floor;
import dev.forbit.interfaces.ValidationRule;
import lombok.Getter;

public class DensityRule implements ValidationRule {

    @Getter final float minDensity;
    @Getter final float maxDensity;

    public DensityRule(float atLeast) {
        this(atLeast, 1.0f);
    }

    public DensityRule(float minDensity, float maxDensity) {
        this.minDensity = minDensity;
        this.maxDensity = maxDensity;
    }


    @Override public boolean isValid(Floor floor) {
        int size = floor.getWidth() * floor.getHeight();
        float percentageFull = floor.getCells().size() / (float) size;
        return (percentageFull >= getMinDensity() && percentageFull <= getMaxDensity());
    }
}

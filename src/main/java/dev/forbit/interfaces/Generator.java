package dev.forbit.interfaces;

import java.util.Optional;
import java.util.Set;

public interface Generator {

    Set<ValidationRule> getValidationRules();

    /**
     * post generation event, is called after the initial generation phase
     * <p>
     * Use this to apply attributes to certain cell types
     *
     * @param floor
     *
     * @return
     */
    Floor postGeneration(Floor floor);

    Floor initialGeneration(int width, int height);

    default boolean validate(Floor floor) {
        return getValidationRules().stream().allMatch(rule -> rule.isValid(floor));

    }

    private void cull(Floor floor) {
        // cut off any single cells (ie cells with no neighbours)
        for (int x = 0; x < floor.getWidth(); x++) {
            for (int y = 0; y < floor.getHeight(); y++) {
                var surrounding = floor.getSurroundingCells(x, y);
                if (surrounding.getBitwiseValue() == 0) { floor.removeCell(x, y); }
            }
        }
    }

    default Optional<Floor> generate(int width, int height, int tries) {
        int count = 0;
        Floor floor;
        do {
            floor = initialGeneration(width, height);
            cull(floor);
            floor = postGeneration(floor);
            count++;
            if (count > tries) { return Optional.empty(); }
        } while (!validate(floor));
        return Optional.of(floor);
    }

    default Optional<Floor> generate(int width, int height) {
        return generate(width, height, Integer.MAX_VALUE);
    }

}

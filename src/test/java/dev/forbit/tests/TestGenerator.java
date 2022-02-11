package dev.forbit.tests;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.implementation.DensityRule;
import dev.forbit.implementation.RandomGeneration;
import dev.forbit.interfaces.Floor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestGenerator {

    @ParameterizedTest(name = "{index} - {0}x{0} dungeon") @ValueSource(ints = {8, 10, 16, 32, 64, 128}) public void testRandomGenerator(int size) {
        RandomGeneration generator = new RandomGeneration();
        Optional<Floor> f = generator.generate(size, size);

        assertTrue(f.isPresent());
        Floor floor = f.get();
        assertFalse(floor.getCells().isEmpty());
        assertFalse(floor.getCells(DefaultAttributes.START_ROOM).isEmpty());
    }

    @ParameterizedTest(name = "{index} - {0}x{0} dungeon") @ValueSource(ints = {8, 10, 16, 32}) public void testValidationRules(int size) {
        RandomGeneration generator = new RandomGeneration(new DensityRule(0.35f));
        Optional<Floor> f = generator.generate(size, size);

        assertTrue(f.isPresent());
        Floor floor = f.get();
        assertFalse(floor.getCells().isEmpty());
        assertFalse(floor.getCells(DefaultAttributes.START_ROOM).isEmpty());
    }
}

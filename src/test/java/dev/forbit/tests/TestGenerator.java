package dev.forbit.tests;

import dev.forbit.implementation.RandomGeneration;
import org.junit.jupiter.api.Test;

public class TestGenerator {

    @Test public void testRandomGenerator() {
        RandomGeneration generator = new RandomGeneration();
        generator.generate(8, 8);

        System.out.println(generator);
    }
}

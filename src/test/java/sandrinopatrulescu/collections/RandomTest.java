package sandrinopatrulescu.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static sandrinopatrulescu.collections.Math.inRange;

class RandomTest {
    @Test
    void nextInt() {
        for (int i = 0; i < 100; i++) {
            int minimum = 0;
            int maximum = 10;

            assertTrue(inRange(Random.nextPositiveInt(0, maximum), minimum, maximum - 1));
        }
    }
}
package sandrinopatrulescu.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    void inRange() {
        assertTrue(Math.inRange(0, 0, 1));
        assertTrue(Math.inRange(1, 0, 1));
        assertFalse(Math.inRange(2, 0, 1));
    }

    @Test
    void isPrime() {
        assertFalse(Math.isPrime(0));
        assertFalse(Math.isPrime(1));
        assertTrue(Math.isPrime(2));
        assertTrue(Math.isPrime(3));
        assertFalse(Math.isPrime(4));
        assertTrue(Math.isPrime(5));
        assertTrue(Math.isPrime(7));
        assertFalse(Math.isPrime(10));
        assertTrue(Math.isPrime(11));
        assertTrue(Math.isPrime(13));
    }
}
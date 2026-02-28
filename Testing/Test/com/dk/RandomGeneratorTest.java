package com.dk;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    void testArrayNotNull() {
        RandomGenerator obj = new RandomGenerator();
        int[] ans = obj.random();
        assertNotNull(ans);
    }
    @Test
    void testValuesInRange() {
        RandomGenerator obj = new RandomGenerator();
        int[] ans = obj.random();
        for (int value : ans) {
            assertTrue(value > 0 && value <= 10);
        }
    }
    @Test
    void testNegativeValue() {
        RandomGenerator obj = new RandomGenerator();
        int[] ans = obj.random();
        for (int value : ans) {
            assertFalse(value < 0 );
        }
    }
    
}
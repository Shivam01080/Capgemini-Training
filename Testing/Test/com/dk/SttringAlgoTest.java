package com.dk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.System.out;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class StringAlgoTest {

    @BeforeAll
    static void beforeAll() {
        out.println("Before all tests - open DB connection");
    }

    @AfterAll
    static void afterAll() {
        out.println("After all tests - close DB connection");
    }

    @Test
    void testShift2Char_NormalCase() {
        StringAlgo obj = new StringAlgo();
        String input = "Hello";
        String expected = "lloHe";
        String actual = obj.shift2Char(input);
        assertEquals(expected, actual);
        out.println(actual);
    }

    @Test
    void testShift2Char_AnotherCase() {
        StringAlgo obj = new StringAlgo();
        String input = "Java";
        String expected = "vaJa";
        String actual = obj.shift2Char(input);
        assertEquals(expected, actual);
        out.println(actual);
    }

    @Test
    void testFromDB() {
        StringAlgo obj = new StringAlgo();
        String expected = "From db value received";
        String actual = obj.getFromDB();
        assertEquals(expected, actual);
    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)   // Increased timeout
    void testFromDB1() {
        StringAlgo obj = new StringAlgo();
        String expected = "From db value received";
        String actual = obj.getFromDB();
        assertEquals(expected, actual);
    }

   /* @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void sortTest() {
        VaduniAlgo algo = new VaduniAlgo();
        int[] a = new int[100000];

        // Populate with random integers
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 100000);
        }

       algo.sort(a);
    }*/
}
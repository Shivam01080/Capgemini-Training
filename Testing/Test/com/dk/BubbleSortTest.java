package com.dk;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BubbleSortTest extends TestCase {
	
	    @Test
	    public void testSingleElement() {
	        int[] arr = {7};
	        BubbleSort.bubble(arr);
	        assertArrayEquals(new int[]{7},arr);
	    }

	    @Test
	    public void testEmptyArray() {
	        int[] arr = {};
	        BubbleSort.bubble(arr);
	        assertArrayEquals(new int[]{}, arr);
	    }

	}
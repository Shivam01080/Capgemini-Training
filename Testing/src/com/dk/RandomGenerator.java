package com.dk;

import java.util.Arrays;

public class RandomGenerator {

    public int[] random() {
        int arr[] = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)((Math.random() * 10)+1); 
        }
        return arr;
    }
    public static void main(String[] args) {
        RandomGenerator obj = new RandomGenerator();
        int[] ans = obj.random();
        System.out.println(Arrays.toString(ans));
    }

}
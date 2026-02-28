package com.dk;

import java.util.HashSet;
import java.util.Set;

public class StepsToGetBackWithSumDigitSquares {

    public int getSteps(int n) {
        Set<Integer> s = new HashSet<>();
        int orig = n;
        int count = 0;

        while (true) {
            int temp = n;
            int sum = 0;

            while (temp != 0) {
                int rem = temp % 10;
                sum += rem * rem;
                temp /= 10;
            }

            count++;

            if (sum == orig) {
                return count;
            }

            if (sum == 1 || s.contains(sum)) {
                return -1;
            }

            s.add(sum);
            n = sum;
        }
    }
}
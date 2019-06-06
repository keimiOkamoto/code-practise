package com.keimi.codeingfun.puzzles;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * <p>
 * You can modify the input array in-place.
 */
public class Dc4 {

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};

        System.out.println("Should be 1: " + findFirstMissingPositiveInteger(Arrays.asList(2, 5, -1, 4, 14)));
        System.out.println("Should be 5: " + findFirstMissingPositiveInteger(Arrays.asList(2, 3, 4)));

        System.out.println("Should be 2: " + findFirstMissingPositiveInteger(Arrays.asList(3, 4, -1, 1)));
        System.out.println("Should be 1: " + findFirstMissingPositiveInteger(Arrays.asList(3, 4, -1, 5)));
        System.out.println("Should be 2: " + findFirstMissingPositiveInteger(Arrays.asList(-2, 4, -1, 1)));
        System.out.println("Should be 2: " + findFirstMissingPositiveInteger(Arrays.asList(-2, -4, -1, 1)));
        System.out.println("Should be 3: " + findFirstMissingPositiveInteger(Arrays.asList(-2, -4, -1, 1, 2)));
        System.out.println("Should be 3: " + findFirstMissingPositiveInteger(Arrays.asList(0, -4, -1, 1, 2)));

    }

    private static int findFirstMissingPositiveInteger(List<Integer> numbers) {
        int min = 0;

        for (int x = 0; x < numbers.size() - 1; x++) {
            if (Math.abs(numbers.get(x) - numbers.get(x + 1)) > 1) {
                if (numbers.get(x) < 0 || numbers.get(x + 1) < 0) {
                    min = 0;

                    if (numbers.get(x) == 1 || numbers.get(x + 1) == 1) {
                        min = 1;
                    }
                } else {
                    if (numbers.get(x) < numbers.get(x + 1)) {
                        if (min - numbers.get(x) > 1) {
                            min = numbers.get(x);
                        }
                    } else {
                        if (min - numbers.get(x) > 1) {
                            min = numbers.get(+1);
                        }
                    }
                }
            } else if (Math.abs(numbers.get(x) - numbers.get(x + 1)) == 1) {
                if (numbers.get(x) < numbers.get(x + 1)) {
                    min = numbers.get(x + 1);
                } else {
                    min = numbers.get(x);
                }

            }
        }
        return min + 1;
    }
}

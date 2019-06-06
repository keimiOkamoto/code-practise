package com.keimi.codeingfun.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, return a new array such that each element at index i of
 * the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5],
 * the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * <p>
 * Follow-up: what if you can't use division?
 */
public class Dc2 {


    public static final Integer[] input = {1, 2, 3, 4, 5};

    public static List<Integer> calculate() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(input));
        List<Integer> buffer = new ArrayList<>();

        for (int x = 0; x < numbers.size(); x++) {
            numbers.remove(x);
            buffer.add(numbers.stream().reduce((e, y) -> e * y).get());
            numbers = new ArrayList<>(Arrays.asList(input));
        }
        return buffer;
    }

    public static void main(String[] args) {
        System.out.println(calculate());
    }
}

package com.keimi.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.
 * <p>
 * For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:
 * <p>
 * There is 1 smaller element to the right of 3
 * There is 1 smaller element to the right of 4
 * There are 2 smaller elements to the right of 9
 * There is 1 smaller element to the right of 6
 * There are no smaller elements to the right of 1
 */


public class Dc1 {
    public static int[] array = {20, 20, 9, 1, 1};


    public static void main(String[] args) {
        long start = System.nanoTime();

        List<Integer> calculate = calculate(array);
        System.out.println(calculate);

        long finish = System.nanoTime();
        long timeElapsed = finish - start;

//        System.out.println("Time taken: " + timeElapsed);
//
//        List<Integer> calculate1 = calculate(Arrays.stream(array).boxed().collect(Collectors.toList()), 0, new ArrayList<>(), 20);
//        System.out.println(calculate1);

    }

    public static List<Integer> calculate(int[] input) {
        List<Integer> buffer = new ArrayList<>();

        for (int x = 0; input.length > x; x++) {
            int[] range = getSubArray(input, x);

            int counter = 0;
            for (int y = 0; range.length > y; y++) {
                if (input[x] > range[y]) {
                    counter++;
                }
            }
            buffer.add(counter);
        }
        return buffer;
    }


//    public static List<Integer> calculate(List<Integer> input, int acc, List<Integer> buffer, int head) {
//        if (input.size() == 0 ) {
//            buffer.add(acc);
//            return buffer;
//        } else {
//            if (head > input.get(0)) {
//                acc = acc + 1;
//            }
//            calculate(input.subList(1, input.size()), acc, buffer, head);
//        }
//        return buffer;
//    }

    private static int[] getSubArray(int[] input, int x) {
        return Arrays.copyOfRange(input, x + 1, input.length);
    }
}

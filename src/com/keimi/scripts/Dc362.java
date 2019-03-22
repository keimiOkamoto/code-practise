package com.keimi.scripts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A strobogrammatic number is a positive number that appears the same after being rotated 180 degrees. For example, 16891 is strobogrammatic.
 * <p>
 * Create a program that finds all strobogrammatic numbers with N digits.
 */
public class Dc362 {

    private static final List ERROR_NUMBERS = Arrays.asList(3, 4, 7);


    private static boolean isStrobogramaticNumber(int number) {
        List<String> numbers = Arrays.asList(String.valueOf(number).split(""));
        if (containsErrorValue(number)) {
            return false;
        } else {
            return check(numbers);
        }
    }

    private static boolean check(List<String> numbers) {
        if (numbers.size() == 0 || numbers.size() == 1) {
            if (numbers.get(0).equals("6") || numbers.get(0).equals("9")) {
                return false;
            }
            return true;
        } else if ((numbers.get(0).equals("6") && numbers.get(numbers.size() - 1).equals("9"))
                || (numbers.get(0).equals("9") && numbers.get(numbers.size() - 1).equals("6"))) {
            return true;
        } else if (!numbers.get(0).equals(numbers.get(numbers.size() - 1))
                || (numbers.get(0).equals("6") && numbers.get(numbers.size() - 1).equals("6"))
                || (numbers.get(0).equals("9") && numbers.get(numbers.size() - 1).equals("9"))) {
            return false;
        } else {
            return check(numbers.subList(1, numbers.size() - 1));
        }
    }

    public static boolean containsErrorValue(int number) {
        List<String> numbers = Arrays.asList(String.valueOf(number).split(""));

        return !numbers.stream()
                .filter(num -> ERROR_NUMBERS.contains(Integer.parseInt(num)))
                .collect(Collectors.toList())
                .isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isStrobogramaticNumber(621689126));
    }
}

//Rules
// 1
// 11
// 181

//1 2 5 6 8 9 0
//Non: 2(this one?) 3 4  5(is this one?) 7

// First check is to check the input val for any of the illegal characters ---> Fail it
//
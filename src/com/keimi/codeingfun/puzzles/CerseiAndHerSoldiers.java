package com.keimi.codeingfun.puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CerseiAndHerSoldiers {

    public static int getNumberOfClasses(){
        return convertToList(inputDirectory.get(1)).get(2);
    }

    private static List<Integer> convertToList(String input) {
        List<String> strings = Arrays.asList(input.split(" "));
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static Map<Integer, Long> getNumberOfSoldiersPerClass() {
        return convertToList(inputDirectory.get(2)).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean isValid(int numberOfClasses) {
        return numberOfClasses > getNumberOfSoldiersPerClass().keySet().size();
    }

    private boolean hasValidCommunicationLines() {
        return getNumberOfCommunicationLines() - getNumberOfSoldiers() == 1;
    }

    private static int getNumberOfCommunicationLines() {
        return convertToList(inputDirectory.get(1)).get(1);
    }

    private static int getNumberOfSoldiers() {
        return convertToList(inputDirectory.get(1)).get(0);
    }

    private static boolean isValidPairs(List<String> listOfPairs) {
        List<Pairs> pairs = listOfPairs.stream().map(e -> new Pairs(Integer.parseInt(e.split(" ")[0]), Integer.parseInt(e.split(" ")[1]))).collect(Collectors.toList());
        Map<Integer, Long> dictionaryOfPairs = pairs.stream().collect(Collectors.groupingBy(Pairs::getVal1, Collectors.counting()));
        List<Long> collect = dictionaryOfPairs.entrySet().stream().filter((k) -> k.getValue() > 2).map(c -> c.getValue()).collect(Collectors.toList());
        return collect.isEmpty();
    }

    static class Pairs {
        int val1;
        int val2;

        Pairs(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        int getVal1() {
            return val1;
        }

        int getVal2() {
            return val2;
        }


        @Override
        public String toString() {
            return "Pairs{" +
                    "val1=" + val1 +
                    ", val2=" + val2 +
                    '}';
        }
    }

    private static Map<Integer, String> inputDirectory;
    private static final String USER_INPUT = "1\n" +
                   "5 4 5\n" +
                   "1 1 2 2 3\n" +
                   "1 2\n" +
                   "1 3\n" +
                   "2 4\n" +
                   "2 5\n" +
                   "3 6 \n" +
                   "3 7\n" +
                   "3 8\n";
    private static final int[] x = {1,2,3};

    public static void main(String[] args) {
        String [] arrayInput = USER_INPUT.split("\n");
        List<String> input = Arrays.stream(arrayInput).collect(Collectors.toList());
        inputDirectory = IntStream.range(0, input.size()).boxed()
                                                         .collect(Collectors.toMap(Function.identity(), input::get));


        List<String> pairs = Arrays.stream(Arrays.copyOfRange(arrayInput, 3, arrayInput.length)).collect(Collectors.toList());

        isValidPairs(pairs);

        System.out.println(isPalindrome(1221));

    }


    public static boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        String[] elements = num.split("");

        List<String> numbers = Arrays.stream(elements).collect(Collectors.toList());
        return isPalindromey(numbers);
    }

    public static boolean isPalindromey(List<String> elements) {
        if (elements.size() == 1 || elements.size() == 0) {
            return true;
        } else if (!elements.get(0).equals(elements.get(elements.size()-1))) {
            return false;
        }  else {
            return isPalindromey(elements.subList(1, elements.size()-2));
        }
    }
}

package com.keimi.codeingfun.datastructures;

class Runner {
    public static void main(String[] args) {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();

        System.out.println(arraysAndStrings.hasUniqueCharacters("helo"));
        System.out.println("Is it a permutation? " + arraysAndStrings.checkPermutations("tac", "act"));
    }
}

public class ArraysAndStrings {

    boolean hasUniqueCharacters(String word) {
        String[] array = word.split("");
        for (int i=0; i < array.length - 1; i++) {
            if (array[i].equals(array[i+1])){
                return false;
            }
        }
        return true;
    }

    boolean checkPermutations(String testString, String baseString) {
        String[] testArray = testString.split("");
        String[] baseArray = baseString.split("");
        boolean exists = false;

        if (testArray.length != baseArray.length || !hasUniqueCharacters(testString)) return false;

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < baseArray.length; j++) {
                if (testArray[i].equals(baseArray[j])) {
                    exists = true;
                    break;
                } else {
                    exists = false;
                }
            }
        }
        return exists;
    }

    public String URLify(String word) {
        return null;

    }
}

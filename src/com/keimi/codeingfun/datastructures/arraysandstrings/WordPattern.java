package com.keimi.codeingfun.datastructures.arraysandstrings;

import java.util.*;
import java.util.stream.*;

class Runener {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
//        System.out.println(wordPattern.wordPattern("abba", "dog dog dog fish"));
        int[] x  = {1,1,1,0,1,1,1,1};
        int[] y  = {1,0,0,0,0,1,0,0};

        System.out.println(wordPattern.cellCompete(x, 2));

    }
}

class WordPattern {
    private Map<String, String> dict = new HashMap<>();


     public List<Integer> cellCompete(int[] states, int days) {
         List result = new ArrayList<>();

        while (days > 0) {
            int[] newState = buildState(states, days);
            result = Arrays.stream(newState).boxed().collect(Collectors.toList());
            states = newState;
            days--;
        }
        return result;
    }

    private int[] buildState(int[] state, int days) {
        int [] newState = new int[state.length];

            for (int i = 0; i < state.length-1; i++) {
                if (i == 0) { //if head
                    if (0 == state[i+1]) {
                        newState[i] = 0;
                    } else {
                        newState[i] = 1;
                    }
                } else if (i == state.length-1) { //if tail
                    if (0 == state[i-1]) {
                        newState[i] = 0;
                    } else {
                        newState[i] = 1;
                    }
                } else {
                    if (state[i-1] == state[i+1]) {
                        newState[i] = 0;
                    } else {
                        newState[i] = 1;
                    }
                }
            }
        return newState;
    }



    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        String[] patternArray = pattern.split("");
        List<Integer> result = new ArrayList<Integer>();
        int[] b = new int[3];
        Arrays.stream(b).boxed().collect(Collectors.toList());

        for(int i=0; i < result.size(); i++) {
//            result = Arrays.stream(buildState).boxed().collect(Collectors.toList);
        }


        int[] x = new int[1];
        int[] y = new int[x.length];
        if (strArray.length != patternArray.length) return false;

        for (int i=0; i < patternArray.length; i++) {
            if (isNewKey(strArray[i])) {
                for (Map.Entry<String, String> entrySet: dict.entrySet()) {
                    if (entrySet.getValue().equals(patternArray[i])) {
                        return false;
                    }
                }
                dict.put(strArray[i], patternArray[i]);
            } else {
                String value = dict.get(strArray[i]);
                if (!value.equals(patternArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNewKey(String s) {
        return !dict.containsKey(s);
    }

}

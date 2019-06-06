package com.keimi.codeingfun.puzzles;

import java.util.*;
import java.util.stream.*;

class Runner {
    public static void main(String[] args) {
        RomanNumerals romanNumerals = new RomanNumerals();
        System.out.println("shoulbe be 8 " + romanNumerals.romanToInt("MCMXCIV"));
//        romanNumerals.romanToInt("MCMXCIV");
    }
}

class RomanNumerals {

    private static final Map<String, Integer> DICT = new HashMap() {
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }
    };


    public int romanToInt(String s) {
        String[] romanNum = s.split("");
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= romanNum.length - 1; i++) {
            System.out.println(i);
            if (romanNum[i].equals("I")) {
                if (i != romanNum.length - 1) {
                    if (romanNum[i + 1].equals("V")) {
                        Integer value = DICT.get("V") - DICT.get("I");
                        result.add(value);
                        i = i + 1;
                    } else if (romanNum[i + 1].equals("X")) {
                        Integer value = DICT.get("X") - DICT.get("I");
                        result.add(value);
                        i = i + 1;
                    } else {
                        result.add(DICT.get(romanNum[i]));
                    }
                } else {
                    result.add(DICT.get(romanNum[i]));
                }

            } else if (romanNum[i].equals("X")) {
                if (i != romanNum.length - 1) {
                    if (romanNum[i + 1].equals("L")) {
                        Integer value = DICT.get("L") - DICT.get("X");
                        result.add(value);
                        i = i + 1;
                    } else if (romanNum[i + 1].equals("C")) {
                        Integer value = DICT.get("C") - DICT.get("X");
                        result.add(value);
                        i = i + 1;
                    } else {
                        result.add(DICT.get(romanNum[i]));
                    }
                } else {
                    result.add(DICT.get(romanNum[i]));
                }
            } else if (romanNum[i].equals("C")) {
                if (i != romanNum.length - 1) {
                    if (romanNum[i + 1].equals("D")) {
                        Integer value = DICT.get("D") - DICT.get("C");
                        result.add(value);
                        i = i + 1;
                    } else if (romanNum[i + 1].equals("M")) {
                        Integer value = DICT.get("M") - DICT.get("C");
                        result.add(value);
                        i = i + 1;
                        for (String x : romanNum) {
                            System.out.print(x);
                        }
                    } else {
                        result.add(DICT.get(romanNum[i]));
                    }
                } else {
                    result.add(DICT.get(romanNum[i]));
                }
            } else {
                result.add(DICT.get(romanNum[i]));

            }
        }
        return result.stream().collect(Collectors.summingInt(Integer::intValue));
    }

}
package com.keimi.codeingfun.datastructures.arraysandstrings;

import java.util.*;
import java.util.stream.*;


class StringsPractice {

    public static void main(String[] args) {
        System.out.println(toUpperCase2("ham"));
        System.out.println(convertToNumber());

    }

    public static String toUpperCase(String s) {
        int diff = 'a' - 'A'; // 32

        return s.chars()
                .filter(c -> c >= 'a' && c <= 'z' || c == ' ')
                .mapToObj(c -> String.valueOf((char) (c - (diff))))
                .collect(Collectors.joining());
    }

    public static String toUpperCase2(String str) {
        int diff = 'a' - 'A'; // 32

        return str.chars().filter(asci -> (asci >= 'a' && asci <= 'z') || asci == ' ')
                .mapToObj(c -> String.valueOf((char) (c - diff))).collect(Collectors.joining());
    }


    private static List<Integer> ints = Arrays.asList(1, 2, 3, 4);
    private static List<String> strings = Arrays.asList("1", "2");

    public static int convertToNumber() {
        System.out.println(strings.stream().filter(x -> x == "1").collect(Collectors.toList()));
        return Integer.parseInt(String.join("", strings));

    }

    public int reverse(int x) {
        String[] nums = Integer.toString(x).split("");
        List<String> buffer = new ArrayList<>();

        for (int y = nums.length - 1; y > 0; y--) {
            buffer.add(nums[y]);
        }

        return Integer.parseInt(buffer.stream().collect(Collectors.joining()));
    }

}

class Permutations {

    public static <T> Stream<Stream<T>> of(final List<T> items) {
        return IntStream.range(0, factorial(items.size())).mapToObj(i -> permutation(i, items).stream());
    }

    private static int factorial(final int num) {
        return IntStream.rangeClosed(2, num).reduce(1, (x, y) -> x * y);
    }

    private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
        if (input.isEmpty()) { return output; }
        System.out.println("Count is: " + count );

        final int factorial = factorial(input.size() - 1);
        output.add(input.remove(count / factorial));
        return permutation(count % factorial, input, output);
    }

    private static <T> List<T> permutation(final int count, final List<T> items) {
        return permutation(count, new LinkedList<>(items), new ArrayList<>());
    }

}

class MorseCode {
    private static final String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


    public static void main(String[] args) {
//        String v = "hello";
//        System.out.println(v.substring(1, 4));
//        createDictionary();
//        System.out.println(rotateString("abcde", "bcdea"));
////        System.out.println(getRotations("abc", "abc", ""));
//
//        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

//        Permutations.of(Arrays.asList(3,4,6)).forEach(p -> { p.forEach(System.out::print); System.out.print(" "); });

//        System.out.println(factorial(3));
//        Map<String, Integer> result = givenList.stream()
//                .collect(toMap(Function.identity(), ));

//        System.out.println(result);
        numsMutable.add(6);
        numsMutable.add(4);
        numsMutable.add(1);

        List<List<Integer>> pairs = IntStream.range(1, numsMutable.size() + 1).mapToObj(e -> getPair(e, new ArrayList<>(numsMutable))).flatMap(x -> x.stream()).collect(Collectors.toList());
        Integer integer = pairs.stream().map(x -> x.get(0) - x.get(1)).collect(Collectors.toSet()).stream().filter(x -> x > 0).min(Comparator.comparing(Integer::intValue)).get();

    }

    private static List<List<Integer>> getPair(int e, List<Integer> nums) {
        Integer removed = nums.remove(e-1);
        System.out.println(removed +  " ye" );
        return nums.stream().map(x -> Arrays.asList(removed, x)).collect(Collectors.toList());
    }

    static List<Integer> nums = Arrays.asList(1,2,3);
    static List<Integer> numsMutable = new ArrayList<Integer>();











    private static int factorial(final int num) {
        return IntStream.rangeClosed(2, num).reduce(3, (x, y) -> x * y);
    }

    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> dictionary = createDictionary();

        List<List<String>> wordSplit = Arrays.stream(words).map(word -> Arrays.asList(word.split(""))).collect(Collectors.toList());

        List<String> listy = wordSplit.stream()
                .map(listWord -> listWord.stream().map(c -> dictionary.get(c.charAt(0))).collect(Collectors.joining())).collect(Collectors.toList());

        return listy.size();
    }


    public static boolean rotateString(String A, String B) {
        List<List<String>> buffer = new ArrayList();
        String[] aAsElements = A.split("");


        LinkedList<String> list = new LinkedList<>(Arrays.asList(A.split("")));
        for (int x = 0; x < aAsElements.length; x++) {
            String first = list.getFirst();
            list.remove(0);
            list.addLast(first);

            List<String> b = new ArrayList<>(list);
            buffer.add(b);
        }


        buffer.size();

        List<String> collect = buffer.stream().map(l -> String.join("", l)).collect(Collectors.toList());
        return collect.contains(B);
    }


    public static Map<Character, String> createDictionary() {
        Map<Character, String> dictionary = new HashMap<>();
        List<Character> charactersList = new ArrayList<>();

        IntStream.rangeClosed('a', 'z').forEach(c -> {
            charactersList.add((char) c);
        });

        for (int x = 0; x < morseCode.length; x++) {
            dictionary.put(charactersList.get(x), morseCode[x]);
        }

        return dictionary;
    }
}

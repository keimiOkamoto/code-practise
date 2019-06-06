package com.keimi.codeingfun.java8;


import java.util.*;
import java.util.stream.Collectors;

class MapPracticeAndOthers {

    private int[] primitiveInts = new int[7];
    private int[] primitiveInts2 = {1, 2, 3};
    private String[] primitiveString = {"one", "two", "three"};

    private static List<List<String>> namesNested = Arrays.asList(
            Arrays.asList("Jeff", "Bezos"),
            Arrays.asList("Bill", "Gates"),
            Arrays.asList("Mark", "Zuckerberg"));


    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0, "male"),
            new Employee(2, "Bill Gates", 200000.0, "male"),
            new Employee(2, "Jill Gates", 200000.0, "female"),
            new Employee(3, "Mark Zuckerberg", 300000.0, "male")
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
    private static List<Integer> ints = Arrays.asList(1,2,3,4);

    private static int add(List<Integer> list, int acc) {
        if (list.size() == 0) {
            return acc;
        } else {
            acc = acc + list.get(0);
            return add(list.subList(1,list.size()), acc);
        }
    }


    public static void main(String[] args) {

        System.out.println(add(ints, 0) + " hello");


        namesNested.stream().flatMap(Collection::stream).forEach(System.out::println);


        empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(empList.get(0).salery);

        List<Employee> jeff_bezos = Arrays.asList(arrayOfEmps).stream().filter(x -> x.name.equals("Jeff Bezos")).collect(Collectors.toList());
        System.out.println(jeff_bezos.get(0).name);


        List<Employee> jeff_bezoss = Arrays.asList(arrayOfEmps).stream().map(x -> {
            return x;
        }).distinct().collect(Collectors.toList());


        List<Employee> sorted = Arrays.asList(arrayOfEmps).stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(sorted);


        Arrays.asList(arrayOfEmps).stream().min(Comparator.comparingDouble(Employee::getSalery)).orElseThrow(NoSuchElementException::new);
        Arrays.asList(arrayOfEmps).stream().max(Comparator.comparingDouble(Employee::getSalery)).orElseThrow(NoSuchElementException::new);


        Double totalSalery = Arrays.asList(arrayOfEmps).stream().map(Employee::getSalery).reduce(0.0, Double::sum);
        int[] n = {1, 2, 3};
        int[] n2 = {2, 3};
        Arrays.stream(n).boxed().map(num -> num * num).sorted().collect(Collectors.toList());

        boolean b = Arrays.stream(n).boxed().collect(Collectors.toList()).containsAll(Arrays.stream(n2).boxed().collect(Collectors.toList()));

        Set<Integer> numList1 = Arrays.stream(n).boxed().collect(Collectors.toSet());
        Set<Integer> numList2 = Arrays.stream(n2).boxed().collect(Collectors.toSet());
        numList1.removeAll(numList2);
        System.out.println(numList1 + " y");


        numList1 = Arrays.stream(n).boxed().collect(Collectors.toSet());
        numList2 = Arrays.stream(n2).boxed().collect(Collectors.toSet());
        List<Integer> collect1 = numList1.stream().filter(numList2::contains).collect(Collectors.toList());
        System.out.println(collect1 + " collect1");

        List<Integer> numList = Arrays.stream(n2).boxed().collect(Collectors.toList());
        Integer integer = numList.get(0);
        System.out.println("be 1" + integer);


//        boolean b1 = Arrays.stream(n).boxed().allMatch(x -> numList1.remove(x));
        System.out.println(numList1 + " y");

        String joined = Arrays.asList(arrayOfEmps).stream().map(Employee::getName).collect(Collectors.joining(" *** "));
        System.out.println(joined);

        Map<Boolean, List<Employee>> part = Arrays.asList(arrayOfEmps).stream().collect(Collectors.partitioningBy(e -> e.getSex().equals("male")));
        System.out.println(part.get(false));

        Map<Character, List<Employee>> names = Arrays.asList(arrayOfEmps).stream().collect(Collectors.groupingBy(e -> e.getName().charAt(0)));
        System.out.println(names);

        Arrays.asList(arrayOfEmps).stream().collect(Collectors.groupingBy(e -> e.getName().charAt(0), Collectors.mapping(Employee::getId, Collectors.toList())));
        Map<Character, List<Double>> collect = Arrays.asList(arrayOfEmps).stream().collect(Collectors.groupingBy(e -> new Character(e.getName().charAt(0)), Collectors.mapping(e -> e.salery, Collectors.toList())));
    }


    public Map<Integer, String> getMap(int[] primitiveInts2) {
        List<Integer> ints = Arrays.stream(primitiveInts2).boxed().collect(Collectors.toList());
        return null;
    }
}

class HasCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(3);
        l.next = new ListNode(2);
        l.next.next = l;
        System.out.println(hasCycle(l));
    }
    public static boolean hasCycle(ListNode head) {
        return hasCycle2(head, new ArrayList<>());

    }

    static boolean hasCycle2(ListNode head, List<Integer> visited) {
        if (visited.contains(head.next.val)) {
            return true;
        } else if (head.next == null) {
            return false;
        } else {
            visited.add(head.val);
            return hasCycle2(head.next, visited);
        }
    }

}

class PalindromeAndUniqueEmails {

    static String[] x = {"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
    static String y = "testemail@leetcode.com";
    static String J = "aA", S = "aAAbbbb";

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(x));
        System.out.println(y.substring(1, y.length()));

        System.out.println(S.substring(0, J.length()) + J.length());
        System.out.println("is Palindrome: " + isPalindrome("aa"));

    }

    public static int numUniqueEmails(String[] emails) {
        // List<String> emailList = Arrays.asList(emails).stream().map(email -> email.replaceAll(".", "")).collect(Collectors.toList());

        List<String> emailList = Arrays.asList(emails);
        List<String> collect = emailList.stream().map(e -> getLocalName(e.substring(0, e.indexOf("@"))).concat(e.substring(e.indexOf("@")))).collect(Collectors.toList());
        return collect.size();


    }

    static boolean isPalindrome(String x) {
        if (x.length() == 1 || x.length() == 0) {
            return true;
        } else {
            if (x.charAt(0) == x.charAt(x.length()-1)) {
                return isPalindrome(x.substring(1, x.length()-1));
            } else {
                return false;
            }
        }
    }

    public static String getLocalName(String localName) {
        System.out.println(localName);
        String newLocalName = localName.replaceAll(".", "");
        if (newLocalName.contains("+")) {
            newLocalName = localName.substring(0, localName.indexOf("+"));
        }
        return newLocalName;
    }
//    ["testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"]

}

class Employee {
    int id = 0;
    String name;
    double salery;
    String sex;

    public Employee(int id, String name, double salery, String sex) {
        this.id = id;
        this.name = name;
        this.salery = salery;
        this.sex = sex;
    }

    public void salaryIncrement(double v) {
        this.salery += v;
    }

    public String getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalery() {
        return salery;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salery=" + salery +
                '}';
    }
}

class Pascal {

    static String[] x = {"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
    static String y = "testemail@leetcode.com";

    public static void main(String[] args) {
        System.out.println(generate(8));

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> initial = new ArrayList<>();

        if (numRows != 0) {
            initial.add(1);
            pascal.add(Arrays.asList(1));
            return getPascal(numRows, pascal, initial);
        } else {
            return Arrays.asList(Arrays.asList());
        }
    }

    private static List<List<Integer>> getPascal(int numRows, List<List<Integer>> pascal, List<Integer> initial) {
        if (numRows == 0) {
            return pascal;
        } else {
            List<Integer> row = createRow(initial, new ArrayList<>(), initial.size() + 1);
            pascal.add(row);
            if (row.size() == 1 && numRows > 1) {
                row.add(1);
            }
            return getPascal(numRows - 1, pascal, row);
        }
    }

    public static List<Integer> createRow(List<Integer> previousList, List<Integer> buffer, int row) {
        if (previousList.isEmpty() || previousList.size() == 1) {
            buffer.add(1);
            return buffer;
        } else if (row - previousList.size() == 1) {
            buffer.add(1);
            return createRow(previousList, buffer, row + 1);
        } else {
            int value = previousList.get(0) + previousList.get(1);
            buffer.add(value);
            return createRow(previousList.subList(1, previousList.size()), buffer, row);
        }
    }
}

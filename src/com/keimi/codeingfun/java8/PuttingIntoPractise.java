package com.keimi.codeingfun.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class PuttingIntoPractise {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> sortedValues2011 = transactions.stream()
                .filter(t -> t.getYear() == 2001)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        List<String> cities = transactions.stream().map(transaction -> transaction.getTrader()
                .getCity()).distinct()
                .collect(Collectors.toList());

        List<Trader> cambridgeNameOrder = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .distinct()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(cambridgeNameOrder);

        List<String> traderNames = transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .collect(Collectors.toList());

        String reduce = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (name1, name2) -> name1 + name2);
        String join = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(joining());

        System.out.println(join);

        Boolean basedInMilan = transactions.stream().anyMatch(x -> x.getTrader().getCity().equals("Milan"));

        System.out.println("----------------------------------------------------");

        transactions.stream()
                    .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        Optional<Integer> highestTransaction = transactions.stream().map(Transaction::getValue).reduce(Integer::max);

        System.out.println(highestTransaction);


        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));

        System.out.println(min.get());

    }
}

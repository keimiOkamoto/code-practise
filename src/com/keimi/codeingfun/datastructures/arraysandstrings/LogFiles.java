package com.keimi.codeingfun.datastructures.arraysandstrings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class LogFiles {

    private static  String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
    public static void main(String[] args) {
        System.out.println();

        for ( String c: reorderLogFiles(logs)) {
            System.out.println(c);
        }

    }
    public static  String[] reorderLogFiles(String[] logs) {
        Map<LogType, List<Line>> dict = Arrays.asList(logs).stream().map(line -> {
            if (Character.isDigit(line.split(" ")[1].charAt(0))) {
                return new Line(LogType.DIGIT, line);
            } else {
                return new Line(LogType.LETTER, line);
            }
        }).collect(Collectors.toList()).stream().collect(Collectors.groupingBy(Line::getLogType));

        List<Line> linesLetter = dict.get(LogType.LETTER);
        linesLetter.sort(Comparator.comparing(s -> s.getLine().substring(1)));

        String[] collect = Stream.concat(linesLetter.stream(), dict.get(LogType.DIGIT).stream())
                .collect(Collectors.toList()).stream().map(x -> x.getLine()).collect(Collectors.toList()).stream().toArray(String[]::new);


        return collect;
    }
}

enum LogType {
    DIGIT,
    LETTER
}

class Line {
    private LogType logType;
    private String line;

    public Line(LogType logType, String line) {
        this.logType = logType;
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public LogType getLogType() {
        return logType;
    }

    @Override
    public String toString() {
        return "Line{" +
                "logType=" + logType +
                ", line='" + line + '\'' +
                '}';
    }
}
package com.practise.stream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String [] args){

    }

    public static long getCountEmptyStringUsingJava8(List<String> strings){
        return strings.stream()
                .filter(s -> s.isEmpty())
                .count();
    }

    public static long getCountLength3UsingJava8(List<String> strings){
        return strings.stream()
                .filter(s -> s.length() == 3)
                .count();
    }

    public static List<String> deleteEmptyStringsUsingJava8(List<String> strings){
        return strings.stream()
                .filter(n -> n.length() != 0)
                .collect(Collectors.toList());
    }

    public static String getMergedStringUsingJava8(List<String> strings, String string){
        String merged = strings.stream()
                        .filter(n -> n.length() != 0)
                        .collect(Collectors.joining(string));
        return merged;
    }

    public static List<Integer> getSquaresJava8(List<Integer> numbers){
        return numbers.stream()
                .distinct()
                .map(n -> n*n)
                .collect(Collectors.toList());
    }

    public static Integer getMaxJava8(List<Integer> numbers){

        return numbers.stream()
                .mapToInt(n -> n)
                .max().orElse(-1);
    }

    public static Integer getMinJava8(List<Integer> numbers){
        return  numbers.stream()
                .mapToInt(n -> n)
                .min().orElse(-1);
    }

    public static Integer getSumJava8(List<Integer> numbers){
        return IntStream.range(0, numbers.size())
                .map(n -> numbers.get(n))
                .sum();
    }

    public static Integer getAverageJava8(List<Integer> numbers){

        double result = IntStream.range(0, numbers.size())
                .map(n -> numbers.get(n))
                .average().orElse(-1);

        return (int) result;
    }

}

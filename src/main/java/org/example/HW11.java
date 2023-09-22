package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class HW11 {
    // список для першого і другого завдань
    static List<String> list = Arrays.asList("Ivan", "Vlad", "John", "Patrik", "Carl", "Mitchel");

    // Стріми для п'ятого завдання
    static Stream<String>streamFirst = Stream.of("Ivan", "Vlad", "John", "Patrik", "Lesya");
    static Stream<String>streamSecond = Stream.of("1", "2", "3", "4", "5");


    public static void main(String[] args) {
        System.out.println(task1());
        System.out.println(task2());// нужно развернуть сортировку
        System.out.println(task3());

        // п'яте завдання
        Stream <String> result = zip_Task5(streamFirst, streamSecond);
        List<String> collect = result.collect(Collectors.toList());
        System.out.println(collect);
    }

    public static String task1 (){
        List<String> filterList = list.stream()
                .filter(elem -> list.indexOf(elem) % 2 != 0)
                .collect(Collectors.toList());
        int i = 1;
        StringBuilder result = new StringBuilder();
        for (int e = 0; e < filterList.size(); e++) {
            result.append(i).append(". ").append(filterList.get(e)).append(", ");
            i += 2;
            if (e == filterList.size() - 1) {
                result = new StringBuilder(result.substring(0, result.length() - 2));
                result.append(".");
            }
        }
        return result.toString();
    }

    public static List<String> task2 (){

        List<String> listBeforeRevers = list.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        return IntStream.range(0, listBeforeRevers.size())
                .map(i -> (listBeforeRevers.size() - 1 - i))    // IntStream
                .mapToObj(listBeforeRevers::get)                // Stream<T>
                .collect(Collectors.toCollection(ArrayList::new));


    }

    public static List<String> task3 (){

        String[] array = {"1, 2, 0", "4, 5"};

        return Arrays.stream(array)
                .map(elem -> elem.split(", "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }



    public static <T> Stream<T> zip_Task5(Stream<T> first, Stream<T> second){

        Set<T> result = new HashSet<>();

        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());

        }
        return result.stream();
    }
}
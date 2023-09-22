package org.example;

import java.util.stream.Stream;

public class Task4 {

    long a = 25214903917L;
    long c = 11;
    long m = (int)Math.pow(2,48);

    public static void main(String[] args) {
        Task4 randomNext = new Task4();
        Stream.iterate(100, randomNext::next)
                .limit(5)
                .forEach(System.out::println);
    }
    public int next(int x){

        return (int) ((int)(a * x + c) % m);

    }


}

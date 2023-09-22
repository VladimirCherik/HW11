package org.example;

public class TestNotHW {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11;
        long m = (int)Math.pow(2,48);

        long x=0;

        int arr[] = new int[5];

        for (int i = 0; i<5; i++) {
            arr[i] = (int) ((a * x + c) % m);
            x += 1;
            System.out.println(arr[i]);
        }
    }
}

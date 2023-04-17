package com.gbjava.seminar02;

import java.util.Scanner;

public class Task001 {
    public static void main(String[] args) {
    /*
    * Дано четное число N (>0) и символы c1 и c2.
        Написать метод, который вернет строку длины N,
    * которая состоит из чередующихся символов c1 и c2, начиная с c1.
    */


        Scanner cs = new Scanner(System.in);
        System.out.print("Input amount of chars: ");
        int amountOfChar = cs.nextInt();

        String[] c= new String[] {"A","b"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < amountOfChar; i++) {
            result.append(c[i % 2]);
        }
        System.out.println(result);


    }
}

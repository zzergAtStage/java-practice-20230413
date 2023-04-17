package com.gbjava.seminar02;

import java.util.Scanner;

public class Task001 {
    public static void main(String[] args) {
    /*
    * Дано четное число N (>0) и символы c1 и c2.
        Написать метод, который вернет строку длины N,
    * которая состоит из чередующихся символов c1 и c2, начиная с c1.
    */



        char a = 'A';
        char b = 'b';
        int n = 5;
        String str = "" + a + b;
        str = str.repeat(n / 2) + ((n % 2 == 1) ? a : "");
        System.out.println(str);
    }
}

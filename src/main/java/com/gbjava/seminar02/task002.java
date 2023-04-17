package com.gbjava.seminar02;

import java.util.Arrays;

public class task002 {
    public static void main(String[] args) {
        /*
        * Напишите метод, который сжимает строку.
            Пример: вход aaaabbbcdd.
        * */
        String trash = "aaaabbbcddYYYYYoooooo00000";
        StringBuilder result = new StringBuilder();

        int counter = 1;

        for (int i = 0; i < trash.length() - 1 ; i++) {
           if ( trash.charAt(i + 1) != trash.charAt(i)) {
               result.append(trash.charAt(i));
               if (counter != 1) {
                   result.append(counter);
               }
                counter = 0;
            }

           counter++;
        }
        result.append((trash.charAt(trash.length() - 1))).append(counter);
        System.out.println(result);

    }
}

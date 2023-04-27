package com.gbjava.seminar05;

import java.util.HashMap;
import java.util.Scanner;

public class examples {
    public static void main(String[] args) {
        qz();
    }

    private static void qz() {
//        Написать метод, который переведет число из римского формата записи в арабский.
//        Например, MMXXII = 2022
//        MMXXI I   IV - 4        IX - 9
//                  I < V = 4     I < X = 9
//>>
//              ^
        HashMap<Character,Integer> mapChars = new HashMap<>(7);
        mapChars.put('I',1);
        mapChars.put('V', 5);
        mapChars.put('X', 10);
        mapChars.put('L', 50);
        mapChars.put('C', 100);
        mapChars.put('D', 500);
        mapChars.put('M', 1000);
        System.out.print("Enter romanNumber: ");
        Scanner scanner = new Scanner(System.in);
        String romanNumber = scanner.nextLine();
        int result = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int currentRoman = mapChars.get(romanNumber.charAt(i));
            int prevRoman = i == 0  ? 0 : mapChars.get(romanNumber.charAt(i - 1));

            if ( i > 0 && currentRoman > prevRoman) {
                result -= prevRoman;
                result += currentRoman - prevRoman;
            } else {
                result += currentRoman;
            }
        }

        System.out.printf("Arabic : %n from Roman: %s",result,romanNumber);


    }
}

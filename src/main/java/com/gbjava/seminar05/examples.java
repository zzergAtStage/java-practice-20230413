package com.gbjava.seminar05;

import java.util.HashMap;
import java.util.Scanner;

public class examples {
    public static void main(String[] args) {
        qz();
        int arabicNumber = 40;
        String romanNumber = convertToRoman(arabicNumber);
        System.out.println("Roman numeral for " + arabicNumber + " is: " + romanNumber);
    }

    private static void qz() {
//        Написать метод, который переведет число из римского формата записи в арабский.
//        Например, MMXXII = 2022
//        MMXXI I   IV - 4        IX - 9
//                  I < V = 4     I < X = 9
//>>
//              ^
        HashMap<Character, Integer> mapChars = new HashMap<>(7);
        mapChars.put('I', 1);
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
            int prevRoman = i == 0 ? 0 : mapChars.get(romanNumber.charAt(i - 1));

            if (i > 0 && currentRoman > prevRoman) {
                result -= prevRoman;
                result += currentRoman - prevRoman;
            } else {
                result += currentRoman;
            }
        }

        System.out.printf("Arabic : %n from Roman: %s", result, romanNumber);
    }

    public static String convertToRoman(int number) {
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (number >= arabicValues[i]) {
                romanNumber.append(romanSymbols[i]);
                number -= arabicValues[i];
            }
        }

        return romanNumber.toString();
    }
}

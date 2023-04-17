package com.gbjava.seminar01;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkS01 {
    private static final int ZERO_FILLER = 0;

    public static void main(String[] args) {
        /*
         * 1. Написать метод, принимающий на вход два аргумента: len и initialValue,
         * и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
         */
        Library.ShirkRow();
        exercise01();
        /*
         * 2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
         */
        Library.ShirkRow();
        exercise02();
        /*
         * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
         * , и с помощью цикла(-ов) заполнить его диагональные элементы единицами
         */
        Library.ShirkRow();
        exercise04();

        /*
         *  В консоли запросить имя пользователя.
         * В зависимости от текущего времени, вывести приветствие вида:
         * */
        Library.ShirkRow();
        exercise04_4();
        /*
         * 5.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
         * или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
         * */
        Library.ShirkRow();
        int arraySize = 5;
        exercise05(arraySize);

    }

    private static void exercise01() {
        int lengthArray = 5;
        int fillArrayThing = 12;
        int[] arrayT01 = Library.GetArray(lengthArray, fillArrayThing);
        System.out.println(Arrays.toString(arrayT01));
    }

    private static void exercise02() {
        //init variables
        int arrayLength = 12;
        int arrLeftRange = 0;
        int arrRightRange = 100;
        int[] array;
        //get new array
        array = Library.GetArray(arrayLength, arrLeftRange, arrRightRange);
        int minValue = array[0];
        int maxValue = array[0];
        //finding both min and max value
        for (int i = 1; i < arrayLength; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            } else if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        //output
        System.out.println(Arrays.toString(array));
        System.out.printf(" MinValue = %1$d, MaxValue = %2$d%n", minValue, maxValue);
    }

    private static void exercise04() {

        int arrayLength = 8;

        int[][] array = Library.GenSquareArray(arrayLength, ZERO_FILLER);
        int stepBackDirection = arrayLength - 1;
        for (int i = 0; i < arrayLength; i++) {
            array[i][i] = 1;
            array[stepBackDirection - i][i] = 1;
        }
        Library.OutPutSquareArray(array);
    }

    private static void exercise04_4() {
        Scanner scanner = new Scanner(System.in);
        String userName;
        System.out.print("Enter user name: ");
        final int MORNING = 5;
        final int NOON = 12;
        final int EVENING = 18;
        final int NIGHT = 23;


        boolean canBeRead = scanner.hasNext();
        if (canBeRead) {
            userName = scanner.nextLine();
        } else {
            userName = "user";
        }
        int currentHour = LocalTime.now().getHour();//Extract hours to compare with parts of day
        String promptBlueprint = "Добр{0} {1},  {2}!";

        String prompt;
        if (MORNING < currentHour && currentHour < NOON) {
            prompt = MessageFormat.format(promptBlueprint, "ое", "утро", userName);
        } else if (NOON <= currentHour && currentHour < EVENING) {
            prompt = MessageFormat.format(promptBlueprint, "ый", "день", userName);
        } else if (EVENING <= currentHour && currentHour < NIGHT) {
            prompt = MessageFormat.format(promptBlueprint, "ый", "вечер", userName);
        } else if (NIGHT == currentHour || currentHour < MORNING) {
            prompt = MessageFormat.format(promptBlueprint, "ой", "ночи", userName);
        } else {
            prompt = MessageFormat.format(promptBlueprint, "ого", "времени суток", userName);
        }
        System.out.println(prompt);
    }

    private static void exercise05(int arraySize) {
        Scanner scanner = new Scanner(System.in);
        int shiftN = 0;
        while (shiftN == 0) {
            System.out.print("Input shift value: ");
            shiftN = scanner.nextInt();
        }
        int leftRange = 10;
        int rightRange = 20;
        int[] array = Library.GetArray(arraySize, leftRange, rightRange);//new int[] { 3, 5, 6, 1}
        System.out.println("Original array: " + Arrays.toString(array));
        ShiftArrayByNumElements(array, shiftN);// magic!
        System.out.println("Array after sort " + Arrays.toString(array));
    }

    private static void ShiftArrayByNumElements(int[] array, int shiftN) {
        /*         v
        *     [ 3, 5, 6, 1]
         *            ^  l
        *     [ 1, 3, 5, 6]
        *       l
        * */

        int n = array.length;

        if (shiftN > 0) { // Right shift
            for (int i = 0; i < shiftN; i++) {
                int j,last;
                last = array[n-1];
                for (j = n - 1; j > 0; j--) {
                    array[j] = array[j-1];
                }
                array[0] = last;
            }

        } else if (shiftN < 0) { // Left shift
            /*       v
             *     [ 3, 5, 6, 1]
             *       l  ^  <-
             *     [ 5, 6, 1, 3]
             *                l
             * */
            for (int i = 0; i < Math.abs(shiftN); i++) {
                int j,first;
                first = array[0];
                for (j = 0; j < n - 1; j++){
                    array[j] = array[j+1];
                }
                array[n-1] = first;
            }
        }


    }







}

package com.gbjava.seminar01;

import java.util.Arrays;

public class HomeWorkS01 {
    private static final int ZERO_FILLER = 0;

    public static void main(String[] args) {
        /**
         * 1. Написать метод, принимающий на вход два аргумента: len и initialValue,
         * и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
         */
        Library.ShirkRow();
        exersice01();
        /**
         * 2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
         */
        Library.ShirkRow();
        exersice02();

        Library.ShirkRow();
        exersice04();

    }

    private static void exersice01() {
        int lengthArray = 5;
        int fillArrayThing = 12;
        int[] arrayT01 = Library.GenArray(lengthArray, fillArrayThing);
        System.out.println(Arrays.toString(arrayT01));
    }

    private static void exersice02() {
        //init variables
        int arrayLength = 12;
        int arrLeftRange = 0;
        int arrRightRange = 100;
        int[] array = new int[arrayLength];
        //get new array
        array = Library.GenArray(arrayLength, arrLeftRange, arrRightRange);
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

    private static void exersice04() {
        /**
         * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
         * , и с помощью цикла(-ов) заполнить его диагональные элементы единицами
         */
        int arrayLength = 8;

        int[][] array = Library.GenSquareArray(arrayLength, ZERO_FILLER);
        int stepBackDirection = arrayLength - 1;
        for (int i = 0; i < arrayLength; i++) {
            array[i][i] = 1;
            array[stepBackDirection-i][i] = 1;
        }
        Library.OutPutSquareArray(array);
    }

}

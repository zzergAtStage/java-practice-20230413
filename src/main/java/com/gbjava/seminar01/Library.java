package com.gbjava.seminar01;
import java.util.Arrays;
import java.util.Random;

public class Library {

    public static void ShirkRow(){
        System.out.println("========================^^^^^^^^^^^^^^^===========================");
    }
    public static int[] GetArray(int arrayLength, int arrayValue){
        int[] array = new int[arrayLength];
        Arrays.fill(array,arrayValue);
        return array;
    }
    public static int[] GetArray(int arrayLength, int leftRange, int rightRange){
        int[] array = new int[arrayLength];
        Random rnd = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i]= rnd.nextInt(leftRange,rightRange);
        }
        return array;
    }
    public static int[][] GenSquareArray(int arrayLength,int arrayValue){
        int[][] array = new int[arrayLength][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                array[i][j] = arrayValue;
            }
        }
        return array;
    }
    public static void OutPutSquareArray(int[][] array){
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("[");
            for (int j = 0; j < arrayLength; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

}

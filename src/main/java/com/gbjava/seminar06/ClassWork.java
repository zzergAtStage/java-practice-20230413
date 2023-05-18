package com.gbjava.seminar06;

import com.gbjava.seminar01.Library;

import java.util.Collections;
import java.util.HashSet;

public class ClassWork {
    /*
    * 1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}. Распечатайте содержимое данного множества.
    2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.  Распечатайте содержимое данного множества.
    3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.  Распечатайте содержимое данного множества.
    * */
    public static void main(String[] args) {

        Integer[] array = Library.GetArray(1000, 0, 24);
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, array);
        System.out.println(set);
        double resCalcDistinct;
        resCalcDistinct = (double) set.size() / array.length;
        System.out.println(resCalcDistinct);
    }
}

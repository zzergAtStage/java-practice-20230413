package com.gbjava.lesson03;

import java.util.ArrayList;

public class Examples {
    public static void main(String[] args) {
        int d = 2;
        System.out.println(GetClass(d));
        //collection
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            integerArrayList.set(i, i);
        }
        integerArrayList.add(12);
        for (var item :
                integerArrayList) {
            System.out.print(item);
        }
    }

    static String GetClass(Object o){
        return  o.getClass().getName();
    }
}

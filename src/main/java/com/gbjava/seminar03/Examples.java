package com.gbjava.seminar03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Examples {
    public static void main(String[] args) {
        //ex0();
        ex2_2();
    }

    private static void ex0() {
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 99; i++) {
            list.add(random.nextInt(0,i + 1));
        }
        System.out.println(list);
    }

    private static void ex2_2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};

        List<String> randomSolarSystem = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            randomSolarSystem.add(planetsNamesStringArray[random.nextInt(0,planetsNamesStringArray.length)]);
        }
        System.out.println(randomSolarSystem);
//        boolean isFound;
        for (String planet :
                planetsNamesStringArray) {
            for (int j = randomSolarSystem.indexOf(planet) + 1; j < randomSolarSystem.size(); j++) {
                if (randomSolarSystem.get(j).equals(planet)){
                    randomSolarSystem.remove(j);
                }
            }
        }
        System.out.println(randomSolarSystem);
    }

}

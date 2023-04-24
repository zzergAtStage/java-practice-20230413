package com.gbjava.seminar03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task2_2 {
    public static void main(String[] args) {
        ex2_2();
        //аполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
        //Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
    }

    private static void ex2_2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};

        List<String> randomSolarSystem = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomSolarSystem.add(planetsNamesStringArray[random.nextInt(0,planetsNamesStringArray.length)]);
        }
        System.out.println(randomSolarSystem);
//        boolean isFound;
        for (String planet :
                planetsNamesStringArray) {
            int firstInclude = ((randomSolarSystem.indexOf(planet) == -1) ? randomSolarSystem.size() : randomSolarSystem.indexOf(planet));
            //indexOf возвращает -1!!!1111 если объект не в массиве
            for (int j = firstInclude + 1; j < randomSolarSystem.size(); j++) {
                String tmp = randomSolarSystem.get(j);
                if (tmp.equals(planet)){
                    randomSolarSystem.remove(j);

                }
            }
            System.out.println(randomSolarSystem);
        }
        System.out.println(randomSolarSystem);
    }
}

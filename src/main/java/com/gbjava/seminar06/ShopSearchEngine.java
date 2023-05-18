package com.gbjava.seminar06;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ShopSearchEngine {
    public static Map<Integer, String> searchParameter = Map.of(
            1,"RAM size",
            2,"SSD volume",
            3,"OS type",
            4, "Min price");

    public final static String DEFAULTPROMPT;

    static {
        DEFAULTPROMPT = "You can search with next parameters:\n"
                + "1 - RAM size\n"
                + "2 - SSD volume\n"
                + "3 - OS type\n"
                + "4 - Min price...";
    }

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    public static Set<Laptop> searchLaptops(Map<Integer, Laptop> laptopsMap, String desiredParameter, int typeOfSearch) throws NullPointerException{
        int intParam = 0;
        Set<Laptop> matchingLaptops = new HashSet<>();
        try { if (isNumeric(desiredParameter)) {
                intParam = Integer.parseInt(desiredParameter); //RAMsize, SSD size, price (cast)
            }
        } catch (NumberFormatException e) {
            System.out.println("error when parsed integer value: " + typeOfSearch);
            return null;
        }

        for (Laptop laptop : laptopsMap.values()) {
            switch (typeOfSearch) {
                case 1 -> {
                    if (laptop.getRamSize() >= intParam) matchingLaptops.add(laptop);
                }
                case 2 -> {
                    if (laptop.getSsdSize() >= intParam) matchingLaptops.add(laptop);
                }
                case 3 -> {
                    if (laptop.getOs().equalsIgnoreCase(desiredParameter)) matchingLaptops.add(laptop);
                }
                case 4 -> {
                    if ((int) laptop.getPrice() <= intParam) matchingLaptops.add(laptop);
                }
                default -> {
                }
            }
        }

        return matchingLaptops;
    }
    public static String SearchPrompt(int parameter ) {
        return "Enter a value of " + searchParameter.get(parameter) + ":";
    }
}

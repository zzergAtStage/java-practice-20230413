package com.gbjava.seminar06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static com.gbjava.seminar06.ShopSearchEngine.DEFAULTPROMPT;

public class Shop {
    public static void main(String[] args) {
        Map<Integer, Laptop> laptopShopStore = new HashMap<>();
        laptopShopStore.put(1, new Laptop(8, 512, 1001, 999.99, "null"));
        laptopShopStore.put(2, new Laptop(16, 1024, 1002, 1499.99, "WIN 11"));
        laptopShopStore.put(3, new Laptop(8, 128, 1003, 799.99, "MS-DOS"));

        System.out.println(DEFAULTPROMPT);
        String userPrompt;
        String desiredParam;
        int searchParameterNumber;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            searchParameterNumber = scanner.nextInt();
            if (ShopSearchEngine.searchParameter.containsKey(searchParameterNumber)) {
                userPrompt = ShopSearchEngine.SearchPrompt(searchParameterNumber);
                break;
            }
            System.out.println("Enter valid search parameter (between 1 and 4)!");
        }
        System.out.print(userPrompt);

        desiredParam = scanner.nextLine(); //TODO check this parameter

        // Perform the search and print the matching laptops

        try {
            Set<Laptop> matchingLaptops = ShopSearchEngine.searchLaptops(laptopShopStore, desiredParam, searchParameterNumber);
            for (Laptop laptop : matchingLaptops) {
                System.out.println(laptop);
            }
        } catch (NullPointerException ex) {
            System.out.println("There is not any laptop for your parameters...");
        }

    }
}

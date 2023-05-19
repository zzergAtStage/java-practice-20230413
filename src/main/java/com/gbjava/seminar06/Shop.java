package com.gbjava.seminar06;

import java.util.*;

import static com.gbjava.seminar06.ShopSearchEngine.DEFAULTPROMPT;

public class Shop {
    public static void main(String[] args) {
        Map<Integer, Laptop> laptopShopStore = new HashMap<>();
        laptopShopStore.put(1, new Laptop(8, 512, 1001, 999.99, "null"));
        laptopShopStore.put(2, new Laptop(16, 1024, 1002, 1499.99, "WIN 11"));
        laptopShopStore.put(3, new Laptop(8, 128, 1003, 799.99, "MS-DOS"));




        Map<Integer, String> userChoice = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(DEFAULTPROMPT);
            int searchParameterNumber;
            while (true) {
                searchParameterNumber = scanner.nextInt();
                if (ShopSearchEngine.searchParameter.containsKey(searchParameterNumber)) {
                    break;
                }
                System.out.println("Enter valid search parameter (between 1 and 4)!");
            }
            System.out.print(ShopSearchEngine.SearchPrompt(searchParameterNumber));
            scanner.nextLine();
            String desiredParam = scanner.nextLine();
            userChoice.put(searchParameterNumber, desiredParam);

            System.out.println("Would you like to add another search parameter => Y/N");
        } while (!scanner.nextLine().equalsIgnoreCase("N"));

        System.out.println("Your choice:");
        System.out.println(userChoice);


        Set<Laptop> matchingLaptops = ShopSearchEngine.searchLaptops(laptopShopStore,userChoice );
        if (matchingLaptops.isEmpty()) {
            System.out.println("There are no laptops that match your parameters...");
        } else {
            for (Laptop laptop : matchingLaptops) {
                System.out.println(laptop);
            }
        }

    }
}

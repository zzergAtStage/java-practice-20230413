package com.gbjava.seminar05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class HomeWork05 {
    public static void main(String[] args) throws FileNotFoundException {
//        Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        exercise01();
        System.out.println("--------------------------<<< Exercise 02 >>> --------------------------------");

        exercise02();

    }

    private static void exercise01() {
        Telephone telephone = new Telephone(new HashMap<>());
        Scanner scan = new Scanner(System.in);
        getInputData(telephone, scan);
        System.out.println(telephone.Book);

        System.out.println("Search input: ");
        String searchRow = scan.nextLine();
        PrintSubscriberNumbers(telephone, searchRow);

    }

    /**
     * method becomes a values, separated by ~ symbol
     * doesn't accept any spaces
     *
     * @param book refer to the HashMap in libClass
     * @param scan value of text searched in book
     */
    private static void getInputData(Telephone book, Scanner scan) {
        String[] dataRow;
        while (true) {
            System.out.print("Input values Name ~ TelephoneNumber: ");
            String userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase("stop")) {
                break;
            }
            if (!userInput.contains("~")) {
                System.out.println("The string doesn't content the '~' symbol! Repeat the input...");
                continue;
            }

            dataRow = userInput.split("\\~+");

            book.Book.put(dataRow[1], dataRow[0]);
        }
    }

    private static void PrintSubscriberNumbers(Telephone telephone, String searchRow) {
        if (telephone.Book.containsValue(searchRow)) {
            System.out.printf("For  subscriber '%s' present numbers:%n", searchRow);
            for (var entry : telephone.Book.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(searchRow)) {
                    System.out.println("\t" + entry.getKey());
                }
            }
        }
    }





    private static void exercise02() throws FileNotFoundException {
        HashMap<String, String> namesTable = getMapForFile();
        LinkedHashMap<String, Integer> countedNames = new LinkedHashMap<>();

        if (namesTable.size() > 0) {
            countNames(namesTable, countedNames);

            Map<String, Integer> sortedNames = getSortedMapNames(countedNames);

            System.out.println(sortedNames);
        }
    }

    private static Map<String, Integer> getSortedMapNames(LinkedHashMap<String, Integer> countedNames) {
        Map<String, Integer> sortedNames = countedNames.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return sortedNames;
    }

    private static void countNames(HashMap<String, String> namesTable, LinkedHashMap<String, Integer> countedNames) {
        int counter = 0;
        for (var entry : namesTable.entrySet()) {
            String name = entry.getValue();
            countedNames.put(name, countedNames.getOrDefault(name, 0) + 1);
        }
    }


    private static HashMap<String, String> getMapForFile() throws FileNotFoundException {
        String pathName = "src/main/resources/names.txt";
        File myData = new File(pathName);
        HashMap<String, String> namesTable = new HashMap<>();
        Scanner scanner = new Scanner(myData);
        while (scanner.hasNextLine()) {

            String nameObj = scanner.nextLine();
            if (nameObj.contains("\s")) {
                String[] nameSplit = nameObj.split("\s");
                namesTable.put(nameObj, nameSplit[0]);
            }

        }
        return namesTable;
    }
}

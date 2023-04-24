package com.gbjava.seminar03;

import java.util.*;


public class HomeWork03 {
    public static void main(String[] args) {
        //ex01();
        ex02();
    }

    private static void ex01() {
        ArrayList<Object> listWithObjects = new ArrayList<>(Arrays.asList("0", "3.21", "Яблоко", "11", "13", "Апельсин", "Дыня", "17"));
        System.out.println(listWithObjects);
        int i = 0;
        while (i < listWithObjects.size()) {

            if (tryParseInt(listWithObjects.get(i))) {
                listWithObjects.remove(i); // removes an element and moves all element to the left!!!111
            } else {
                i++;
            }
        }
        System.out.println(listWithObjects);
    }

    public static boolean tryParseInt(Object value) {
        try {
            Integer.parseInt((String) value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void ex02() {
        final int GENREPOS = 0;
        Scanner scanner = new Scanner(System.in);
        List<ArrayList<String>> library = new ArrayList<>();

        //How to fill books
        boolean stillInput = true;
        String value;
        int genreRow;
        System.out.println("\\033[H\\033[2J");
        System.out.println("Start filling library... to stop input print 'stop'");
        while (stillInput) {
            ArrayList<String> rowsBooks = new ArrayList<>();
            System.out.print(">_ ");
            value = scanner.nextLine(); //inputs "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".

            if (!value.equals("stop")) {
                getBooks(value, rowsBooks);
                genreRow = getGenresRow(rowsBooks.get(GENREPOS), library);
                if (genreRow == -1) {
                    //add new genre with books
                    library.add(library.size(),rowsBooks);
                } else {
                    //removing genre and pasting the rest
                    rowsBooks.remove(GENREPOS);
                    library.get(genreRow).addAll(rowsBooks);
                }
            } else {
                stillInput = false;
            }
        }
        printToConsoleLibrary(library);
    }

    private static void getBooks(String value, ArrayList<String> rowsBooks) {

        String[] tmp = value.split("\\s*,\\s*");
        for (String book :
                tmp)
            rowsBooks.add(book);

    }

    private static int getGenresRow(String value, List<ArrayList<String>> library) {
        int row = -1;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).contains(value)) {
                row = i;
                return row;
            }
        }
        return row;

    }

    private static void printToConsoleLibrary(List<ArrayList<String>> library) {
        System.out.println("Genge \t Books");
        for (int i = 0; i < library.size(); i++) {
            System.out.print(library.get(i).get(0) + " [");
            for (int j = 1; j < library.get(i).size(); j++) {
                System.out.print(library.get(i).get(j) + " ");
            }
            System.out.print("]\n");
        }
    }

}

package com.gbjava.seminar04;

import java.util.LinkedList;
import java.util.Scanner;

public class HomeWork04 {
    public static void main(String[] args) {
        ex01();
    }
    static void ex01(){
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> listOfWords= new LinkedList<>();
        while (true) {
            String userInput = scanner.nextLine();


                if (userInput.equalsIgnoreCase("stop")){
                    break;
                }
                else if (userInput.equalsIgnoreCase("print")){
                    PrintArrayReversal(listOfWords);
                } else if (userInput.equalsIgnoreCase("revert")){
                    RevertLastWord(listOfWords);
                } else {
                    listOfWords.add(userInput);
                }
        }

    }

    private static void RevertLastWord(LinkedList<String> listOfWords) {
        System.out.printf("Word: [%s] will be deleted from list!%n",listOfWords.getLast());
        String removed = listOfWords.removeLast();
        //listOfWords.remove(listOfWords.indexOf(listOfWords.getLast()));
    }

    private static void PrintArrayReversal(LinkedList<String> listOfWords) {
        for (int i = listOfWords.size()-1; i >= 0 ; i--) {
            try {
                System.out.println(listOfWords.get(i));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Something goes wrong: " + e.getMessage());
            }
        }
    }
}

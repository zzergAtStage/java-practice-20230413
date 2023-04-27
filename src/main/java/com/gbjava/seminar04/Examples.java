package com.gbjava.seminar04;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Examples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<String> linkedList = new LinkedList<>();
        //#6 - filter input
        //SSSS~NNN - true
        //SSS#~NNN - true
        //NNN~NNN - true
        //SSSS~SSS - fase
        //SSS~~NNN
        //^[A-Z]{.}~\d{.} - true$
//        String regex = "^(?i)[A-Z]{3,}~\\d{3,} - true$";
//        boolean matches = Pattern.matches(regex, tmpValue);
//        System.out.println(matches);
        boolean isNotCorrect = true;
        String tmpValue;
        int index = 0;
        int tildaPosition = 0;
        do {
            System.out.print(">_");
            tmpValue = scanner.nextLine();
            if (tmpValue.equals("stop")) {
                break;
            }
            tildaPosition = tmpValue.indexOf('~');
            //check input
            try {
                index = Integer.parseInt(tmpValue.substring(tildaPosition + 1));
            } catch (NumberFormatException e) {
                System.out.println("Wrong input: " + " position: " + e.getMessage());
                isNotCorrect = true;
            }
            //Если введено print~num, выводит строку из позиции num в связном списке
            // и удаляет её из списка
            //print~num

            if ("print".equals(tmpValue.substring(0,tildaPosition))) {
                printAndRemove(linkedList,index);
            } else {
                if (index > linkedList.size()) {
                    insertNulls(linkedList, index);
                }
                linkedList.add(index, tmpValue.substring(0, tildaPosition));
            }
        } while (isNotCorrect);

        printLinkedList(linkedList);
    }

    private static void printAndRemove(LinkedList<String> linkedList, int index) {
        if (index < linkedList.size()){
            System.out.printf("[%n]%s",index,linkedList.get(index));
            linkedList.remove(index);
        }
    }

    private static void insertNulls(LinkedList<String> linkedList, int index) {
        for (int i = linkedList.size(); i < index; i++) {
            linkedList.add(i,null);
        }
    }

    private static void printLinkedList(LinkedList<String> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.printf("[%d]:%s%n",i,linkedList.get(i));

        }
    }
}


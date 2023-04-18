package com.gbjava.seminar02;

import java.io.File;

public class task005 {
    public static void main(String[] args) {
        /*
        * Напишите метод, который вернет содержимое текущей папки в виде массива строк.
            Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
            Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.
*/
        String pathProject = System.getProperty("user.dir");
        StringBuilder dirContent = new StringBuilder();

        File f1 = new File(pathProject);
        for (String object: f1.list()) {
            dirContent.append(object).append(System.lineSeparator());
        }
        System.out.println(dirContent);

    }
}

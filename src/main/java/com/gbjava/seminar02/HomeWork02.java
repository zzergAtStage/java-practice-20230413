package com.gbjava.seminar02;


import org.json.JSONObject;

import java.io.File;
import java.util.Objects;
import java.util.Optional;

public class HomeWork02 {
    public static void main(String[] args) {

        taskHW01();
        taskHW02();
    }

    private static void taskHW01() {
        //String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":null}";
        String jsonString = "{\"name\":null, \"country\":null, \"city\":null, \"age\":null}";

        JSONObject json = new JSONObject(jsonString);
        String tableName = "students";
        //build string of query
        String resultQuery = String.valueOf(UpdateQuery(json, tableName));
        //some output
        System.out.println(resultQuery);
    }

    private static StringBuilder UpdateQuery(JSONObject json, String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("select * from %1$s where", tableName)).append(" 1=1");//add space before conditions!
        for (String key : json.keySet()) {
            String value = json.get(key).toString();
            if ((!Objects.equals(value, "null"))) {
                sb.append(" and ").append(key).append(" = '").append(value).append("'");
                //if code will not be used in querying, we can add .append('\n')
            }
        }
        return sb.append(';');
    }

    private static void taskHW02() {
        String pathProject = System.getProperty("user.dir");
        File f1 = new File(pathProject);
        StringBuilder dirContent = new StringBuilder();
        for (File object: f1.listFiles()) {//I've ignored try catch block, while it is not learned now
            if (object.isFile()){
                Optional<String> extName = GetFileExtension(object.getName());
                dirContent.append(
                        ((!extName.isEmpty()) ? ("Расширение файла: ").concat(extName.get()) : "")
                        ).append(System.lineSeparator());
            }
        }
        System.out.println(dirContent);

    }
    static Optional<String> GetFileExtension(String fileName){
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains(".") && !f.startsWith ("."))//filters map results not nullable
                .map(f -> f.substring(fileName.lastIndexOf(".") + 1));//works as reverse array iteration
    }
}

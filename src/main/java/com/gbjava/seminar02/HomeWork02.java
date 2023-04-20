package com.gbjava.seminar02;


import org.json.JSONObject;

import java.util.Objects;

public class HomeWork02 {
    public static void main(String[] args) {

        taskHW01();

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
            }
            //if code will not be used in querying, we can add .append('\n')
        }
        return sb.append(';');
    }
}

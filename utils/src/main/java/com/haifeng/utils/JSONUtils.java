package com.haifeng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.Set;

public class JSONUtils {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String BLANK_SPACE = "    ";

    /**
     * 读取JSON对象
     *
     * @param path
     */
    public static JSONArray readFileToJSONArray(String path) {
        String jsonString = StringUtils.readFileToString(path);
        JSONArray ja = JSON.parseArray(jsonString);
        return ja;
    }

    /**
     * 写入JSON对象，带格式
     *
     * @param path
     * @param ja
     */
    public static void writeFileToJSONArray(String path, JSONArray ja) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();

        sb.append("[").append(LINE_SEPARATOR);
        System.out.println(ja.toString());
        String stringJSONArray = ja.toString();
        String newStringJSONArray = stringJSONArray.replaceAll(",", "," + LINE_SEPARATOR);
        for (int i = 0; i < ja.size(); i++) {
            String stringJson = ja.getString(i);
            String newStringJson = stringJson.replaceAll(",", "," + LINE_SEPARATOR);
            sb.append(newStringJson);
//            System.out.println(newStringJson);
        }
        sb.append("]");
        StringUtils.writeFileToString(path, newStringJSONArray);
    }

    public static boolean isJSON(String json) {
        if (json.startsWith("{")) {
            return true;
        }
        return false;
    }

}

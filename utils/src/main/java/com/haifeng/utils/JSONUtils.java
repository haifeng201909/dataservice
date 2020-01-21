package com.haifeng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.Set;

public class JSONUtils {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * 读取JSON对象
     *
     * @param path
     */
    public static JSONArray readFileAsJSON(String path) {
        File file = new File(path);
        String jsonString = StringUtils.readFile(path);
        JSONArray ja = JSON.parseArray(jsonString);
        return ja;
    }

    /**
     * 写入JSON对象，带格式
     *
     * @param path
     * @param ja
     */
    public static void writeFileAsJSONArray(String path, JSONArray ja) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(LINE_SEPARATOR);
        for (int i = 0; i < ja.size(); i++) {
            Object obj = ja.get(i);
            JSONObject jsonObject = (JSONObject) obj;
            Set set = jsonObject.keySet();

            Object o = jsonObject.get("damage");
            System.out.println(set);
        }
    }

    public static boolean isJSON(String json) {
        if (json.startsWith("{")) {
            return true;
        }
        return false;
    }

}

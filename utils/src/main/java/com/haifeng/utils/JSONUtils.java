package com.haifeng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.File;

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

    public static void writeFileAsJSONArray(String path, JSONArray ja) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(LINE_SEPARATOR);
        for (int i = 0; i < ja.size(); i++) {
            Object obj = ja.get(i);

        }
    }

}

package com.haifeng.crypto.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtils {

    /**
     * 字符串写入文件
     *
     * @param path
     * @param content
     */
    public static void writeIn(String path, String content) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            OutputStreamWriter out = new OutputStreamWriter(fos);
            out.write(content);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("文件写入异常");
        }
    }
}

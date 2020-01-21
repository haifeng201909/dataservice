package com.haifeng.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class StringUtils {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);

    /**
     * 根据路径读取文件
     * @param path
     * @return
     */
    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        try (InputStream input = new FileInputStream(file)) {
            InputStreamReader reader = new InputStreamReader(input,"GB2312");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(LINE_SEPARATOR);
            }
            return sb.toString();
        } catch (IOException e) {
            LOGGER.info("read file {} failed.", path);
        }

        return null;
    }

    /**
     * 将字符串写入文件
     * @param path
     * @param content
     */
    public static void writeFile(String path,String content){
        File file = new File(path);
        try(OutputStream os = new FileOutputStream(file)){
            OutputStreamWriter writer = new OutputStreamWriter(os,"GB2312");
            writer.write(content);
            writer.flush();
        }catch (IOException e){
            LOGGER.info("write file {} failed.", path);
        }
    }
}

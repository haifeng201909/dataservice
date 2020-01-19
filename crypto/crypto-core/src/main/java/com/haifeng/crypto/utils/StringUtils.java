package com.haifeng.crypto.utils;

import com.haifeng.crypto.code.Hex;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class StringUtils {
    private static final String PATH = "input/input.properties";

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void read() {
        URL url = StringUtils.class.getClassLoader().getResource(PATH);
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(url.getPath())) {
            properties.load(is);
        } catch (IOException e) {

        }
    }

    public static void fileReader() {
        URL url = StringUtils.class.getClassLoader().getResource(PATH);
        String filePath = url.getPath();
        File file = new File(filePath);

    }

    // 读取文件，解决中文乱码问题
    public static void streamReader() {
        String path = StringUtils.class.getClassLoader().getResource(PATH).getPath();
        try (FileInputStream fis = new FileInputStream(path)) {
            InputStreamReader reader = new InputStreamReader(fis, "GBK");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            Hex hex = new Hex();
            // 存放读取到的内容
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                // 边读取边修改
                if (line.startsWith("#")) {
                    stringBuffer.append(line).append(LINE_SEPARATOR);
                } else {
                    String[] str = line.split("=");
                    if (str[0].endsWith("Password")) {
                        char[] chars = hex.encode(str[1].getBytes());
                        String stringChar = String.valueOf(chars);
                        stringBuffer.append(str[0]).append("=").append(stringChar)
                                .append(LINE_SEPARATOR);
                    }else {
                        stringBuffer.append(line).append(LINE_SEPARATOR);
                    }
                }
            }
            System.out.println(stringBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

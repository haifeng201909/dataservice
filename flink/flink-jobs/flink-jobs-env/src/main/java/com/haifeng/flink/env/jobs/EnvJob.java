package com.haifeng.flink.env.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnvJob.class);
    public static void main(String[] args){
//        InputStream p = Properties.class.getClassLoader().getResourceAsStream("env.properties");
        String path = Thread.currentThread().getContextClassLoader().getResource("env.properties").getPath();
        // 日志中不应使用字符串拼接，会浪费性能，额外生成字符串吗？
        LOGGER.info("info:"+path);
        LOGGER.warn("warn:"+path);
        LOGGER.debug("debug:"+path);
    }
}

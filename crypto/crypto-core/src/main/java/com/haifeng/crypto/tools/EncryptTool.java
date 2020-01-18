package com.haifeng.crypto.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

public class EncryptTool {
    private static final Logger LOG = LoggerFactory.getLogger(EncryptTool.class);
    public static void main(String[] args){
        byte[] encrypted = {1,2,3,4};
        String result = new BASE64Encoder().encode(encrypted);
        LOG.info(result);
    }
}

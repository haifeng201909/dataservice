package com.haifeng.crypto.code;

/**
 * Hex编码
 */
public class Hex {
    private final char[] _HEX = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    /**
     * @param bytes
     * @return byte数组
     */
    public char[] encode(byte[] bytes){
        int len = bytes.length;
        char[] result = new char[len * 2];
        int j = 0;
        for(int i = 0; i < len; i++){
            result[j++] = _HEX[(0xF0 & bytes[i]) >>> 4];
            result[j++] = _HEX[0x0F & bytes[i]];
        }
        return result;
    }
}

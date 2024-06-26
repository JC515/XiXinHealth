package com.xixinhealthcheckup.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 */
public class MD5Util {

    /**
     * 生成字符串的MD5密文
     *
     * @param input 输入字符串
     * @return MD5密文
     */
    public static String getMD5(String input, int passwordLength) {
        try {
            // 获取MD5实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 更新摘要
            md.update(input.getBytes());
            // 计算摘要
            byte[] digest = md.digest();
            // 将摘要转换为十六进制字符串
            StringBuilder hashtext = getStringBuilder(passwordLength, digest);
            // 返回MD5密文
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static StringBuilder getStringBuilder(int passwordLength, byte[] digest) {
        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
        // 如果长度小于passwordLength，则在前面补0
        while (hashtext.length() < passwordLength) {
            hashtext.insert(0, "0");
        }
        //如果长度大于passwordLength，则截取前passwordLength位
        if (hashtext.length() > passwordLength) {
            hashtext = new StringBuilder(hashtext.substring(0, passwordLength));
        }
        return hashtext;
    }
}
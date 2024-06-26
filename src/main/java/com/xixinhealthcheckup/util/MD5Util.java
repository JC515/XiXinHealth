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
    public static String getMD5(String input) {
        try {
            // 获取MD5实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 更新摘要
            md.update(input.getBytes());
            // 计算摘要
            byte[] digest = md.digest();
            // 将摘要转换为十六进制字符串
            BigInteger bigInt = new BigInteger(1, digest);
            StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
            // 补齐32位
            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
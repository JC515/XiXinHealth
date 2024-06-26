package com.xixinhealthcheckup.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtil {
    private static final String SECRET_KEY = "secret"; // 设置密钥
    private static final long EXPIRATION_TIME = 60 * 60 * 24; // 设置过期时间为1天

    /**
     * 生成token
     * @param username 用户名
     * @return token
     */
    public static String generateToken(String username) {
        return JWT.create()
                .withSubject(username) // 设置用户名
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间
                .sign(Algorithm.HMAC256(SECRET_KEY)); // 设置加密算法和密钥
    }

    /**
     * 获取用户名
     * @param token token
     * @return 用户名
     */
    public static String getUsername(String token) {
        return JWT.decode(token).getSubject();
    }

    /**
     * 验证token是否有效
     * @param token token
     * @return true or false
     */
    public static boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
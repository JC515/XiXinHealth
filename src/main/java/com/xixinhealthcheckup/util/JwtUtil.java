package com.xixinhealthcheckup.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtil {
    private static final String SECRET_KEY = "secret"; // 设置密钥
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 设置过期时间为1天

    /**
     * 生成token
     * @param username 用户名
     * @return token
     */
    public static String generateToken(String username) {
        // 生成token
        /*        log.info("username: " + username);*/
        return JWT.create()
                .withSubject(username) // 设置用户名
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间
                .sign(Algorithm.HMAC256(SECRET_KEY)); // 设置加密算法和密钥
    }

    /**
     * 获取用户名
     *
     * @param token token
     * @return 用户名
     */
    public static String getUsername(String token) {
        // 解密token获取用户名
        /*        log.info("token: " + token);*/
        try {
            String username = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token).getSubject();
            /*            log.info("value: " + username);*/
            return username;
        } catch (JWTVerificationException e) {
            log.error("JWT verification failed: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 验证token是否有效
     * @param token token
     * @throws JWTVerificationException 如果token无效，则抛出异常
     */
    public static void validateToken(String token) throws JWTVerificationException {
        JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }

}
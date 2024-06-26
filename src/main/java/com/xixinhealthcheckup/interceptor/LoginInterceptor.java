package com.xixinhealthcheckup.interceptor;

import com.xixinhealthcheckup.util.JwtUtil;
import com.xixinhealthcheckup.util.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");// 获取请求头中的Authorization字段
        // 校验token
        try {
            String username = JwtUtil.getUsername(token);
            // 将username存入ThreadLocalUtil
            ThreadLocalUtil.set(username);
            // 校验成功，放行
            return true;
        } catch (Exception e) {
            // 校验失败，返回401
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除ThreadLocalUtil中的username
        ThreadLocalUtil.remove();
    }
}


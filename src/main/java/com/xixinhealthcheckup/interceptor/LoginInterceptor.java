package com.xixinhealthcheckup.interceptor;

import com.xixinhealthcheckup.util.JwtUtil;
import com.xixinhealthcheckup.util.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

/**
 * 登录拦截器
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<String> token = Optional.ofNullable(request.getHeader("Authorization"));
        if (token.isPresent()) {
            try {
                JwtUtil.validateToken(token.get());
                String username = JwtUtil.getUsername(token.get());
                ThreadLocalUtil.set(username);
                return true;
            } catch (Exception e) {
                response.setStatus(401);
                response.getWriter().write("Token invalid");
                return false;
            }
        } else {
            log.info("No token provided");
            response.setStatus(401);
            response.getWriter().write("Unauthorized");
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ThreadLocalUtil.remove();
    }
}
/*
package com.xixinhealthcheckup.config;

import com.xixinhealthcheckup.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

*/
/**
 * web配置类
 *//*

@Configuration
public class WebConfig implements WebMvcConfigurer {
    final
    LoginInterceptor loginInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器, 排除不需要拦截的路径
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/users/getUsersByUserIdByPass", "/users/getUsersById", "/users/saveUsers", "/doctor/login","/doctor/register");
    }
}*/

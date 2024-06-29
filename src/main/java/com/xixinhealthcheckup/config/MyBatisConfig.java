package com.xixinhealthcheckup.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfig {

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql"); // 配置数据库方言
        properties.setProperty("reasonable", "true"); // 开启合理化参数
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
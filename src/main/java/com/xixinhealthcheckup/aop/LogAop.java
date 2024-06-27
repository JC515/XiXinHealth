package com.xixinhealthcheckup.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日志切面
 */
@Aspect
@Component
@Slf4j
public class LogAop {
    @Before("execution(* com.xixinhealthcheckup.controller..*(..))") // 定义切点
    public void logBefore(JoinPoint joinPoint) {
        // 获取当前日期
        String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        // 获取方法签名
        String methodName = joinPoint.getSignature().getName();
        // 记录日志
        log.info("{} - 调用方法: {}", date, methodName);
    }
}
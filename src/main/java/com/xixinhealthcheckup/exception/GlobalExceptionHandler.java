package com.xixinhealthcheckup.exception;

import com.xixinhealthcheckup.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice // 此注解用于处理全局异常
public class GlobalExceptionHandler {
    /**
     * 处理所有异常
     * @param e 异常
     * @return 出错信息
     */
    @ExceptionHandler(Exception.class) // 捕获所有异常
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}

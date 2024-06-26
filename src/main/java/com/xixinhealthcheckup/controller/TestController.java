package com.xixinhealthcheckup.controller;

import com.xixinhealthcheckup.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试hello world接口
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello, World!");
    }
}

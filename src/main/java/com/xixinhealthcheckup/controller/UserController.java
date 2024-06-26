package com.xixinhealthcheckup.controller;

import com.xixinhealthcheckup.pojo.Result;
import com.xixinhealthcheckup.pojo.User;
import com.xixinhealthcheckup.service.UserServiceImpl;
import com.xixinhealthcheckup.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping("/users")
@CrossOrigin //解决跨域问题
public class UserController {
    final
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsersByUserIdByPass")
    public Result getUser(@RequestParam String userId, @RequestParam String password) {
        //查询是否存在该用户
        User user = userService.getUserByUseridByPass(userId, password);
        if (user == null) {
            return Result.error("用户不存在或密码错误");
        }
        //生成token
        return Result.success(JwtUtil.generateToken(user.getUserId()));
    }//已通过测试

    /**
     * 根据手机号码查询用户是否存在
     * @param id 手机号码
     * @return 如果手机号已存在，返回失败，否则返回成功
     */
    @GetMapping("/getUsersById")
    public Result getUsersById(@RequestParam String id) {
        //查询是否存在该用户
        User user = userService.getUserById(id);
        if (user == null) {
            return Result.success();
        }
        return Result.error("用户已存在(手机号已注册)");
    }//已通过测试

    @PostMapping("/saveUsers")
    public Result saveUsers(@RequestBody User user) {
        //保存用户信息
        userService.saveUser(user);
        return Result.success();
    }//已通过测试
}

package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.mapper.UserMapper;
import com.xixinhealthcheckup.pojo.User;
import com.xixinhealthcheckup.util.MD5Util;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectUsersById(id);
    }

    @Override
    public User getUserByUseridByPass(String id, String password) {
        //使用MD5加密密码
        password = MD5Util.getMD5(password, User.PASSWORD_MAX_LENGTH);
        return userMapper.selectUserByUseridByPass(id, password);
    }

    @Override
    public void saveUser(User user) {
        //使用MD5加密密码
        user.setPassword(MD5Util.getMD5(user.getPassword(), User.PASSWORD_MAX_LENGTH));
        userMapper.insertUser(user);
    }
}

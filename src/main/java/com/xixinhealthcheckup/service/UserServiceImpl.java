package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.mapper.UserMapper;
import com.xixinhealthcheckup.pojo.User;
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
        return userMapper.selectUserByUseridByPass(id, password);
    }
}

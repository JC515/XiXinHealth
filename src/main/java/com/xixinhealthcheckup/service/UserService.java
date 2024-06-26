package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.pojo.User;

public interface UserService {
    User getUserById(String id);

    User getUserByUseridByPass(String id, String password);

    void saveUser(User user);
}

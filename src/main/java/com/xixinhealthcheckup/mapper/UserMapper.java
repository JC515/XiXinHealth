package com.xixinhealthcheckup.mapper;

import com.xixinhealthcheckup.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE user_id = #{userid} AND password = #{password}")
    User selectUserByUseridByPass(String userid, String password);

    @Select("SELECT * FROM users WHERE user_id = #{userid}")
    User selectUsersById(String userid);
}

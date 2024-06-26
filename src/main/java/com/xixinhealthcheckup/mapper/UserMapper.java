package com.xixinhealthcheckup.mapper;

import com.xixinhealthcheckup.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where user_id = #{userid} AND password = #{password}")
    User selectUserByUseridByPass(String userid, String password);

    @Select("select * from users where user_id = #{userid}")
    User selectUsersById(String userid);

    @Insert("insert into users(user_id,password, real_name, sex, identity_card, birthday, user_type) values(#{userId}, #{password}, #{realName}, #{sex}, #{identityCard}, #{birthday}, #{userType})")
    void insertUser(User user);
}

package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;//用户手机号（登录用）
    private String password;//密码（登录用）
    private String realName;//真实姓名
    private Integer sex;//性别（男：1，女：0）
    private String identityCard;//身份证号
    private Date birthday;//出生日期
    private Integer userType;//用户类型（1：普通用户；2：系统内部员工；3：其他）
}
package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 医生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private Integer docId; // 医生编号(自增主键)
    private String docCode; // 医生编号（登录用）
    private String realName; // 真实姓名
    private String password; // 密码（登录用）
    private Integer sex; // 性别（男：1，女：0）
    private Integer deptNo; // 所属科室（1：检验科；2：内科；3：外科）
}
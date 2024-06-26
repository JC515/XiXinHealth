package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 医院实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private Integer hpId; // 医院编号(自增主键)
    private String name; // 医院名称
    private String picture; // 医院图片
    private String telephone; // 医院电话
    private String address; // 医院地址
    private String businessHours; // 营业时间
    private String deadline; // 采血截止时间
    private String rule; // 预约人数规则
    private Integer state; // 医院状态，1-正常，2-其他
}
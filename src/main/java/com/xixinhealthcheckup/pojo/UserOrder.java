package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrder {
    private Integer orderId; // 订单id
    private String phone; // 手机号
    private String realName; // 姓名
    private String sex; // 性别
    private String type; // 检查类型
    private String hospitalName; // 医院名称
    private String orderDate; // 预约日期(yyyy-MM-dd)
    private Integer isArchived; // 是否归档(1:未归档,2:已归档)
}

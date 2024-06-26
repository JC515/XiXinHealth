package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 体检预约订单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId; // 订单编号(自增主键)
    private Date orderDate; // 预约日期
    private String userId; // 客户编号，外键
    private Integer hpId; // 所属医院编号，外键
    private Integer smId; // 所属套餐编号，外键
    private Integer state; // 订单状态（1：未归档；2：已归档）
}
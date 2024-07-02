package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*create table sheng_gong_neng
(
    sheng_id int primary key auto_increment,
    arg1     varchar(30) not null comment '血清肌酐',
    arg2     varchar(30) not null comment '血尿素氮',
    order_id int         not null comment '订单id'
)*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sheng {
    private int shengId;
    private String arg1;
    private String arg2;
    private int orderId;
}

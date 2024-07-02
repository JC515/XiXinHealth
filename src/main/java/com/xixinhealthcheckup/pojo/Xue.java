package com.xixinhealthcheckup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*create table xue_chang_gui
(
    xue_id   int primary key auto_increment,
    arg1     varchar(30) not null comment '血小板计数',
    arg2     varchar(30) not null comment '血红细胞计数',
    order_id int         not null comment '订单id'
);*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xue {
    private int xueId;
    private String arg1;
    private String arg2;
    private int orderId;
}

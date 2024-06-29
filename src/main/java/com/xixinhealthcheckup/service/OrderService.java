package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.pojo.Order;
import com.xixinhealthcheckup.pojo.UserOrder;

import java.util.List;

public interface OrderService {
    Order getOrdersByUserId(String userId);

    void saveOrder(Order order);

    Order getOrdersById(Integer orderId);

    void deleteOrdersById(Integer orderId);

    List<UserOrder> getOrderList(String pageNum, String pageSize);
}

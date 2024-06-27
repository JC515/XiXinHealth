package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.pojo.Order;

public interface OrderService {
    Order getOrdersByUserId(String userId);

    void saveOrder(Order order);

    Order getOrdersById(Integer orderId);
}

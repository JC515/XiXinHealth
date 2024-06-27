package com.xixinhealthcheckup.service;

import com.xixinhealthcheckup.mapper.OrderMapper;
import com.xixinhealthcheckup.pojo.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    final
    OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Order getOrdersByUserId(String userId) {
        //通过手机号码查找未归档的订单
        return orderMapper.selectByUserIdAndState(Order.UNARCHIVED, userId);
    }

    @Override
    public void saveOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public Order getOrdersById(Integer orderId) {
        return orderMapper.selectByOrderId(orderId);
    }
}

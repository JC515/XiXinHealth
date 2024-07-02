package com.xixinhealthcheckup.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xixinhealthcheckup.mapper.OrderMapper;
import com.xixinhealthcheckup.pojo.Order;
import com.xixinhealthcheckup.pojo.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteOrdersById(Integer orderId) {
        orderMapper.deleteByOrderId(orderId);
    }

    @Override
    public List<UserOrder> getOrderList(String pageNum, String pageSize) {
        // 开启分页
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        // 查询所有用户
        List<UserOrder> users = orderMapper.selectAll();
        // 包装 PageInfo 对象
        PageInfo<UserOrder> pageInfo = new PageInfo<>(users);
        // 返回分页数据
        return pageInfo.getList();
    }

    public Integer getTotalOrderCount() {
        return orderMapper.selectTotalCount();
    }

    public List<UserOrder> getOrderListByCondition(UserOrder userOrder) {
        return orderMapper.selectByCondition(userOrder);
    }

    public UserOrder getUserOrderByOrderId(Integer orderId) {
        return orderMapper.selectUserOrderByOrderId(orderId);
    }

    public UserOrder getUserOrderByUserId(String userId) {
        return orderMapper.selectUserOrderByUserId(userId);
    }

    public void updateUserOrderStatus(String orderId) {
        orderMapper.updateUserOrderStatus(orderId);
    }

    public List<UserOrder> getUserOrderListByUserId(String userId) {
        return orderMapper.selectUserOrderListByUserId(userId);
    }
}

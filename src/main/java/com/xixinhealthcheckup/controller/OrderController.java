package com.xixinhealthcheckup.controller;

import com.xixinhealthcheckup.pojo.Order;
import com.xixinhealthcheckup.pojo.Result;
import com.xixinhealthcheckup.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    final
    OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    /**
     * 根据电话号码查询是否预约过（凡是有未归档的预约记录的用户，不能再次预约）
     * @param userId 电话号码
     * @return 是否预约过
     */
    @GetMapping("/getOrdersByUserId")
    public Result getOrdersByUserId(@RequestParam String userId) {
        Order order = new Order();
        order = orderService.getOrdersByUserId(userId);
        if (order != null) {
            return Result.error("该手机号已预约，存在未归档的预约记录");
        } else {
            return Result.success();
        }
    }

    /**
     * 保存预约信息
     * @param order 预约信息
     * @return 保存结果
     */
    @PostMapping("/saveOrders")
    public Result saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return Result.success();
    }

    @GetMapping("/getOrdersById")
    public Result<Order> getOrdersById(@RequestParam Integer orderId) {
        Order order = orderService.getOrdersById(orderId);
        if (order != null) {
            return Result.success(order);
        } else {
            return Result.error("预约记录不存在");
        }
    }
}

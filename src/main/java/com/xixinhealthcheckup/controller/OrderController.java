package com.xixinhealthcheckup.controller;

import com.xixinhealthcheckup.pojo.Order;
import com.xixinhealthcheckup.pojo.Result;
import com.xixinhealthcheckup.pojo.UserOrder;
import com.xixinhealthcheckup.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
@Slf4j
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

    /**
     * 根据预约id查询预约信息
     * @param orderId 预约id
     * @return 预约信息
     */
    @GetMapping("/getOrdersById")
    public Result<Order> getOrdersById(@RequestParam Integer orderId) {
        Order order = orderService.getOrdersById(orderId);
        if (order != null) {
            return Result.success(order);
        } else {
            return Result.error("预约记录不存在");
        }
    }

    /**
     * 根据预约id删除预约信息
     * @param orderId 预约id
     * @return 删除结果
     */
    @DeleteMapping("/removeOrders")
    public Result deleteOrdersById(@RequestParam Integer orderId) {
        orderService.deleteOrdersById(orderId);
        return Result.success();
    }

    /**
     * 获取预约列表
     * @param pageSize 页大小
     * @param pageNum 页码
     * @return 预约列表
     */
    @GetMapping("/orderList")
    public Result<List<UserOrder>> getOrderList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "10") String pageSize) {
        List<UserOrder> orderList = orderService.getOrderList(pageNum, pageSize);
        return Result.success(orderList);
    }

    /**
     * 获取总的预约数量
     * @return 总的预约数量
     */
    @GetMapping("/totalOrderCount")
    public Result<Integer> getTotalOrderCount() {
        Integer count = orderService.getTotalOrderCount();
        return Result.success(count);
    }

    /**
     * 根据条件查询预约列表
     * @param userOrder 查询条件
     * @return 预约列表
     */
    @PostMapping("/orderListByCondition")
    public Result<List<UserOrder>> getOrderListByCondition(@RequestBody UserOrder userOrder) {
        log.info("userOrder: {}", userOrder);
        List<UserOrder> orderList = orderService.getOrderListByCondition(userOrder);
        log.info("orderList: {}", orderList);
        return Result.success(orderList);
    }

    @GetMapping("/getUserOrderByOrderId")
    public Result<UserOrder> getUserOrderByOrderId(@RequestParam Integer orderId) {
        UserOrder userOrder = orderService.getUserOrderByOrderId(orderId);
        return Result.success(userOrder);
    }
}

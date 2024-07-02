package com.xixinhealthcheckup.mapper;

import com.xixinhealthcheckup.pojo.Order;
import com.xixinhealthcheckup.pojo.UserOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from  order_user")
    List<UserOrder> selectAll();

    /**
     * 通过用户id和订单状态查询订单
     * @param state 订单状态（1：未归档；2：已归档）
     * @param userId 用户id
     * @return 订单
     */
    @Select("select * from orders where user_id = #{userId} and state = #{state}")
    Order selectByUserIdAndState(Integer state, String userId);

    /**
     * 插入订单
     * @param order 订单
     */
    @Insert("insert into orders(order_date, user_id, hp_id, sm_id, state) values (#{orderDate}, #{userId}, #{hpId}, #{smId}, 1)")
    void insert(Order order);

    /**
     * 通过用户id查询订单
     * @param userId 用户id
     * @return 订单
     */
    @Select("select * from orders where user_id = #{userId}")
    Order selectByUserId(String userId);

    /**
     * 通过订单id删除订单
     * @param orderId 订单id
     */
    @Delete("delete from orders where order_id = #{orderId}")
    void deleteByOrderId(Integer orderId);

    /**
     * 通过订单id查询订单
     * @param orderId 订单id
     * @return 订单
     */
    @Select("select * from orders where order_id = #{orderId}")
    Order selectByOrderId(Integer orderId);

    @Select("select count(*) from order_user")
    Integer selectTotalCount();

    List<UserOrder> selectByCondition(UserOrder userOrder);

    @Select("select * from order_user where order_id = #{orderId}")
    UserOrder selectUserOrderByOrderId(Integer orderId);

    @Select("select * from order_user where phone = #{userId} order by order_date desc limit 1 ")
    UserOrder selectUserOrderByUserId(String userId);

    @Update("update orders set state = 2 where order_id = #{orderId}")
    void updateUserOrderStatus(String orderId);

    @Select("select * from order_user where phone = #{userId} order by order_date desc")
    List<UserOrder> selectUserOrderListByUserId(String userId);
}

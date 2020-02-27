package com.neuedu.service;

import com.neuedu.common.ServerResponse;

import java.sql.SQLException;

public interface IOrderService {


    /**
     * 创建订单
     * */

    ServerResponse createOrder(Integer userId,Integer shippingId);

    /**
     *
     * 取消订单
     * */
    ServerResponse cancelOrder(Long orderNo);

    /**
     * 根据订单号查询订单信息
     * */
    ServerResponse findOrderByOrderNo(Long orderNo);
}

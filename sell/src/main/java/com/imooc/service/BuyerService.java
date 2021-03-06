package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 买家
 * Created by 廖师兄
 * 2017-06-22 00:11
 */
//创建一个单独的service用微信号和订单号结合查订单取消订单更安全
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}

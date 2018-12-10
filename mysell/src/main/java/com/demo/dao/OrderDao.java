package com.demo.dao;

import com.demo.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, String> {
	//按照买家openid来查订单，用分页，避免查出来买家所有订单数据量太大
	Page<Order> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}

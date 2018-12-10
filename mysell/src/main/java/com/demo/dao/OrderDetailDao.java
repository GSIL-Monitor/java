package com.demo.dao;

import com.demo.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
	List<OrderDetail> findByOrderId(String orderId);

}

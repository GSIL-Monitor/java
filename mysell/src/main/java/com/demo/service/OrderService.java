package com.demo.service;

import com.demo.dto.OrderDTO;
import com.demo.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
	OrderDTO createOrder(OrderDTO orderDTO);

	OrderDTO findOne(String orderId);

	Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

	OrderDTO cancelOrder(OrderDTO orderDTO);

	OrderDTO finishOrder(OrderDTO orderDTO);

	OrderDTO payOrder(OrderDTO orderDTO);


}



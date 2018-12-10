package com.demo.controller;

import com.demo.dto.OrderDTO;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/create")
	public void create(@RequestParam("orderId") String order,
					   @RequestParam("returnUrl") String returnUrl) {

		OrderDTO orderDTO = orderService.findOne(order);
		if (orderDTO == null) {
			//throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
	}
}

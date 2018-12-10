package com.demo.service.imp;

import com.demo.dto.OrderDTO;
import com.demo.service.PayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;

public class PayServiceImpl implements PayService {

	@Override
	public void create(OrderDTO orderDTO) {
		BestPayServiceImpl bestPayService = new BestPayServiceImpl();
	}
}

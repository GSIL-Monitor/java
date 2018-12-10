package com.demo.service.imp;

import com.demo.dao.OrderDao;
import com.demo.dao.OrderDetailDao;
import com.demo.dto.CartDTO;
import com.demo.dto.OrderDTO;
import com.demo.entity.Order;
import com.demo.entity.OrderDetail;
import com.demo.entity.ProductInfo;
import com.demo.enums.OrderStatusEnum;
import com.demo.enums.PayStatusEnum;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.service.OrderService;
import com.demo.service.ProductService;
import com.demo.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {



	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	@Transactional
	public OrderDTO createOrder(OrderDTO orderDTO) {
		String orderId = KeyUtil.genUniqueKey();
		//总价初始是0
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

		List<CartDTO> cartDTOList = new ArrayList<>();

		//查询商品 数量 价格
		for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
			ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}

			//计算订单总价
			orderAmount= productInfo.getProductPrice()
					.multiply(new BigDecimal(orderDetail.getProductQuantity()));

			//订单详情入库OrderDetail
			orderDetail.setDetailId(KeyUtil.genUniqueKey());
			orderDetail.setOrderId(orderId);
			BeanUtils.copyProperties(productInfo, orderDetail);
			orderDetailDao.save(orderDetail);

			//扣库存
			CartDTO cartDTO = new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity());
			cartDTOList.add(cartDTO);

		}

		//Order入库
		Order order = new Order();
		//拷贝会覆盖后面对象里的信息，null值也会覆盖
		BeanUtils.copyProperties(orderDTO, order);
		order.setOrderId(orderId);
		order.setOrderAmount(orderAmount);
		//因为会被上面对象覆盖，所以还要传入一次值
		order.setOrderStatus(OrderStatusEnum.NEW.getCode());
		order.setPayStatus(PayStatusEnum.Pending.getCode());
		orderDao.save(order);

		//扣库存
		productService.decreaseStock(cartDTOList);

		return orderDTO;

	}

	@Override
	public OrderDTO findOne(String orderId) {
		return null;
	}

	@Override
	public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
		return null;
	}

	@Override
	public OrderDTO cancelOrder(OrderDTO orderDTO) {
		return null;
	}

	@Override
	public OrderDTO finishOrder(OrderDTO orderDTO) {
		return null;
	}

	@Override
	public OrderDTO payOrder(OrderDTO orderDTO) {
		return null;
	}
}

package com.demo.dto;

import com.demo.entity.OrderDetail;
import com.demo.enums.OrderStatusEnum;
import com.demo.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {


	private String orderId;

	private String buyerName;

	private String buyerPhone;

	private String buyerAddress;

	private String buyerOpenid;

	private Integer orderAmount;

	private Integer orderStatus;

	private Integer payStatus;

	private Date createTime;

	private Date updateTime;

	List<OrderDetail> orderDetailList;
}

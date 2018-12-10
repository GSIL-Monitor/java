package com.demo.entity;

import com.demo.enums.OrderStatusEnum;
import com.demo.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@DynamicUpdate
public class Order {

	@Id
	private String orderId;

	private String buyerName;

	private String buyerPhone;

	private String buyerAddress;

	private String buyerOpenid;

	private BigDecimal orderAmount;

	private Integer orderStatus = OrderStatusEnum.NEW.getCode();

	private Integer payStatus = PayStatusEnum.Pending.getCode();

	private Date createTime;

	private Date updateTime;

}

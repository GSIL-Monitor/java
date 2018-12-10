package com.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXIST(10, "product not exist"),
	PRODUCT_STOCK_ERROR(11, "stock not right"),
	WECHAT_MP_ERROR(20, "微信公众账号方面错误"),
	;
	private Integer code;

	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}

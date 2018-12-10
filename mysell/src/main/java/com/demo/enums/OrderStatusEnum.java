package com.demo.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
	NEW(0,"new order"),
	FINISHED(1, "finished order"),
	CANCELED(2, "Canceled order"),
	;

	private Integer code;

	private String msg;

	OrderStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}



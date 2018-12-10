package com.demo.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
	Pending(0,"pay pending"),
	Success(1, "pay success"),
	;

	private Integer code;

	private String msg;

	PayStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}

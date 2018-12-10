package com.demo.View;

import lombok.Data;

@Data
public class ResultView<T> {

	private Integer code;

	private String msg;

	private T data;
}

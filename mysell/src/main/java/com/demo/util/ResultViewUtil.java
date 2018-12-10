package com.demo.util;

import com.demo.View.ResultView;

public class ResultViewUtil {
	public static ResultView success(Object object) {
		ResultView resultView = new ResultView();
		resultView.setCode(0);
		resultView.setData(object);
		resultView.setMsg("success");
		return resultView;
	}

	public static ResultView success() {
		return success(null);
	}

	public static ResultView error(Integer code, String msg) {
		ResultView resultView = new ResultView();
		resultView.setCode(code);
		resultView.setMsg(msg);
		return resultView;
	}

}

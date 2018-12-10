package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class Hello {

	@ResponseBody
	@RequestMapping(value = "/hello")
	public String hello() {
		//返回Hello SpringBoot!
		return "Hello SpringBoot!";
	}


	@RequestMapping(value = "/success")
	public String success(Map<String, Object> map) {
		//html里写 <div th:text="${hello}">hi</div>   thymeleaf将会输出jober！ 并且会覆盖hi
		map.put("hello", "jober!");
		return "success";
	}
}

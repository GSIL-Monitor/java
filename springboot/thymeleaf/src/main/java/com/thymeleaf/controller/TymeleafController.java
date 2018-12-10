package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 *
 */
@Controller
public class TymeleafController {


	//返回内容"hello"
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}

	//返回到success.html网页
	@RequestMapping("/success")
	public String success(Map<String ,Object> map) {
		map.put("hello", "<h1>good</h1>");
		map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
		return "success";
	}



}

package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	/**
	 * 把localhost默认index页面(public文件夹下的index)映射为templates文件夹下的index页面
	 **/
	// "/" 代表当前项目即templates文件夹  "/index.html"代表当前项目下的index.html   {此为处理多请求}
//	@RequestMapping({"/", "/index.html"})
//	public String index() {
//		return "index";
//	}

}
package com.handler;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * 
 * @author xiangze
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(value = Exception.class) //定义抛出的方法类别，如,果抛出的异常符合则在下面方法中处理
	@ResponseBody
	public Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		modelMap.put("success", false);
		modelMap.put("errrMsg", e.getMessage());
		logger.error(e.getMessage(), e);
		return modelMap;
	}

}
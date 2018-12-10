package com.servlet.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 */
public class MyListener implements ServletContextListener {

	//Servlet context对象初始化 web项目启动
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("context Initialized ... web应用启动");
	}

	//销毁context web项目停止
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("context Destroyed...当前web项目销毁");
	}
}

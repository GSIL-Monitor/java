package com.servlet.config;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义Filter
 */
public class MyFilter implements Filter {

	//Filter初始化
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	//Filter过滤
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("MyFilter process...");
		//把请求放行出去
		filterChain.doFilter(servletRequest,servletResponse);
	}


	//Filter销毁
	@Override
	public void destroy() {

	}
}

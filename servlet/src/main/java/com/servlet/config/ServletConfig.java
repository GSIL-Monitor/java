package com.servlet.config;

import com.All.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 *
 */
@Configuration
public class ServletConfig {

	/**
	 * 配置嵌入式Servlet容器
	 */
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			//定制嵌入式的Servlet容器相关规则
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setPort(8083);
			}
		};
	}



	/**
	 * 注册三大组件
	 */

	/**
	 * ServletRegistrationBean
	 * 参数传入我们自己的MyServlet    映射"/myServlet" 这个路径
	 */
	public ServletRegistrationBean myServlet() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
		return registrationBean;
	}


	/**
	 * FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean myFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		//设置我们的MyFilter
		registrationBean.setFilter(new MyFilter());
		//设置拦截的请求 路径
		registrationBean.setUrlPatterns(Arrays.asList("/hello"));
		return registrationBean;
	}


	/**
	 * ServletListenerRegistrationBean
	 */

	@Bean
	public ServletListenerRegistrationBean myListener(){
		ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
		return registrationBean;
	}




}

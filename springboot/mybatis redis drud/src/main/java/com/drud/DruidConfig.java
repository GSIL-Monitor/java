package com.drud;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

	//自己创建一个数据源

	@ConfigurationProperties(prefix = "spring.datasource") //绑定yml里配置的属性到下面的Bean
	@Bean
	public DataSource druid() {
		return new DruidDataSource();
	}

	/*配置Druid的监控，一个Servlet一个Filter 可访问http://localhost:8080/druid 登陆到后台*/

	//1.配置一个管理后台的Servlet     ServletRegistrationBean用来注册servlet
	//StatViewServlet()  为druid的servlet    参数"/druid/*"  为处理druid下的所有请求
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		//再设置一些初始化参数，要查看都有哪些参数command点击StatViewServlet() 然后点击extends的 ResourceServlet
		Map<String, String> initParams = new HashMap<>();
		//把初始化参数放进map里
		initParams.put("loginUsername", "admin"); //登陆后台用的用户名
		initParams.put("loginPassword", "9025476");
		initParams.put("allow", "");  //默认就是允许所有访问，可以写localhost只允许localhost访问
		initParams.put("deny", "192.168.15.21"); //拒绝这个ip地址访问
		//把map传进去
		bean.setInitParameters(initParams);
		return bean;
	}

	//2.配置一个web监控的Filter   FilterRegistrationBean用来注册filter
	//WebStatFilter() 为druid的filter
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		//要注册哪个filter就把filter设置进去，这里用WebStatFilter()
		bean.setFilter(new WebStatFilter());
		//设置初始化参数
		Map<String, String> initParams = new HashMap<>();
		//exclusions为排除拦截的请求，js，css静态文件以及druid下的所有请求都不拦截
		initParams.put("exclusions", "*.js,*.css,/druid/*");
		//把map传进去
		bean.setInitParameters(initParams);
		//设置拦截请求 参数为collection类型  "/*"为拦截所有请求
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}

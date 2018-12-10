package com.originalcache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class OriginalCacheConfig {

	//自己定义缓存里key的生成策略  之后把"myKeyGenerator"放到@Cacheable的参数里keyGenerator="myKeyGenerator"
	@Bean("myKeyGenerator")
	public KeyGenerator keyGenerator(){
		return new KeyGenerator(){

			@Override
			public Object generate(Object target, Method method, Object... params) {
				return method.getName()+"["+ Arrays.asList(params).toString()+"]";
			}
		};
	}
}

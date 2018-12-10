package com.redis;

import com.entity.Department;
import com.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

	/*-------------------Redis Database Config-------------------------*/
	//自己创建一个redis json序列化器  从源代码中复制过来再修改
	@Bean
	public RedisTemplate<Object, Employee> empRedisTemplate(
			RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Employee> template = new RedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);

		//new一个json的序列化器
		Jackson2JsonRedisSerializer<Employee> seri = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
		//让Template使用上面的序列化器
		template.setDefaultSerializer(seri);
		return template;
	}

	//同上
	@Bean
	public RedisTemplate<Object, Department> deptRedisTemplate(
			RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Department> ser = new Jackson2JsonRedisSerializer<Department>(Department.class);
		template.setDefaultSerializer(ser);
		return template;
	}



	/*-------------------Redis Cache Config-------------------------*/
	//自己创建一个Redis缓存管理器 操作Employee的
	//@Primary为将某个缓存管理器作为默认的（多个的情况下） 否则会报错
	//应该把RedisCacheConfiguration里的RedisTemplate<Object, Object>作为默认的
	@Primary
	@Bean
	public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
		RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
		//key多了一个前缀

		//使用前缀，默认会将CacheName作为key的前缀
		cacheManager.setUsePrefix(true);

		return cacheManager;
	}

	//同上
	@Bean
	public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
		RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
		cacheManager.setUsePrefix(true);
		return cacheManager;
	}

}
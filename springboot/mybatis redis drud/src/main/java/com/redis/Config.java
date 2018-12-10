package com.redis;

import com.entity.Car;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 *
 */
public class Config {

	public RedisTemplate<Object, Car> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		RedisTemplate<Object, Car> template = new RedisTemplate();
		Jackson2JsonRedisSerializer<Car> seri = new Jackson2JsonRedisSerializer<>(Car.class);
		template.setDefaultSerializer(seri);
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}

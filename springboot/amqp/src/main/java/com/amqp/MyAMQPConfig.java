package com.amqp;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 	消息序列化和反序列化机制
 *	自己写一个把数据转换为Json的Converter，会自动替换掉原有的simpleConverter
 *	这样发送到RabbitMQ的数据就是Json格式的
 */
@Configuration
public class MyAMQPConfig {
	@Bean
	public MessageConverter messageConverter(){
		return new Jackson2JsonMessageConverter();
	}
}

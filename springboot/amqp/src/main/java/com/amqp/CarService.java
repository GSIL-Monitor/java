package com.amqp;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 */

@Service
public class CarService {

	/**
	 * @RabbitListener为监听消息队列的内容
	 * 要让@RabbitListener注解起作用，需要在Application类里添加注解@EnableRabbit开启基于注解的RabbitMQ
	 * 方法1. 监听atguigu.news这个消息队列，只要这个消息队列有内容进来，这个方法就会被调用 直接将消息反序列化成nook对象
	 */
	@RabbitListener(queues = "atguigu.news")
	public void receive(Car car) {
		System.out.println("收到消息：" + car);
	}

	/**
	 * 方法2. 用Message，这种方法可以得到消息头
	 */
	@RabbitListener(queues = "atguigu")
	public void receive02(Message message) {
		//得到消息内容 对象
		System.out.println(message.getBody());
		//得到消息头信息
		System.out.println(message.getMessageProperties());
	}



}

package com;

import com.amqp.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMQ test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AMQPTest {

	@Autowired
	RabbitTemplate rabbitTemplate;

	//注入AmqpAdmin ： RabbitMQ系统管理功能组件
	@Autowired
	AmqpAdmin amqpAdmin;


	/**
	 * 利用AmqpAdmin 创建Exchange，Queue以及绑定。这样就不用去网页面板去创建了
	 */
	@Test
	public void createExchange(){

		//创建Exchange
		//amqpAdmin.declareExchange(new DirectExchange("StringTest2.exchange"));
		//System.out.println("创建完成");

		//创建Queue
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

		//创建绑定规则
		//amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));

		//删除...
		//amqpAdmin.delete...
	}

	/**
	 * direct单播（点对点）模式 发送消息
	 */
	@Test
	public void send() {
		/**
		 * 把消息发布到队列
		 * 		方法1.   Message需要自己构造一个;定义消息体内容和消息头
		 * 				rabbitTemplate.send(exchage,routeKey,message);
		 *
		 * 		方法2. 	object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
		 * 				rabbitTemplate.convertAndSend(exchage,routeKey,object);
		 * 如果想要发送接收消息为Json格式，需要到config里写一个Json的Converter替换掉原有的
		 */

		/**
		 * 方法2 实现
		 */
		//定义发送的内容
		Map<String,Object> map = new HashMap<>();
		map.put("msg","这是第一个消息");
		//Arrays.asList是将数组转化为list
		map.put("data", Arrays.asList("helloworld",123,true));
		//对象被默认序列化以后发送出去
		rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

	}

	/**
	 * 接受消息数据
	 */
	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("gulixueyuan.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}


	/**
	 * fanout广播模式 发送消息  不用写路由件routingKey
	 */
	@Test
	public void sendMsg(){
		rabbitTemplate.convertAndSend("exchange.fanout","",new Car("my car", "benz"));
	}
}
package com;

import com.entity.Employee;
import com.mybatis.mapper.EmployeeMapper;
import com.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisRedisTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	EmployeeMapper employeeMapper;

	//K-V都是字符串 操作字符串的
	@Autowired
	StringRedisTemplate stringRedisTemplate;


	//K-V都是对象 操作对象的
	@Autowired
	RedisTemplate redisTemplate;

	//使用自己定义的empRedisTemplate
	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;



	@Test
	public void contextLoads() throws SQLException {

		//测试数据源
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

	@Test
	public void cacheTest() {

		Employee empById = employeeMapper.getEmpById(1);
		System.out.println(empById);
	}



	/*-----------------------Redis Database Test---------------------------------------*/
	/**
	 * Redis常见的五大数据类型
	 *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
	 *   stringRedisTemplate.opsForValue()[String（字符串）]
	 *   stringRedisTemplate.opsForList()[List（列表）]
	 *   stringRedisTemplate.opsForSet()[Set（集合）]
	 *   stringRedisTemplate.opsForHash()[Hash（散列）]
	 *   stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
	 *
	 *  RedisTemplate也有以上这些操作
	 */

	//stringRedisTemplate
	@Test
	public void redisTest01() {
		//给redis中保存数据
		stringRedisTemplate.opsForValue().append("msg", "good");
		//从redis中读取数据
		//String msg = stringRedisTemplate.opsForValue().get("msg");
		//System.out.println(msg);
		//stringRedisTemplate.opsForList().leftPush("mylist","1");
//		stringRedisTemplate.opsForList().leftPush("mylist","2");
	}

	//redisTemplate
	@Test
	public void redisTest02() {

		//Redis需要序列化对象后才能保存，默认使用jdk序列化机制。所以如果保存对象需要把对象实体类实现Serializable接口
		//这样保存后的是杂乱的数据
		Employee emp = employeeMapper.getEmpById(1);
		//redisTemplate.opsForValue().set("emp-01",emp);

		/**
		 * 如果要将数据以json的方式保存 有两种方法
		 * (1)自己将对象转为json（用json转换工具）
		 * (2)自己定义一个redisTemplate序列化规则；Config包里创建一个RedisConfig，
		 * 然后自己创建一个把对象转化为json的序列化器，通过从源代码中复制默认的RedisTemplate过来再修改其序列化规则；
		*/

		//用自己创建的empRedisTemplate序列化器将数据以json的方式保存
		empRedisTemplate.opsForValue().set("emp02", emp);
	}



}

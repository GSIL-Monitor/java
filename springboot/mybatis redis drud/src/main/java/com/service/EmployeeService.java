package com.service;

import com.entity.Employee;
import com.mybatis.mapper.EmployeeMapper;
import com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//@CacheConfig为公共配置，里面可以定义公共缓存的名字等等，这样就不用在后面的各种缓存里定义了
//cacheManager = "empCacheManager" 为定义使用自创建的empCacheManager
@CacheConfig(cacheNames="emp",cacheManager = "empCacheManager")
@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	/*------------------------- Original Cache -----------------------------------------*/
	/**
	 * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法；
	 * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字；
	 *
	 *
	 * 原理：
	 *   1、自动配置类；CacheAutoConfiguration
	 *   2、缓存的配置类
	 *   org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
	 *   org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration【默认】
	 *   org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
	 *   3、哪个配置类默认生效：SimpleCacheConfiguration； yml文件里加debug: true 打印自动配置报告然后可查看哪个matched
	 *		它给容器中注册了一个CacheManager：ConcurrentMapCacheManager 缓存管理器
	 *		可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用将数据保存在ConcurrentMap中；
	 *
	 *   运行流程：
	 *   @Cacheable：
	 *   1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
	 *      （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
	 *   2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
	 *      key是按照某种策略生成的；默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key；
	 *          SimpleKeyGenerator生成key的默认策略；
	 *                  如果没有参数；key=new SimpleKey()；
	 *                  如果有一个参数：key=参数的值
	 *                  如果有多个参数：key=new SimpleKey(params)；
	 *   3、没有查到缓存就调用目标方法；
	 *   4、将目标方法返回的结果，放进缓存中
	 *
	 *   @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
	 *   如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
	 *
	 *   核心：
	 *      1）、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件
	 *      2）、key使用keyGenerator生成的，默认是SimpleKeyGenerator
	 *
	 *
	 *@Cacheable参数：
	 *      cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
	 *
	 *      key：缓存数据使用的key（key-value，（1-jack）；可以用它来指定。默认是使用方法参数的值(Integer id)
	 *      即localhost:8080/emp/1里面的1
	 *      key = "#id"//#id代表取出参数id的值作为key
	 *              编写SpEL； #id;参数id的值   #a0  #p0  #root.args[0]
	 *              getEmp[2]
	 *
	 *
	 *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id
	 *
	 *              key/keyGenerator：二选一使用;
	 *
	 *
	 *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
	 *
	 *      condition：指定符合条件的情况下才缓存；
	 *              ,condition = "#id>0"
	 *          condition = "#a0>1"：第一个参数的值>1的时候才进行缓存  #a0为第一个参数的值
	 *
	 *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
	 *              unless = " #result == null"
	 *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
	 *      sync：是否使用异步模式
	 * @param id
	 * @return
	 *
	 */

	//将方法的运行结果进行缓存，以后再要相同的数据，就直接从缓存中获取，不用调用方法
	@Cacheable(cacheNames = "emp"/*,keyGenerator = "myKeyGenerator",condition ="#a0>1",unless = "#a0==2"*/)
	public Employee getEmp(Integer id) {
		System.out.println("Query " + id + " Employee");
		Employee emp = employeeMapper.getEmpById(id);
		return emp;
	}



	/**
	 * @CachePut：既调用方法，又更新缓存数据；同步更新缓存
	 * 修改了数据库的某个数据，同时更新缓存；
	 * 运行时机：
	 *  1、先调用目标方法
	 *  2、将目标方法的结果缓存起来
	 *
	 * 测试步骤：
	 *  1、查询1号员工；查到的结果会放在缓存中；
	 *          key：1  value：lastName：张三
	 *  2、以后查询还是之前的结果
	 *  3、更新1号员工；【lastName:zhangsan；gender:0】
	 *          将方法的返回值也放进缓存了；
	 *          key：传入的employee对象  值：返回的employee对象；
	 *  4、查询1号员工？
	 *      应该是更新后的员工；
	 *          key = "#employee.id":使用传入的参数的员工id；
	 *          key = "#result.id"：使用返回后的id
	 *             @Cacheable的key是不能用#result
	 *      为什么是没更新前的？【1号员工没有在缓存中更新】
	 *
	 */
	//测试的时候要把上面方法的参数注释掉
	@CachePut(/*value = "emp",*/key = "#result.id")
	public Employee updateEmp(Employee employee){
		System.out.println("updateEmp:"+employee);
		employeeMapper.updateEmp(employee);
		return employee;
	}



	/**
	 * @CacheEvict：缓存清除
	 *  key：指定要清除的数据
	 *  allEntries = true：指定清除这个缓存中所有的数据
	 *  beforeInvocation = false：缓存的清除是否在方法之前执行
	 *      默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
	 *
	 *  beforeInvocation = true：
	 *      代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
	 *
	 *
	 */
	@CacheEvict(value="emp",beforeInvocation = true/*key = "#id",*/)
	public void deleteEmp(Integer id){
		System.out.println("deleteEmp:"+id);
		//employeeMapper.deleteEmpById(id);
		int i = 10/0;
	}

	// @Caching 组合注解，定义复杂的缓存规则  其内包含 cacheable() CachePut[] CacheEvict[] 三个注解
	@Caching(
			cacheable = {
					//按名字查 并且加入缓存 note：这里再用名字查还会经过数据库，因为有CachePut，方法总会执行
					@Cacheable(/*value="emp",*/key = "#lastName")
			},
			put = {
					//同时也把按id查的结果加入缓存了 这样后面用id查就不会经过数据库了
					@CachePut(/*value="emp",*/key = "#result.id"),
					//同时也把按email查的结果加入缓存了
					@CachePut(/*value="emp",*/key = "#result.email")
			}
	)
	public Employee getEmpByLastName(String lastName){
		return employeeMapper.getEmpByLastName(lastName);
	}
}

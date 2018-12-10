package com.redis;

import com.entity.Department;
import com.mybatis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

	@Autowired
	DepartmentMapper departmentMapper;

	//@Qualifier为指定注入的Bean的id 更明确
	@Qualifier("deptCacheManager")
	@Autowired
	RedisCacheManager deptCacheManager;


	/**
	 *  缓存的数据能存入redis；
	 *  第二次从缓存中查询就不能反序列化回来；
	 *  因为存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
	 *  所以要再多配置一个操作dept的RedisTemplate
	 */

	  //1. 使用注解方式加缓存
//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        Department department = departmentMapper.getDeptById(id);
//        return department;
//    }

	//2. 使用编码方式加缓存
	// 使用缓存管理器得到缓存，进行api调用
	public Department getDeptById(Integer id){
		System.out.println("查询部门"+id);
		Department department = departmentMapper.getDeptById(id);

		//获取某个缓存
		Cache dept = deptCacheManager.getCache("dept");
		//添加数据key value
		dept.put("dept:1",department);

		return department;
	}
}

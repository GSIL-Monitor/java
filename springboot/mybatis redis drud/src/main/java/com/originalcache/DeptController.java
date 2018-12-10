package com.originalcache;

import com.redis.DeptService;
import com.entity.Department;
import com.entity.Department;
import com.redis.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

	@Autowired
	DeptService deptService;


	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable("id") Integer id){
		return deptService.getDeptById(id);
	}

	//用 http://localhost:8080/dept?departmentName=AA 插入数据
/*	@GetMapping("/dept")
	public Department insertDepartment(Department department) {
		departmentMapper.insertDept(department);
		return department;
	}*/
}


package com.mybatis.mapper;

import com.entity.Department;
import org.apache.ibatis.annotations.*;

//使用@Mapper/@MapperScan()注解的方式使用Mybatis
@Mapper //告诉Mybatis指定这是一个操作数据库的mapper
public interface DepartmentMapper {

	//根据id查一个部门 #{id}为取出对象里的id
	@Select("select * from department where id=#{id}") //Mybatis数据库查询语句注解
	public Department getDeptById(Integer id);

	//根据id删除部门 返回影响多少行
	@Delete("delete from department where id=#{id}")
	public int deleteDeptById(Integer id);

	//插入数据 id是自增的，所以不用写  #{departmentName}为取出对象里的departmentName
	@Insert("insert into department (departmentName) values(#{departmentName})  ")
	//自动生成id（主键） useGeneratedKeys = true使用自动生成的主键  keyProperty = "id"告诉Mybatis，
	//Department对象里的id是来封装主键的，这样在插入departmentName的时候会自动插入主键id
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int insertDept(Department department);


	@Update("update department set departmentName=#{departmentName} where id=#{id}")
	public int updateDept(Department department);
}

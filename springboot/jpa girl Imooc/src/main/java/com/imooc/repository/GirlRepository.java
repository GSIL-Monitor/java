package com.imooc.repository;

import com.imooc.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 廖师兄
 * 2016-11-03 23:17
 */
//JpaRepository 即数据访问层接口 类似于DAO
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}

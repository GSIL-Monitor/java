package com.demo.dao;

import com.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

package com.demo.service;

import com.demo.entity.Category;

import java.util.List;

public interface CategoryService {

	Category findOne(Integer categoryId);

	List<Category> findAll();

	List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList);

	Category save(Category category);


}

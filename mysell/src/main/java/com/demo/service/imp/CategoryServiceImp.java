package com.demo.service.imp;

import com.demo.dao.CategoryDao;
import com.demo.entity.Category;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category findOne(Integer categoryId) {
		return categoryDao.findOne(categoryId);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return categoryDao.findByCategoryTypeIn(categoryTypeList);
	}

	@Override
	public Category save(Category category) {
		return categoryDao.save(category);
	}
}

package com.demo.dao;

import com.demo.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void findOneTest() {
		Category category = categoryDao.findOne(1);
		System.out.println(category.toString());
	}

	@Test
	@Transactional
	public void saveTest() {
		Category category = new Category("my best choice", 5);
		Category result = categoryDao.save(category);
		Assert.assertNotNull(result);
	}

	@Test
	public void updateTest() {
		Category category = categoryDao.findOne(2);
		category.setCategoryType(12);

		categoryDao.save(category);
	}

	@Test
	public void findByCategoryTypeInTest() {
		List<Integer> list = Arrays.asList(2, 12);
		List<Category> result = categoryDao.findByCategoryTypeIn(list);

		Assert.assertNotEquals(0, result.size());
	}

}
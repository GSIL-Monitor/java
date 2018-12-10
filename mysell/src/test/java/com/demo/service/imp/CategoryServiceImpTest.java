package com.demo.service.imp;

import com.demo.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImpTest {

	@Autowired
	private CategoryServiceImp categoryServiceImp;

	@Test
	public void findOne() {
		Category category = categoryServiceImp.findOne(1);
		Assert.assertEquals(new Integer(1), category.getCategoryId());
	}

	@Test
	public void findAll() {
		List<Category> categoryList = categoryServiceImp.findAll();
		Assert.assertNotEquals(0, categoryList.size());
		System.out.println(categoryList.toString());
	}

	@Test
	public void findByCategoryTypeInIn() {
		List<Category> categoryList = categoryServiceImp.findByCategoryTypeIn(Arrays.asList(2,12,3));
		Assert.assertNotEquals(0, categoryList.size());

	}

	@Test
	public void save() {
		Category category = new Category("hot sale", 15);
		Category result = categoryServiceImp.save(category);
		Assert.assertNotNull(result);

	}
}
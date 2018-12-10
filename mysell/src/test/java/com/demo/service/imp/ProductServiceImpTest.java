package com.demo.service.imp;

import com.demo.dao.ProductInfoDao;
import com.demo.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImpTest {

	@Autowired
	ProductInfoDao productInfoDao;

	@Test
	public void findAll() throws Exception {
		PageRequest pageRequest = new PageRequest(0, 2);
		Page<ProductInfo> productInfoPage = productInfoDao.findAll(pageRequest);
		//System.out.println(productInfoPage.getTotalElements());
		Assert.assertNotEquals(0,productInfoPage.getTotalElements());
	}
}
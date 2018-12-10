package com.demo.dao;

import com.demo.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
	List<ProductInfo> findByProductStatus(Integer productStatus);
}

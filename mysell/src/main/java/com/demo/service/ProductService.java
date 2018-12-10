package com.demo.service;

import com.demo.dto.CartDTO;
import com.demo.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
	ProductInfo findOne(String productId);

	List<ProductInfo> findUpAll();

	Page<ProductInfo> findAll(Pageable pageable);

	ProductInfo save(ProductInfo productInfo);

	void increaseStock(List<CartDTO> cartDTOList);

	void decreaseStock(List<CartDTO> cartDTOList);

	//ProductInfo onSale(String productId);

	//ProductInfo offSale(String productId);



}

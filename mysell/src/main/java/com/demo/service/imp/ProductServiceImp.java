package com.demo.service.imp;


import com.demo.dao.ProductInfoDao;
import com.demo.dto.CartDTO;
import com.demo.entity.ProductInfo;
import com.demo.enums.ProductStatusEnum;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductInfoDao productInfoDao;


	@Override
	public ProductInfo findOne(String productId) {
		return productInfoDao.findOne(productId);
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return productInfoDao.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return productInfoDao.save(productInfo);
	}

	@Override
	public void increaseStock(List<CartDTO> cartDTOList) {
	}

	@Override
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO : cartDTOList) {
			ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}

			Integer result=  productInfo.getProductStock() - cartDTO.getProductQuantity();
			if (result < 0) {
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			productInfo.setProductStock(result);
			productInfoDao.save(productInfo);
		}
	}
}

package com.demo.controller;

import com.demo.View.CategoryView;
import com.demo.View.ProductInfoView;
import com.demo.View.ResultView;
import com.demo.entity.Category;
import com.demo.entity.ProductInfo;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import com.demo.util.ResultViewUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class BuyerProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/all")
	public ResultView getAll() {
		//返回商品列表
		List<ProductInfo> productInfoList = productService.findUpAll();

		//返回商品类型编号列表
		List<Integer> categoryTypeList = new ArrayList<>();
		for (ProductInfo productInfo : productInfoList) {
			categoryTypeList.add(productInfo.getCategoryType());
		}
		//返回类型列表
		List<Category> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

		//数据拼装
		//定义类型view
		List<CategoryView> categoryViewList = new ArrayList<>();
		//遍历类型
		for (Category category : categoryList) {
			CategoryView categoryView = new CategoryView();
			categoryView.setCategoryName(category.getCategoryName());
			categoryView.setCategoryType(category.getCategoryType());

			//定义商品view
			List<ProductInfoView> productInfoViewList = new ArrayList<>();
			//遍历商品信息
			for (ProductInfo productInfo : productInfoList) {
				if (productInfo.getCategoryType().equals(category.getCategoryType())) {
					ProductInfoView productInfoView = new ProductInfoView();
					BeanUtils.copyProperties(productInfo, productInfoView);
					productInfoViewList.add(productInfoView);
				}
			}
			categoryView.setProductInfoViewList(productInfoViewList);
			categoryViewList.add(categoryView);


		}
		return ResultViewUtil.success(categoryViewList);
	}
}
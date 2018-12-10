package com.imooc.repository;

import com.imooc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-05-07 14:35
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    //通过类目编号list查类目list
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

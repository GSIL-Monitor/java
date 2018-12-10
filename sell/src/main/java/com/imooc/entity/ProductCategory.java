package com.imooc.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * Created by 廖师兄
 * 2017-05-07 14:30
 */
@Entity
@DynamicUpdate  //动态更新 entity里有Date updateTime，则update数据可以让数据库里updatetime也自动更新
@Data //该注解使用在类上，该注解会提供getter、setter、equals、canEqual、hashCode、toString方法。需要pom引入Lombok工具
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue //主键自增
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

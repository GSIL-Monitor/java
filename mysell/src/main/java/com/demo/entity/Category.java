package com.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class Category {
	@Id
	@GeneratedValue
	private Integer categoryId;

	private String categoryName;

	private Integer categoryType;

	private Date createTime;

	private Date updateTime;

	public Category() {
	}

	public Category(String categoryName, Integer categoryType) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}


}

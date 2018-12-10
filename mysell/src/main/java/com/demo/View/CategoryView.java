package com.demo.View;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryView {

	@JsonProperty("name")
	private String categoryName;

	@JsonProperty("type")
	private Integer categoryType;


	@JsonProperty("foods")
	private List<ProductInfoView> productInfoViewList;


}

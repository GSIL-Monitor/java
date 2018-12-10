package com.elasticsearchjest;

import io.searchbox.annotations.JestId;
import lombok.Data;


/**
 * 通过Jest使用ElasticSearch
 */
@Data
public class Article {

	//@JestId 注解标识一个主键
	@JestId
	private Integer id;
	private String author;
	private String title;
	private String content;

}

package com.demo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * pom文件里要去掉注释
 */
//@Document 为ElasticSearch的注解 指定存在哪个索引哪个类型下
@Document(indexName = "atguigu",type = "book")
@Data
public class Book {

	private Integer id;

	private String bookName;

	private String author;

	public Book() {
	}

	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}
}

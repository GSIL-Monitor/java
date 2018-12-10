package com.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 使用spring data Repository的方式使用ElasticSearch
 */

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

	//参照
	// https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
	public List<Book> findByBookNameLike(String bookName);

}

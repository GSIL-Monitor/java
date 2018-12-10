package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 使用Jest操作ElasticSearch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	//使用SpringData操作ElasticSearch
	@Autowired
	BookRepository bookRepository;



	/*-------------------------使用SpringData操作ElasticSearch------------------------------*/
	/**
	 * 使用SpringData操作ElasticSearch
	 * 保存book
	 */
	@Test
	public void test02(){
		Book book = new Book();
		book.setId(1);
		book.setBookName("西游记");
		book.setAuthor("吴承恩");
		bookRepository.index(book);

	}

	/**
	 * 使用SpringData操作ElasticSearch
	 * 根据书名查书
	 */
	@Test
	public void test03() {
		for (Book book : bookRepository.findByBookNameLike("游")) {
			System.out.println(book);
		}
		;
	}

}

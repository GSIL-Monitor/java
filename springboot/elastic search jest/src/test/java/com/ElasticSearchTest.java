package com;

import com.elasticsearchjest.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


/**
 *	使用Jest操作ElasticSearch
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {

	//JestAutoConfiguration里自动配置的JestClient
	//使用jest操作ElasticSearch
	@Autowired
	JestClient jestClient;


	/*-------------------------使用jest操作ElasticSearch------------------------------*/
	/**
	 * 使用jest操作ElasticSearch
	 * 测试添加索引 添加完可以查询用：http://10.211.55.5:9200/atguigu/news/1
	 */
	@Test
	public void contextLoads() {
		//1、给Es中索引（保存）一个文档；
		Article article = new Article();
		article.setId(1);
		article.setTitle("好消息");
		article.setAuthor("zhangsan");
		article.setContent("Hello World");

		//构建一个索引功能 保存在"atguigu"索引下 类型是"news"
		Index index = new Index.Builder(article).index("atguigu").type("news").build();

		try {
			//执行
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用jest操作ElasticSearch
	 * 测试搜索
	 */
	@Test
	public void search(){

		//查询表达式
		String json ="{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"hello\"\n" +
				"        }\n" +
				"    }\n" +
				"}";

		//更多操作：https://github.com/searchbox-io/Jest/tree/master/jest
		//构建搜索功能 addIndex（）指定在哪个索引下搜索  addType（）在哪个类型下搜
		Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();

		//执行
		try {
			SearchResult result = jestClient.execute(search);
			//.getJsonString()  把json打印
			System.out.println(result.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

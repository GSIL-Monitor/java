package com.mybatis;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//Mybatis的Configuration
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

	//添加配置，通过给容器中添加一个ConfigurationCustomizer
	//MapUnderscoreToCamelCase为启用驼峰命名，比如让lastname=last_name
	@Bean
	public ConfigurationCustomizer configurationCustomizer(){
		return new ConfigurationCustomizer(){
			@Override
			public void customize(Configuration configuration) {
				configuration.setMapUnderscoreToCamelCase(true);

			}
		};
	}
}

package com.imooc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2016-11-01 23:35
 */
@Component
@ConfigurationProperties(prefix = "girl")  //从.yml文件里获取前缀是girl的配置，这样就不用每次都写@Value注解了
@Data
public class GirlProperties {

    private String cupSize;

    private Integer age;

}

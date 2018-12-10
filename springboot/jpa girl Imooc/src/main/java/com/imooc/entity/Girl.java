package com.imooc.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by 廖师兄
 * 2016-11-03 23:07
 */
//这个类是和数据库对应的类 里面的属性值会映射成数据库的字段
@Entity  //表示这个类对应数据里面的一个表
@Data
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    //加入注解限制年龄为18 提示信息未成年少女禁止入门 （配合@Valid使用）
    @Min(value = 18, message = "未成年少女禁止入门")
//    @NotNull
//    @Max()
//    @Length()
    private Integer age;

    //@NotNull(message = "金额必传")
    private Double money;

    //必须加一个构造方法 不然数据库操作会报错
    public Girl() {
    }

}

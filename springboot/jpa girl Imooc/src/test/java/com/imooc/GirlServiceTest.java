package com.imooc;

import com.imooc.entity.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 廖师兄
 * 2017-02-14 23:20
 */
//自己写一个测试类用来测试findOneTest()这个方法
@RunWith(SpringRunner.class)  //注解表示我们要在测试环境中跑 底层使用的是JUnit测试工具
@SpringBootTest //注解表示将启动整个spring工程
public class GirlServiceTest {

    @Autowired  //注入girlService
    private GirlService girlService;

    @Test  //在测试的方法上加上@Test 注解
    public void findOneTest() {
        Girl girl = girlService.findOne(73);
        Assert.assertEquals(new Integer(13), girl.getAge());
    }
}

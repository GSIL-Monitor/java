package com.imooc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 廖师兄
 * 2017-02-14 23:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc  //
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls")) //判断请求的方法是get 地址是"/girls"
                .andExpect(MockMvcResultMatchers.status().isOk()) //判断期望返回的状态码
        .andExpect(MockMvcResultMatchers.content().string("abc"));//判断期望返回的结果内容是某一个值"abc"
    }

}
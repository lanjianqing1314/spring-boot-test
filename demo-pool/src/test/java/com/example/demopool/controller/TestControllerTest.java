package com.example.demopool.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 兰建青
 * @description TODO
 * @date 2021/1/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

    @Resource
    private TestController testController;

    @Test
    void test1() {
        List<Long> list = testController.test();
        list.forEach(item -> System.out.println(item));
    }
}
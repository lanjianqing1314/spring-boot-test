package com.example.demostrategy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
    public void testTest() {
        Long rs = testController.test("key2");
        System.out.println(rs);
    }
}
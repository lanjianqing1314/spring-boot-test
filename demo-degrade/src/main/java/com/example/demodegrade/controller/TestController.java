package com.example.demodegrade.controller;

import com.example.demodegrade.service.TestService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 兰建青
 * @descrip test
 * @date 2021/2/14
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    public void test(String param) {
        testService.test(param);
    }
}

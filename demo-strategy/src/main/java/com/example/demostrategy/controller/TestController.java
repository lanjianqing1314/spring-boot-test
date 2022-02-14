package com.example.demostrategy.controller;

import com.example.demostrategy.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 兰建青
 * @description TODO
 * @date 2021/1/18
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("api/test")
    public Long test(String param) {
        return testService.test(param);
    }
}

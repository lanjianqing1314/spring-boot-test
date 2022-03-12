package com.example.demointerceptor.controller;

import com.example.demointerceptor.interceptor.ResponseResult;
import com.example.demointerceptor.interceptor.error.ResponseResultException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 兰建青
 * @title: DemoController
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2021/1/12 10:24
 */
@RestController
@ResponseResult
public class DemoController {
    @GetMapping("api/demo/success")
    public String success() {
        return "hollow boy";
    }

    @GetMapping("api/demo/error")
    public void error() {
        throw new ResponseResultException("错误啦");
    }
}

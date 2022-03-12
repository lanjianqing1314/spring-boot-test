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
public class DemoController {

    @ResponseResult
    @GetMapping("api/demo/string")
    public String stringResult() {
        return "hollow boy";
    }

    @GetMapping("api/demo/int")
    public int intResult() {
        return 0;
    }

    @ResponseResult
    @GetMapping("api/demo/error")
    public void errorResult() {
        throw new ResponseResultException("错误啦");
    }
}

package com.example.demopool.controller;

import com.example.demopool.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public List<Long> test() {
        return testService.test();
    }
}

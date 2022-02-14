package com.example.demodegrade.service.impl;

import com.example.demodegrade.degrade.Degrade;
import com.example.demodegrade.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author 兰建青
 * @description TODO
 * @date 2021/2/14
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    @Degrade(className = "test1ServiceImpl", methodName = "test1")
    public void test(String param) {
        throw new RuntimeException("报错了");
    }
}

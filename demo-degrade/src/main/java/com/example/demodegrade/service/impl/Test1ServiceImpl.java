package com.example.demodegrade.service.impl;

import com.example.demodegrade.service.Test1Service;
import com.example.demodegrade.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author 兰建青
 * @description TODO
 * @date 2021/2/14
 */
@Service
public class Test1ServiceImpl implements Test1Service {
    @Override
    public void test1(String param) {
        System.out.println("test1:" + param);
    }
}

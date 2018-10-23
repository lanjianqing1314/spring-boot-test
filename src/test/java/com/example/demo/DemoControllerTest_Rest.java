package com.example.demo;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class DemoControllerTest_Rest extends DemoTest_Rest {

    @Test
    public void test(){
        ResponseEntity<String> response = restTemplate.exchange(url + "/demo" ,
                HttpMethod.GET,
                new HttpEntity<Object>(null),
                String.class);
        System.out.println("测试结果: " + response.getBody());
    }
    
}

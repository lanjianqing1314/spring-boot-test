package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: DemoControllerTest_Feign
 * @Description: TODO(Http Rest API 单元测试)
 * @author Administrator
 * @date 2018年10月22日
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest_Rest {
	
	public  final  static String url =  "http://localhost:8080/";
	
    public static RestTemplate restTemplate = new RestTemplate();
    
    @Before
    public void before() {
    	System.out.println("测试开始-------------------------------------------------");
    }
    
    @After
    public void after() {
    	System.out.println("测试结束-------------------------------------------------");
    }
    
}

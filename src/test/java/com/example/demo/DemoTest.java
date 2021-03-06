package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoTest {

	@Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void before() throws Exception {
    	System.out.println("测试开始-------------------------------------------------");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @After
    public void after() {
    	System.out.println("测试结束-------------------------------------------------");
    }
    
}

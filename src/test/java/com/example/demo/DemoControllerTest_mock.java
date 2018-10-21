package com.example.demo;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

public class DemoControllerTest_mock extends DemoTest {

    @Test
    public void testSend() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/demo"))
                .andDo(MockMvcResultHandlers.print());

    }
}

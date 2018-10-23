package com.example.demo;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

public class DemoControllerTest_Mock extends DemoTest_Mock {

    @Test
    public void testSend() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/demo"))
                .andDo(MockMvcResultHandlers.print());

    }
}

package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoIntegrationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetPost() throws Exception {
        mvc.perform(get("/demo/jsonplaceholder/posts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testGetComments() throws Exception {
        mvc.perform(get("/demo/jsonplaceholder/posts/1/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].postId").value(1));
    }
}

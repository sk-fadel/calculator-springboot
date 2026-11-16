package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CalculatorService service;

    @Test
    void testAddEndpoint() throws Exception {
        when(service.add(2, 3)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculator/add?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
}
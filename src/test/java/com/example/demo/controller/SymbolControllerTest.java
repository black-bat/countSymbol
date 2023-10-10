package com.example.demo.controller;

import com.example.demo.model.Symbol;
import com.example.demo.service.SymbolService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SymbolController.class)
class SymbolControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SymbolService service;

    @Test
    public void getSymbols_thenStatus200() throws Exception {
        String path = "hhh584yyyy152";
        String result = "y:4,h:3";
        List<Symbol> list = Arrays.asList(new Symbol("y", 4), new Symbol("h", 3));
        Mockito.when(service.getCountSymbols(path)).thenReturn(Arrays.asList(
                new Symbol("y", 4), new Symbol("h", 3)));
        Mockito.when(service.createString(list)).thenReturn(result);
        mockMvc.perform(get("/v1/count/{symbol}", path))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo(result)));
    }
}
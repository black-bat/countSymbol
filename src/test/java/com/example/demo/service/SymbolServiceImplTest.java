package com.example.demo.service;

import com.example.demo.model.Symbol;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class SymbolServiceImplTest {
    @Autowired
    private SymbolService service;

    @Test
    void getCountSymbols() {
        String test = "hhhff584yyyyccccy152";
        List<Symbol> list = service.getCountSymbols(test);
        Assert.isTrue(list.size() == 4, "getCountSymbols Ok");
    }

    @Test
    void createString() {
        String test = "hhhff584yyyyccccy...";
        List<Symbol> list = service.getCountSymbols(test);
        String result = service.createString(list);
        Assert.isTrue(result.equals("y : 5 , c : 4 , h : 3 , f : 2"), "createString Ok");
    }
}
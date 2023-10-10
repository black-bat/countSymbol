package com.example.demo.controller;

import com.example.demo.model.Symbol;
import com.example.demo.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/v1/count")
public class SymbolController {

    @Autowired
    SymbolService service;

    @GetMapping(value = "/{symbol}")
    public ResponseEntity<String> getSymbols(@PathVariable(name = "symbol") String str) {
        List<Symbol> list = service.getCountSymbols(str);
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(service.createString(list), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

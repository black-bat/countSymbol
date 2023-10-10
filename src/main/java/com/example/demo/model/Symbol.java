package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Symbol {
    String symbolName;
    int count;

    public Symbol() {
    }

    public Symbol(String symbolName, int count) {
        this.symbolName = symbolName;
        this.count = count;
    }
}

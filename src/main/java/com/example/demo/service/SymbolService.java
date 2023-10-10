package com.example.demo.service;

import com.example.demo.model.Symbol;

import java.util.List;

public interface SymbolService {
    List<Symbol> getCountSymbols(String str);

    String createString(List<Symbol> list);
}

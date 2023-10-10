package com.example.demo.service;

import com.example.demo.model.Symbol;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SymbolServiceImpl implements SymbolService {
    @Override
    public List<Symbol> getCountSymbols(String str) {
        if (str.trim().isEmpty()) {
            return null;
        }
        List<Symbol> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String s = str.chars()
                .distinct()
                .filter(Character::isLetter)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
        String symbol1 = "";
        int count;
        for (int i = 0; i < s.length(); i++) {
            symbol1 = String.valueOf(s.charAt(i));
            count = str.length() - str.replaceAll(symbol1, "").length();
            map.put(symbol1, count);
        }
        HashMap<String, Integer> result = new LinkedHashMap<>();
        Stream<Map.Entry<String, Integer>> st = map.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(e -> result.put(e.getKey(), e.getValue()));
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            Symbol symbol = new Symbol();
            symbol.setSymbolName(m.getKey());
            symbol.setCount(m.getValue());
            list.add(symbol);
        }
        List<Symbol> list1 = new ArrayList<>();
        for (int i = list.size() - 1; i > -1; i--) {
            list1.add(list.get(i));
        }
        return list1;
    }

    @Override
    public String createString(List<Symbol> list) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (Symbol symbol : list) {
            stringBuilder.append(symbol.getSymbolName()).append(" : ").append(symbol.getCount()).append(" , ");
        }
        return stringBuilder.substring(0,stringBuilder.lastIndexOf(",")).trim();
    }
}

package com.sandlex.xpnsr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandlex.xpnsr.model.Categories;
import com.sandlex.xpnsr.model.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataContext {

    private final StatementsFileParser parser;
    private final ObjectMapper objectMapper;

    private List<Transaction> transactions;
    private Categories categories;
    
    @PostConstruct
    @SneakyThrows
    public void load() {
        transactions = parser.parse("/Users/apeskov/Downloads/NL67INGB0656001666_01-01-2012_23-10-2020.csv");
        System.out.println("Loaded transactions: " + transactions.size());
        
        categories = objectMapper.readValue(new File("/Users/apeskov/Downloads/categories.json"), Categories.class);
        System.out.println("Loaded categories: " + categories.toString());
    }
}

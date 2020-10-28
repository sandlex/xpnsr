package com.sandlex.xpnsr.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandlex.xpnsr.StatementsFileParser;
import com.sandlex.xpnsr.model.Categories;
import com.sandlex.xpnsr.model.Category;
import com.sandlex.xpnsr.model.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@ShellComponent
public class Commands {

    private final StatementsFileParser parser;
    private final ObjectMapper objectMapper;

    @ShellMethod("Parses statement file")
    public void parse(@ShellOption(defaultValue = "/Users/apeskov/Downloads/NL67INGB0656001666_01-01-2012_23-10-2020.csv") String file) {
        parser.parse(file);
    }

    @ShellMethod("Loads categories from file")
    public void lc(@ShellOption(defaultValue = "/Users/apeskov/Downloads/categories.json") String file) throws IOException {
        objectMapper.readValue(new File(file), Categories.class);
    }

    @ShellMethod("Saves categories into file")
    public void sc(@ShellOption(defaultValue = "/Users/apeskov/Downloads/categories.json") String file) throws IOException {
//        Categories categories = Categories.builder()
//                .categories(List.of(Category.builder()
//                        .rules(List.of(Rule.builder()
//                                .field("account")
//                                .value("wyeryweurytuwetru")
//                                .build()))
//                        .build()))
//                .build();
        objectMapper.writeValue(new File(file), null);
    }

    //stat - number of transaction, number of uncategorised transactions
    //showcat - displays all categories
    //uncat - shows uncategorised transactions, number or full/paginated list
    //cat - shows random transaction for categorisation
    //export - exports as file with date, amount, category to insert into excel
}

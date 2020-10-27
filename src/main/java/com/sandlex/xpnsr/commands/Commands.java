package com.sandlex.xpnsr.commands;

import com.sandlex.xpnsr.StatementsFileParser;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@RequiredArgsConstructor
@ShellComponent
public class Commands {

    private final StatementsFileParser parser;

    @ShellMethod("Parses statement file")
    public void parse(@ShellOption(defaultValue = "/Users/apeskov/Downloads/NL67INGB0656001666_01-01-2012_23-10-2020.csv") String file) {
        parser.parse(file);
    }
    
    //stat - number of transaction, number of uncategorised transactions
    //showcat - displays all categories
    //uncat - shows uncategorised transactions, number or full/paginated list
    //cat - shows random transaction for categorisation
    //export - exports as file with date, amount, category to insert into excel
}

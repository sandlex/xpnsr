package com.sandlex.xpnsr.commands;

import com.sandlex.xpnsr.StatementsFileParser;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * https://docs.spring.io/spring-shell/docs/current-SNAPSHOT/reference/htmlsingle/#_using_spring_shell
 */
@RequiredArgsConstructor
@ShellComponent
public class Commands {

    private final StatementsFileParser parser;

    @ShellMethod("Parses statement file")
    public void parse(@ShellOption(defaultValue = "/Users/sandlex/Downloads/NL67INGB0656001666_01-01-2012_04-08-2018.csv") String file) {
        parser.parse(file);

    }
}

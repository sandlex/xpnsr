package com.sandlex.xpnsr;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.sandlex.xpnsr.model.ing.BalanceType;
import com.sandlex.xpnsr.model.ing.Code;
import com.sandlex.xpnsr.model.ing.InputStatement;
import com.sandlex.xpnsr.model.ing.TransactionType;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * https://github.com/FasterXML/jackson-dataformats-text/tree/master/csv
 */
@Component
public class StatementsFileParser {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final String DATE_FIELD_NAME = "Datum";

    Set<String> uniqueNames = new HashSet<>();
    Set<String> uniqueAccounts = new HashSet<>();

    public void parse(String fileName) {
        File file = new File(fileName);
        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

        try {
            MappingIterator<String[]> it = mapper.readerFor(String[].class).readValues(file);
            Iterable<String[]> iterable = () -> it;
            Stream<String[]> targetStream = StreamSupport.stream(iterable.spliterator(), false);
            targetStream.filter(str -> !DATE_FIELD_NAME.equals(str[0])).forEach(this::createStatement);

//            List<String[]> strings = it.readAll();
//            System.out.println(strings.size());
            System.out.println("names: " + uniqueNames.size());
            System.out.println("accounts: " + uniqueAccounts.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStatement createStatement(String[] fields) {

        uniqueNames.add(fields[1]);
        uniqueAccounts.add(fields[3]);

        return InputStatement.builder()
                .date(LocalDate.parse(fields[0], dateTimeFormatter))
                .nameDescription(fields[1])
                .account(fields[2])
                .contraAccount(fields[3])
                .code(Code.valueOf(fields[4]))
                .balanceType(BalanceType.valueOf(fields[5]))
                .amount(new BigDecimal(fields[6].replace(",", ".")))
                .transactionType(TransactionType.fromValue(fields[7]))
                .announcements(fields[8])
                .build();
    }
}

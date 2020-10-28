package com.sandlex.xpnsr;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.sandlex.xpnsr.model.BalanceType;
import com.sandlex.xpnsr.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StatementsFileParser {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    private final ObjectReader objectReader;

    public List<Transaction> parse(String fileName) {
        File file = new File(fileName);
        List<Transaction> result = Collections.emptyList();
        try {
            MappingIterator<String[]> it = objectReader.readValues(file);
            result = it.readAll()
                    .stream()
                    .map(this::createStatement)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Transaction createStatement(String[] fields) {
        return Transaction.builder()
                .date(LocalDate.parse(fields[0], dateTimeFormatter))
                .nameDescription(fields[1])
                .counterparty(fields[3])
                .debitCredit(BalanceType.valueOf(fields[5].toUpperCase()))
                .amount(new BigDecimal(fields[6].replace(",", ".")))
                .notifications(fields[8])
                .build();
    }

}

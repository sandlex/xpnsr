package com.sandlex.xpnsr.config;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvParserConfiguration {

    @Bean
    public ObjectReader csvObjectReader() {
        CsvSchema schema = CsvSchema.builder()
                .setColumnSeparator(';')
                .setSkipFirstDataRow(true)
                .setQuoteChar('"')
                .build();

        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        return mapper.readerForArrayOf(String.class).with(schema);
    }

}

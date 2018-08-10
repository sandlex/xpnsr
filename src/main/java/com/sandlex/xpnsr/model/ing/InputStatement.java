package com.sandlex.xpnsr.model.ing;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 */
@Builder
public class InputStatement {

    //"Datum"
    private LocalDate date;

    //"Naam / Omschrijving"
    private String nameDescription;

    // "Rekening"
    private String account;

    // "Tegenrekening"
    private String contraAccount;

    // "Code"
    private Code code;

    // "Af Bij"
    private BalanceType balanceType;

    // "Bedrag (EUR)"
    private BigDecimal amount;

    // "MutatieSoort"
    private TransactionType transactionType;

    // "Mededelingen"
    private String announcements;

}

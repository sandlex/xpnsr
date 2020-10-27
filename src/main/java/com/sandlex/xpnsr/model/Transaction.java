package com.sandlex.xpnsr.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
public class Transaction {

    private LocalDate date;
    private String nameDescription;
    private String counterparty;
    private BalanceType debitCredit;
    private BigDecimal amount;
    private String notifications;

}

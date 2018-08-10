package com.sandlex.xpnsr.model.ing;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 *
 */
@RequiredArgsConstructor
public enum TransactionType {

    BETAALAUTOMAAT("Betaalautomaat"),
    INCASSO("Incasso"),
    ONLINEBANKIEREN("Online bankieren"),
    GELDAUTOMAAT("Geldautomaat"),
    VERZAMELBETALING("Verzamelbetaling"),
    OVERSCHRIJVING("Overschrijving"),
    DIVERSEN("Diversen");

    private final String value;

    public static TransactionType fromValue(String value) {
        return Arrays.stream(TransactionType.values())
                .filter(transactionType -> (transactionType.value.equals(value)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}

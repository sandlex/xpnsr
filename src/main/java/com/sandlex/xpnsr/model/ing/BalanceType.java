package com.sandlex.xpnsr.model.ing;

/**
 *
 */
public enum BalanceType {

    Af, Bij;

    public static boolean isDebit(BalanceType type) {
        return Af.equals(type);
    }

    public static boolean isCredit(BalanceType type) {
        return Bij.equals(type);
    }

}

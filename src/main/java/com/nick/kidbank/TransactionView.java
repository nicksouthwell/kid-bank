package com.nick.kidbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionView {
    private String date;
    private String action;
    private String amount;
    private String source;

    public static TransactionView from(Transaction txn) {
        String amountString = AccountController.formatAsMoney(txn.amount());
        return new TransactionView(txn.date().toString(), txn.action(), amountString, txn.source());
    }
}

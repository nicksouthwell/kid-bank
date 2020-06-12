package com.nick.kidbank;

import com.google.common.collect.ImmutableSet;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

public class Account {
    private int balance = 0;
    private Set<Transaction> transactions = Collections.EMPTY_SET;

    public int balance() {
        return balance;
    }

    public void deposit(LocalDateTime transactionDateTime, int amount, String source) {
        balance += amount;
        transactions = ImmutableSet.<Transaction>builder()
                .addAll(transactions)
                .add(new Transaction(transactionDateTime, "Deposit", amount, source))
                .build();
    }

    public Set<Transaction> transactions() {
        return transactions;
    }
}

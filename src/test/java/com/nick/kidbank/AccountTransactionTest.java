package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTransactionTest {
    @Test
    public void newAccountShouldHaveNoTransactions() {
        Account account = new Account();

        assertThat(account.transactions()).isEmpty();
    }

    @Test
    public void depositShouldAddTransaction() {
        Account account = new Account();

        LocalDateTime transactionDateTime = LocalDateTime.now();
        account.deposit(transactionDateTime, 123, "Bottle Return");

        assertThat(account.transactions())
                .hasSize(1)
                .containsOnly(
                        new Transaction(transactionDateTime, "Deposit", 123, "Bottle Return")
                );
    }
}
package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTransactionTest {
    @Test
    public void newAccountShouldHaveNoTransactions() {
        Account account = new Account();

        assertThat(account.transactions()).isEmpty();
    }
}
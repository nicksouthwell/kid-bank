package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceTest {
    @Test
    public void newAccountShouldHaveZeroBalance() {
        Account account = new Account();

        assertThat(account.balance()).isZero();
    }
}
package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountControllerTest {
    @Test
    void format0AsMoneyResultsInDollarsAndCents() {
        AccountController unit = new AccountController(null);

        assertThat(unit.formatAsMoney(0)).isEqualTo("$0.00");
    }

    @Test
    public void viewBalanceShouldDisplayBalance() {
        Account account = new Account();
        account.deposit(10);
        AccountController accountController = new AccountController(account);

        assertThat(accountController.viewBalance()).isEqualTo("$0.10");
    }
}
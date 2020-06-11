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
    public void formatLessThanOneDollarShouldHaveLeadingZero() {
        AccountController accountController = new AccountController(null);

        assertThat(accountController.formatAsMoney(99))
                .isEqualTo("$0.99");
    }

    @Test
    public void formatMoreThanOneDollarShouldHaveNoLeadingZeroes() throws Exception {
        AccountController accountController = new AccountController(null);

        assertThat(accountController.formatAsMoney(123))
                .isEqualTo("$1.23");
    }

    @Test
    public void viewBalanceShouldDisplayBalance() {
        Account account = new Account();
        account.deposit(10);
        AccountController accountController = new AccountController(account);

        assertThat(accountController.viewBalance()).isEqualTo("$0.10");
    }
}
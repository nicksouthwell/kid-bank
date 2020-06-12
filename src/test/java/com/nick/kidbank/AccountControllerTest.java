package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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
    public void depositCommandShouldAddToBalance() {
        DepositCommand depositCommand = new DepositCommand();
        depositCommand.setAmount("12.34");

        Account account = new Account();
        AccountController accountController = new AccountController(account);
        accountController.deposit(depositCommand);

        assertThat(account.balance()).isEqualTo(1234);
    }

    @Test
    public void viewBalanceShouldDisplayBalance() {
        Account account = new Account();
        account.deposit(LocalDateTime.now(), 10, "Bottle Return");
        AccountController accountController = new AccountController(account);

        assertThat(accountController.viewBalance()).isEqualTo("$0.10");
    }
}
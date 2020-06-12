package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountControllerTest {
    @Test
    public void depositCommandShouldAddToBalance() {
        DepositCommand depositCommand = new DepositCommand();
        depositCommand.setAmount("12.34");

        Account account = new Account();
        AccountController accountController = new AccountController(account);
        accountController.deposit(depositCommand);

        assertThat(account.balance()).isEqualTo(1234);
    }
}
package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepositTest {
    @Test
    public void deposit376ShouldResultInBalance376() {
        Account account = new Account();
        account.deposit(376);

        assertThat(account.balance()).isEqualTo(376);
    }

    @Test
    public void deposit50then60ShouldResultInBalance110() {
        Account account = new Account();
        account.deposit(50);
        account.deposit(60);

        assertThat(account.balance()).isEqualTo(110);
    }
}
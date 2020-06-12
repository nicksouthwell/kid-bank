package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class DepositTest {
    @Test
    public void deposit376ShouldResultInBalance376() {
        Account account = new Account();
        account.deposit(LocalDateTime.now(), 376, "Bottle Return");

        assertThat(account.balance()).isEqualTo(376);
    }

    @Test
    public void deposit50then60ShouldResultInBalance110() {
        Account account = new Account();
        account.deposit(LocalDateTime.now(), 50, "Bottle Return");
        account.deposit(LocalDateTime.now(), 60, "Bottle Return");

        assertThat(account.balance()).isEqualTo(110);
    }
}
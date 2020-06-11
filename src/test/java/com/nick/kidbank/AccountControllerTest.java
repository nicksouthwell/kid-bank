package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountControllerTest {
    @Test
    void format0AsMoneyResultsInDollarsAndCents() {
        AccountController unit = new AccountController();

        assertThat(unit.formatAsMoney(0)).isEqualTo("$0.00");
    }
}
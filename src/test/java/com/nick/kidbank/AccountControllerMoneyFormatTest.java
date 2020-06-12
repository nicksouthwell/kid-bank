package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountControllerMoneyFormatTest {
    @Test
    void format0AsMoneyResultsInDollarsAndCents() {
        assertThat(AccountController.formatAsMoney(0))
                .isEqualTo("$0.00");
    }

    @Test
    public void formatLessThanOneDollarShouldHaveLeadingZero() {
        assertThat(AccountController.formatAsMoney(99))
                .isEqualTo("$0.99");
    }

    @Test
    public void formatMoreThanOneDollarShouldHaveNoLeadingZeroes() throws Exception {
        assertThat(AccountController.formatAsMoney(123))
                .isEqualTo("$1.23");
    }
}

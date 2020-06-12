package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static com.nick.kidbank.TransactionView.formatAsMoney;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionViewMoneyFormatTest {
    @Test
    void format0AsMoneyResultsInDollarsAndCents() {
        assertThat(formatAsMoney(0))
                .isEqualTo("$0.00");
    }

    @Test
    public void formatLessThanOneDollarShouldHaveLeadingZero() {
        assertThat(formatAsMoney(99))
                .isEqualTo("$0.99");
    }

    @Test
    public void formatMoreThanOneDollarShouldHaveNoLeadingZeroes() throws Exception {
        assertThat(formatAsMoney(123))
                .isEqualTo("$1.23");
    }
}

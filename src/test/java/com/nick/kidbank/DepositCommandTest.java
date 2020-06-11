package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepositCommandTest {

    @Test
    public void decimalToPennies() {
        String amount = "4.95";
        assertThat(DepositCommand.decimalToPennies(amount))
                .isEqualTo(495);
    }
}
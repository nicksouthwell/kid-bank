package com.nick.kidbank;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionViewDateFormatTest {
    @Test
    public void formattedDateShouldBeMMDDYYYY() {
        LocalDateTime localDateTime = LocalDateTime.of(2017,3,7,0,0);

        assertThat(TransactionView.formatAsDate(localDateTime))
                .isEqualTo("03/07/2017");
    }
}

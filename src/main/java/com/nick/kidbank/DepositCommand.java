package com.nick.kidbank;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class DepositCommand {
    public static final DateTimeFormatter M_D_YYYY_DATE_FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy");

    private String date;
    private String amount;

    public static int decimalToPennies(String rawAmount) {
        BigDecimal decimalAmount = new BigDecimal(rawAmount);
        return decimalAmount.scaleByPowerOfTen(2).intValue();
    }

    static LocalDateTime toLocalDateTime(String rawDate) {
        LocalDate localDate = LocalDate.parse(rawDate, M_D_YYYY_DATE_FORMATTER);
        return localDate.atStartOfDay();
    }

    public static DepositCommand createWithTodayDate() {
        DepositCommand depositCommand = new DepositCommand();
        LocalDate localDate = LocalDate.now();
        depositCommand.setDate(localDate.format(M_D_YYYY_DATE_FORMATTER));
        return depositCommand;
    }

    public int amountInCents() {
        return decimalToPennies(amount);
    }

    public LocalDateTime dateAsLocalDateTime() {
        return toLocalDateTime(date);
    }
}

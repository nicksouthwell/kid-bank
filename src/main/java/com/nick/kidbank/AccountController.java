package com.nick.kidbank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Collections;

@Controller
public class AccountController {

    public static final DecimalFormat FORMAT_AS_DOLLARS_AND_CENTS = new DecimalFormat("$###,##0.00");

    private Account account;

    public AccountController(Account account) {
        this.account = account;
    }

    @GetMapping("/")
    public String viewBalance(Model model) {
        int balance = account.balance();
        model.addAttribute("balance", formatAsMoney(balance));
        model.addAttribute("deposit", new DepositCommand());
        model.addAttribute("transactions", Collections.EMPTY_LIST);
        return "account-balance";
    }

    @PostMapping("/deposit")
    public String deposit(DepositCommand depositCommand) {
        int amount = depositCommand.amountInCents();
        account.deposit(LocalDateTime.now(), amount, "Bottle Return");
        return "redirect:/";
    }

    public String formatAsMoney(int amount) {
        BigDecimal amountInDollars = new BigDecimal(amount).scaleByPowerOfTen(-2);
        return FORMAT_AS_DOLLARS_AND_CENTS.format(amountInDollars);
    }

    public String viewBalance() {
        return formatAsMoney(account.balance());
    }
}

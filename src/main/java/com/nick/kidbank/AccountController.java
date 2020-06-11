package com.nick.kidbank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @GetMapping("/")
    public String viewBalance(Model model) {
        Account account = new Account();
        int balance = account.balance();
        model.addAttribute("balance", formatAsMoney(balance));
        model.addAttribute("deposit", new DepositCommand());
        return "account-balance";
    }

    @PostMapping
    public String deposit(DepositCommand depositCommand) {
        return "";
    }

    public String formatAsMoney(int amount) {
        return "$0.00";
    }
}

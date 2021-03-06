package com.nick.kidbank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.nick.kidbank.TransactionView.formatAsMoney;
import static java.util.Comparator.comparing;

@Controller
public class AccountController {

    private Account account;

    public AccountController(Account account) {
        this.account = account;
    }

    @PostMapping("/deposit")
    public String deposit(DepositCommand depositCommand) {
        int amount = depositCommand.amountInCents();
        LocalDateTime dateTime = depositCommand.dateAsLocalDateTime();
        String source = depositCommand.getSource();
        account.deposit(dateTime, amount, source);
        return "redirect:/";
    }

    @GetMapping("/")
    public String viewBalance(Model model) {
        int balance = account.balance();
        DepositCommand depositCommand = DepositCommand.createWithTodayDate();
        List<TransactionView> transactionViewList = account.transactions().stream()
                .sorted(comparing(Transaction::date).reversed())
                .map(TransactionView::from)
                .collect(Collectors.toList());

        model.addAttribute("balance", formatAsMoney(balance));
        model.addAttribute("deposit", depositCommand);
        model.addAttribute("transactions", transactionViewList);

        return "account-balance";
    }
}

package com.jdkurogane.webaccounting.controllers;

import com.jdkurogane.webaccounting.models.Transaction;
import com.jdkurogane.webaccounting.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions")
    public String transactions(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("transactions", transactionService.listTransaction(title));
        model.addAttribute("user", transactionService.getUserByPrincipal(principal));
        return "transactionPages/transactions";
    }

    @GetMapping("/transaction/{id}")
    public String transactionInfo(@PathVariable Long id, Model model) {
        model.addAttribute("transaction", transactionService.getTransactionById(id));
        return "transactionPages/transaction-info";
    }

    @PostMapping("/transaction/create")
    public String createTransaction(Transaction transaction, Principal principal) {
        transactionService.saveTransaction(principal, transaction);
        return "redirect:/transactions";
    }

    @PostMapping("/transaction/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
}

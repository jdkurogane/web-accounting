package com.jdkurogane.webaccounting.services;

import com.jdkurogane.webaccounting.models.Transaction;
import com.jdkurogane.webaccounting.models.User;
import com.jdkurogane.webaccounting.repositories.TransactionRepository;
import com.jdkurogane.webaccounting.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    public List<Transaction> listTransaction(String title) {
        if (title != null) return transactionRepository.findByTitle(title);
        return transactionRepository.findAll();
    }

    public void saveTransaction(Principal principal, Transaction transaction) {
        transaction.setUser(getUserByPrincipal(principal));
        log.info("Saving new {}", transaction);
        transactionRepository.save(transaction);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }
}

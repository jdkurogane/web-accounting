package com.jdkurogane.webaccounting.repositories;

import com.jdkurogane.webaccounting.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTitle(String title);
}

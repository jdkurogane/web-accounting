package com.jdkurogane.webaccounting.repositories;

import com.jdkurogane.webaccounting.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}


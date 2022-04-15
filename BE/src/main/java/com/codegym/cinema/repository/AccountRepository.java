package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, String> {
}

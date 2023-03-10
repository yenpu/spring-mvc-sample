package com.example.mvc.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByLastName(final String lastName);

    Account findById(final long id);
}

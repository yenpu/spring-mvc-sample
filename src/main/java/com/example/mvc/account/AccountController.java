package com.example.mvc.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mvc/")
public class AccountController {

    private final AccountRepository repository;
    public AccountController(final AccountRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/accounts")
    public Page<Account> findAll() {
        final Pageable limit = PageRequest.of(0,100);
        return this.repository.findAll(limit);
    }

    @PostMapping(path = "/accounts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Account create(@RequestBody Account account) {
        return this.repository.save(account);
    }
}

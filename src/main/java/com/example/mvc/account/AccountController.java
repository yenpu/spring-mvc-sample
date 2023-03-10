package com.example.mvc.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mvc/")
public class AccountController {

    private final AccountRepository repository;
    public AccountController(final AccountRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/accounts")
    public Page<Account> findAll(@RequestParam(name = "sleep", required = false) String sleepParam) {
        final Integer sleep = Integer.valueOf(Optional.ofNullable(sleepParam).orElse("0"));
        final Pageable limit = PageRequest.of(0,100);
        try {
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException e) {
            // Handle any InterruptedExceptions that may occur
            e.printStackTrace();
        }

        return this.repository.findAll(limit);
    }

    @PostMapping(path = "/accounts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Account create(@RequestBody Account account) {
        return this.repository.save(account);
    }
}

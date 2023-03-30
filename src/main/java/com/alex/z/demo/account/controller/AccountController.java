package com.alex.z.demo.account.controller;

import com.alex.z.demo.account.model.Account;
import com.alex.z.demo.account.repository.AccountRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Operation(
            tags = {"Accounts"},
            summary = "Fetches all Accounts"
    )
    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}
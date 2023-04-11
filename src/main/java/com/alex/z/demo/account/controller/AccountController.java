package com.alex.z.demo.account.controller;

import com.alex.z.demo.account.dto.AccountResponse;
import com.alex.z.demo.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Operation(
            tags = {"Accounts"},
            summary = "Fetches all Accounts"
    )
    @GetMapping
    public List<AccountResponse> getAll() {
        return accountService.findAll();
    }

    @Operation(
            tags = {"Accounts"},
            summary = "Fetches Accounts for a specific client ID"
    )
    @GetMapping("/client/{clientId}")
    public List<AccountResponse> getByClientId(@PathVariable UUID clientId) {
        return accountService.findByClientId(clientId);
    }
}
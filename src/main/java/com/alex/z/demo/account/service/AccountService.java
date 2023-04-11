package com.alex.z.demo.account.service;

import com.alex.z.demo.account.dto.AccountResponse;
import com.alex.z.demo.account.model.Account;
import com.alex.z.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountCache accountCache;
    private final AccountRepository accountRepository;

    public List<AccountResponse> findAll(){
        return accountRepository.findAll().stream().map(this::toDto).toList();
    }

    public List<AccountResponse> findByClientId(UUID clientId){
        List<Account> accounts = accountCache.get(clientId);
        if (accounts == null) {
            accounts = accountRepository.findByClientId(clientId);
            accountCache.put(clientId, accounts);
        }
        return accounts.stream().map(this::toDto).toList();
    }

    private AccountResponse toDto(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .clientId(account.getClient().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .lastOperation(account.getLastOperation())
                .currency(account.getCurrency())
                .build();
    }

}

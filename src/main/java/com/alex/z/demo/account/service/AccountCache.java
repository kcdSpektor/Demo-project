package com.alex.z.demo.account.service;

import com.alex.z.demo.account.model.Account;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
 * Caches Accounts by Client ID
 */
@Component
public class AccountCache {
    private final Cache<UUID, List<Account>> cache;

    public AccountCache() {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build();
    }

    public List<Account> get(UUID key) {
        return cache.getIfPresent(key);
    }

    public void put(UUID key, List<Account> value) {
        cache.put(key, value);
    }
}
package com.alex.z.demo;

import com.alex.z.demo.account.model.Account;
import com.alex.z.demo.account.repository.AccountRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/*
 * This is a dummy class that crates random Account records DB on every app startup.
 * Since we are dropping the DB on every restart.
 */
public class DummyDataLoader {

    public DummyDataLoader(AccountRepository accountRepository) {
        Random rand = new Random();
        var currencies = new ArrayList<>(Currency.getAvailableCurrencies());
        Set<String> accountsNumbers = new HashSet<>();
        while(accountsNumbers.size()<20){
            accountsNumbers.add(""+rand.nextInt(99999999));
        }
        for (String accountsNumber : accountsNumbers) {
            createRandomAccount(accountRepository, accountsNumber, currencies);
        }
    }

    private void createRandomAccount(AccountRepository accountRepository, String accountNumber, List<Currency> currencies) {
        Random random = new Random();
        accountRepository.save(new Account(null, accountNumber, BigDecimal.valueOf(random.nextDouble(9999999)).setScale(2, RoundingMode.HALF_EVEN), currencies.get(random.nextInt(currencies.size())).getCurrencyCode(), getRandomDateTime()));
    }

    private LocalDateTime getRandomDateTime() {
        Random random = new Random();
        var year = random.nextInt(2020, 2024);
        var month = Month.values()[random.nextInt(Month.values().length)];
        var day = random.nextInt(1, 29);
        var hour = random.nextInt(0, 23);
        var minute = random.nextInt(0, 59);
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}

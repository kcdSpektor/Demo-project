package com.alex.z.demo;

import com.alex.z.demo.account.model.Account;
import com.alex.z.demo.account.repository.AccountRepository;
import com.alex.z.demo.client.model.Client;
import com.alex.z.demo.client.repository.ClientRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/*
 * This is a dummy class that crates random Client and Account records in DB on every app startup.
 * It exists only for demo purpose, since we are dropping the DB on every restart.
 */
public class DummyDataLoader {

    public DummyDataLoader(ClientRepository clientRepository, AccountRepository accountRepository) {
        List<String> fNames = Arrays.asList("Emily", "Liam", "Sophia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Charlotte", "William", "Amelia", "James", "Mia", "Benjamin", "Evelyn", "Lucas", "Harper", "Mason", "Isabella", "Ethan");
        List<String> lNames = Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin");
        Random rand = new Random();
        var currencies = new ArrayList<>(Currency.getAvailableCurrencies());
        Set<String> accountsNumbers = new HashSet<>();
        while(accountsNumbers.size()<20){
            accountsNumbers.add(""+rand.nextInt(99999999));
        }
        Client client = createRandomClient(clientRepository, fNames, lNames);
        for (String accountsNumber : accountsNumbers) {
            createRandomAccount(accountRepository, accountsNumber, currencies, client);
            if(rand.nextBoolean()){
                client = createRandomClient(clientRepository, fNames, lNames);
            }
        }
    }

    private void createRandomAccount(AccountRepository accountRepository, String accountNumber, List<Currency> currencies, Client client) {
        Random random = new Random();
        var account = new Account(accountNumber, BigDecimal.valueOf(random.nextDouble(9999999)).setScale(2, RoundingMode.HALF_EVEN), currencies.get(random.nextInt(currencies.size())).getCurrencyCode(), getRandomDateTime(), client);
        accountRepository.save(account);
    }

    private Client createRandomClient(ClientRepository clientRepository, List<String> fNames, List<String> lNames) {
        Random random = new Random();
        var client = new Client(fNames.get(random.nextInt(fNames.size())), lNames.get(random.nextInt(lNames.size())));
        return clientRepository.save(client);
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

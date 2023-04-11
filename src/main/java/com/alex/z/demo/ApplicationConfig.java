package com.alex.z.demo;

import com.alex.z.demo.account.repository.AccountRepository;
import com.alex.z.demo.client.repository.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    DummyStoredProcedureCreator dummyStoredProcedureCreator() {
        return new DummyStoredProcedureCreator();
    }

    @Bean
    DummyDataLoader dummyDataLoader(ClientRepository clientRepository, AccountRepository accountRepository) {
        return new DummyDataLoader(clientRepository, accountRepository);
    }

}

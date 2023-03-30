package com.alex.z.demo;

import com.alex.z.demo.account.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    DummyStoredProcedureCreator dummyStoredProcedureCreator() {
        return new DummyStoredProcedureCreator();
    }

    @Bean
    DummyDataLoader dummyDataLoader(AccountRepository accountRepository) {
        return new DummyDataLoader(accountRepository);
    }

}

package com.alex.z.demo.account.repository;


import com.alex.z.demo.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query(value = "select * from get_accounts()", nativeQuery = true)
    List<Account> findAll();

    @Query(value = "select * from get_accounts() where client_id = :clientId", nativeQuery = true)
    List<Account> findByClientId(@Param("clientId") UUID clientId);
}

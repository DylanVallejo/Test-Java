package com.tcs.operations.repository;

import com.tcs.operations.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select a.* from  Account a where a.account_number = :accountNumber", nativeQuery = true)
    Account findByAccountNumber(@Param("accountNumber") String accountNumber);

    @Query(value = "select a.* from Account  a where a.client_id = :clientId", nativeQuery = true)
    List<Account> findAccounts(@Param("clientId") Long clientId);
}

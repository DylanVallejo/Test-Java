package com.tcs.operations.service;

import com.tcs.operations.dto.AccountDto;
import com.tcs.operations.exceptions.ClientNotFoundException;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto, Long clientId) throws ClientNotFoundException;

    AccountDto updateBalance(AccountDto accountDto) throws ClientNotFoundException;

}

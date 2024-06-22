package com.tcs.operations.service.impl;

import com.tcs.operations.dto.AccountDto;
import com.tcs.operations.entity.Account;
import com.tcs.operations.entity.Client;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.mappers.Mapper;
import com.tcs.operations.repository.AccountRepository;
import com.tcs.operations.repository.ClientRepository;
import com.tcs.operations.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final Mapper mapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto, Long clientId) throws ClientNotFoundException {

        Optional<Client> client = getClient(clientId);
        if (client.isPresent()){
            Client clientDb =  client.get();
            Account account = mapper.accountDtoToAccount(accountDto, clientDb.getClient_id());
            Account createedAccount = accountRepository.save(account);
            return mapper.accountToAccountDto(createedAccount);
        } else {
            throw new ClientNotFoundException("Client whit id: " + clientId + " does not exist.");
        }
    }

    @Override
    public AccountDto updateBalance(AccountDto accountDto) throws ClientNotFoundException {
        Account actualAccount = accountRepository.findByAccountNumber(accountDto.getAccount_number());
        if (actualAccount != null){
            Account account = mapper.updateAccountBalance(actualAccount, accountDto);
            Account updatedAccount = accountRepository.save(account);
            return mapper.accountToAccountDto(updatedAccount);
        } else {
            throw new ClientNotFoundException("Client whit account_number : " + accountDto.getAccount_number() + " does not exist.");
        }
    }

    public Optional<Client> getClient(Long clientId){
        return clientRepository.findById(clientId);
    }

}

package com.tcs.operations.mappers;

import com.tcs.operations.dto.AccountDto;
import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.entity.Account;
import com.tcs.operations.entity.Client;
import com.tcs.operations.entity.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;


@Component
public class Mapper {

    public Client registerDtoToClient(RegisterDto registerDto){
        Client client = new Client();
        BeanUtils.copyProperties(registerDto,client);
        return client;
    }

    public PersonDto clientToPersonDto(Client client){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(client,personDto);
        return personDto;
    }

    public Client updateProperties(ClientDto clientDto, Client actualProperties){
        BeanUtils.copyProperties(clientDto, actualProperties, getNullPropertyNames(clientDto));
        return actualProperties;
    }


    public Account accountDtoToAccount(AccountDto accountDto, Long clientId){
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        account.setClient_id(clientId);
        return account;
    }

    public AccountDto accountToAccountDto(Account account){
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        return accountDto;

    }

    public Account updateAccountBalance(Account actualAccount, AccountDto accountDto){
        BeanUtils.copyProperties(accountDto,actualAccount, getNullPropertyNames(accountDto));
        return actualAccount;
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

}

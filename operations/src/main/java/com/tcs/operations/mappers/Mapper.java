package com.tcs.operations.mappers;

import com.tcs.operations.dto.*;
import com.tcs.operations.entity.Account;
import com.tcs.operations.entity.Client;
import com.tcs.operations.entity.Movement;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;
import java.time.LocalDateTime;
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


    public Movement movementDtoToMovement(MovementDto movementDto, Double balance, Long accountId){
        Movement movement = new Movement();
        BeanUtils.copyProperties(movementDto, movement, getNullPropertyNames(movementDto));
        movement.setMovement_date(LocalDateTime.now());
        movement.setBalance(balance);
        movement.setAccount_id(accountId);
        return movement;
    }

    public MovementDto movementToMovementDto(Movement movement){
        MovementDto movementDto = new MovementDto();
        BeanUtils.copyProperties(movement, movementDto);
        return movementDto;
    }


    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

}

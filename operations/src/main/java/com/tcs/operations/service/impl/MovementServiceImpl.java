package com.tcs.operations.service.impl;


import com.tcs.operations.dto.MovementDto;
import com.tcs.operations.entity.Account;
import com.tcs.operations.entity.Movement;
import com.tcs.operations.enums.Transaction;
import com.tcs.operations.exceptions.BalanceInsuficientException;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.exceptions.IncorrectValueException;
import com.tcs.operations.mappers.Mapper;
import com.tcs.operations.repository.AccountRepository;
import com.tcs.operations.repository.MovementRepository;
import com.tcs.operations.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl  implements MovementService {

    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;
    private final Mapper mapper;


    @Override
    public MovementDto transaction(MovementDto movementDto, Long accountId) throws BalanceInsuficientException, ClientNotFoundException, IncorrectValueException {

        if ( movementDto.getMovement_type().equals(Transaction.DEBIT)){
            return debit(movementDto, accountId);
        } else if (movementDto.getMovement_type().equals(Transaction.CREDIT)){
            return credit(movementDto, accountId);
        }else{
            throw new ClientNotFoundException("Account whit id: " + accountId +  "not found.");
        }
    }

    public Account findAccount(Long accountId){
        Optional<Account> accountDb = accountRepository.findById(accountId);
        return accountDb.orElse(null);
    }

    public MovementDto credit(MovementDto creditMovement, Long accountId) throws IncorrectValueException {
        Account accountDB = findAccount(accountId);
        if( creditMovement.getAmount() < 0){
            throw new IncorrectValueException("Credits only allows positive numbers.");
        } else {
            accountDB.setInitial_balance( accountDB.getInitial_balance()   + creditMovement.getAmount());
            accountRepository.save(accountDB);
            Movement movement  = mapper.movementDtoToMovement(creditMovement, accountDB.getInitial_balance(), accountId);
            Movement movementDb = movementRepository.save(movement);
            return mapper.movementToMovementDto(movementDb);
        }
    }

    public MovementDto debit(MovementDto creditMovement, Long accountId) throws BalanceInsuficientException, IncorrectValueException {
        Account accountDB = findAccount(accountId);
        if (accountDB.getInitial_balance() < creditMovement.getAmount()){
            throw  new BalanceInsuficientException("Current balanace is insuficient for the transaction" + accountDB.getInitial_balance());
        } else if( creditMovement.getAmount() > 0){
            throw new IncorrectValueException("Debits only allows negative numbers.");
        } else {
            accountDB.setInitial_balance( accountDB.getInitial_balance() -  Math.abs(creditMovement.getAmount()));
            accountRepository.save(accountDB);
            Movement movement  = mapper.movementDtoToMovement(creditMovement, accountDB.getInitial_balance(), accountId);
            Movement movementDb = movementRepository.save(movement);
            return mapper.movementToMovementDto(movementDb);
        }
    }


}

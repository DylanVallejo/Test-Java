package com.tcs.operations.service;

import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.MovementDto;
import com.tcs.operations.exceptions.BalanceInsuficientException;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.exceptions.IncorrectValueException;

import java.util.List;

public interface MovementService {

    MovementDto transaction(MovementDto movementDto, Long accountId) throws BalanceInsuficientException, ClientNotFoundException, IncorrectValueException;


    List<MovementDto> getAllMovements(ClientDto clientDto) throws ClientNotFoundException;

}

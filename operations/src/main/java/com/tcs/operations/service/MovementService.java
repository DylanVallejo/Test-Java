package com.tcs.operations.service;

import com.tcs.operations.dto.MovementDto;
import com.tcs.operations.exceptions.BalanceInsuficientException;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.exceptions.IncorrectValueException;

public interface MovementService {

    MovementDto transaction(MovementDto movementDto, Long accountId) throws BalanceInsuficientException, ClientNotFoundException, IncorrectValueException;

}

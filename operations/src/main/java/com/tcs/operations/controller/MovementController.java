package com.tcs.operations.controller;


import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.MovementDto;
import com.tcs.operations.exceptions.BalanceInsuficientException;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.exceptions.IncorrectValueException;
import com.tcs.operations.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @PostMapping("{accountId}")
    public MovementDto newMovement(@RequestBody MovementDto movementDto, @PathVariable Long accountId) throws BalanceInsuficientException, ClientNotFoundException, IncorrectValueException {
        return movementService.transaction(movementDto, accountId);
    }

    @GetMapping
    public List<MovementDto> getClientMovements(@RequestBody ClientDto clientDto) throws ClientNotFoundException {
        return movementService.getAllMovements(clientDto);
    }


}

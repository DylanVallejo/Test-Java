package com.tcs.operations.service.impl;


import com.tcs.operations.dto.MovementDto;
import com.tcs.operations.service.MovementService;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl  implements MovementService {

    @Override
    public MovementDto transaction(MovementDto movementDto) {
        return null;
    }


    public double credit(MovementDto creditMovement){
        return 0;
    }

    public double debit(MovementDto creditMovement){
        return 0;
    }


}

package com.tcs.operations.service;

import com.tcs.operations.dto.MovementDto;

public interface MovementService {

    MovementDto transaction(MovementDto movementDto);

}

package com.tcs.operations.mappers;



import com.tcs.operations.dto.MovementDto;
import com.tcs.operations.entity.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestMapper {

    MovementDto mapearMovementToMovementDto(Movement movement);

}

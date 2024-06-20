package com.tcs.operations.service;

import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface PersonService {

    PersonDto savePerson(RegisterDto registerDto);

}

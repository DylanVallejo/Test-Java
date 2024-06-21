package com.tcs.operations.service;

import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.exceptions.ClientNotFoundException;

public interface ClientService {

    PersonDto saveClient(RegisterDto registerDto1);

    PersonDto updateClient(ClientDto clientDto, Long clientId) throws ClientNotFoundException;

}

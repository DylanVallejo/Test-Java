package com.tcs.operations.service.impl;

import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.entity.Client;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.mappers.Mapper;
import com.tcs.operations.repository.ClientRepository;
import com.tcs.operations.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final  Mapper mapper;

    @Override
    public PersonDto saveClient(RegisterDto registerDto) {
        Client newClient = mapper.registerDtoToClient(registerDto);
        Client clientDB = clientRepository.save(newClient);
        return mapper.clientToPersonDto(clientDB);
    }

    @Override
    public PersonDto updateClient(ClientDto clientDto, Long clientId) throws ClientNotFoundException {
        Client  actualClient = clientRepository.findById(clientId).get();
        if(clientRepository.findById(clientId).isPresent()){
            Client updatedClient = mapper.updateProperties(clientDto, actualClient);
            Client clientDB = clientRepository.save(updatedClient);
            return mapper.clientToPersonDto(clientDB);
        } else {
            throw  new ClientNotFoundException("Client not found");
        }
    }

}

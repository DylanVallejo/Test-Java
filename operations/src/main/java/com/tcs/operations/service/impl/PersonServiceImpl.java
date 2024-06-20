package com.tcs.operations.service.impl;

import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.entity.Client;
import com.tcs.operations.entity.Person;
import com.tcs.operations.mappers.Mapper;
import com.tcs.operations.repository.ClientRepository;
import com.tcs.operations.repository.PersonRepository;
import com.tcs.operations.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private  PersonRepository personRepository;
    private ClientRepository clientRepository;
    private Mapper mapper;

    @Override
    public PersonDto savePerson(RegisterDto registerDto) {
        Person person = mapper.registerDtoToPerson(registerDto);
        Person personDB = personRepository.save(person);
        Client client = mapper.registerDtoToClient(registerDto);
        Client clientDB = clientRepository.save(client);
        return mapper.personToPersonDto(personDB);
    }

}

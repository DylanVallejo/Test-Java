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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
//    @Autowired
//    private  PersonRepository personRepository;
//    @Autowired
//    private ClientRepository clientRepository;
//    @Autowired
//    private Mapper mapper;
//
//    @Override
//    public PersonDto savePerson(RegisterDto registerDto) {
////        Person newPerson = mapper.registerDtoToPerson(registerDto);
////        Person personDB = personRepository.save(newPerson);
//        Client newClient = mapper.registerDtoToClient(registerDto);
//        Client clientDB = clientRepository.save(newClient);
////        return null;
//        return mapper.clientToPersonDto(clientDB);
//    }

}

package com.tcs.operations.mappers;

import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.entity.Client;
import com.tcs.operations.entity.Person;
import org.springframework.beans.BeanUtils;

public class Mapper {


    public Person registerDtoToPerson(RegisterDto registerDto){
        Person person = new Person();
        BeanUtils.copyProperties(registerDto, person);
        return person;
    }

    public PersonDto personToPersonDto(Person person){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person,personDto);
        return personDto;
    }

    public Client registerDtoToClient(RegisterDto registerDto){
        Client client = new Client();
        BeanUtils.copyProperties(registerDto,client);
        return client;
    }


}

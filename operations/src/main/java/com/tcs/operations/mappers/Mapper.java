package com.tcs.operations.mappers;

import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.entity.Client;
import com.tcs.operations.entity.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;


@Component
public class Mapper {


//    public Person registerDtoToPerson(RegisterDto registerDto){
//        Person person = new Person();
//        BeanUtils.copyProperties(registerDto, person);
//        return person;
//    }

//    public PersonDto personToPersonDto(Person person){
//        PersonDto personDto = new PersonDto();
//        BeanUtils.copyProperties(person,personDto);
//        return personDto;
//    }

    public Client registerDtoToClient(RegisterDto registerDto){
        Client client = new Client();
        BeanUtils.copyProperties(registerDto,client);
        return client;
    }

    public PersonDto clientToPersonDto(Client client){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(client,personDto);
        return personDto;
    }

//    public Client clientDtoToClient(ClientDto clientDto){
//        Client client = new Client();
//        BeanUtils.copyProperties(clientDto, client);
//        return client;
//    }


    public Client updateProperties(ClientDto clientDto, Client actualProperties){
        BeanUtils.copyProperties(clientDto, actualProperties, getNullPropertyNames(clientDto));
        return actualProperties;
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

}

package com.tcs.operations.controller;

import com.tcs.operations.dto.ClientDto;
import com.tcs.operations.dto.PersonDto;
import com.tcs.operations.dto.RegisterDto;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    private PersonDto createClient(@RequestBody RegisterDto registerDto){
        return clientService.saveClient(registerDto);
    }

    @PutMapping("/{clientId}")
    private PersonDto updateClient(@RequestBody ClientDto clientDto, @PathVariable Long clientId) throws ClientNotFoundException {
        return clientService.updateClient(clientDto,clientId);
    }

}

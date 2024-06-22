package com.tcs.operations.controller;


import com.tcs.operations.dto.AccountDto;
import com.tcs.operations.exceptions.ClientNotFoundException;
import com.tcs.operations.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/{clientId}")
    public AccountDto createAccount(@PathVariable Long clientId, @RequestBody AccountDto accountDto) throws ClientNotFoundException {
        return accountService.createAccount(accountDto, clientId);
    }

    @PutMapping
    public AccountDto updateBalance(@RequestBody AccountDto accountDto) throws ClientNotFoundException{
        return accountService.updateBalance(accountDto);
    }

}

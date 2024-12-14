package com.example.EduSprint.controller;

import com.example.EduSprint.repository.AccountRepository;
import com.example.EduSprint.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    public final AccountRepository accountRepository;
    public final AccountService accountService;

    public AccountController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/check-account")
    public boolean checkAccount(@RequestParam String email, @RequestParam String name) {
        if (accountRepository.existsByEmail(email)) {
            return true;
        }

        if (accountService.createAccount(email, name)) {
            return true;
        } else {
            return false;
        }
    }
}

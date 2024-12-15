package com.example.EduSprint.controller;

import com.example.EduSprint.repository.AccountRepository;
import com.example.EduSprint.service.AccountObjectiveService;
import com.example.EduSprint.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    public final AccountRepository accountRepository;
    public final AccountObjectiveService accountObjectiveService;
    public final AccountService accountService;

    public AccountController(AccountRepository accountRepository, AccountService accountService, AccountObjectiveService accountObjectiveService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.accountObjectiveService = accountObjectiveService;
    }

    @PostMapping("/check-account")
    public ResponseEntity<String> checkAccount(@RequestParam String email, @RequestParam String name) {
        if (accountRepository.existsByEmail(email)) {
            return new ResponseEntity<>("Account exists", HttpStatus.OK);
        }

        boolean accountCreated = accountService.createAccount(email, name);

        if (accountCreated) {
            return new ResponseEntity<>("Account created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Account creation failed", HttpStatus.BAD_REQUEST);
        }
    }
}

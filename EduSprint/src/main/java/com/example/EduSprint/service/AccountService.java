package com.example.EduSprint.service;

import com.example.EduSprint.entity.Account;
import com.example.EduSprint.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountObjectiveService accountObjectiveService;

    public AccountService(AccountRepository accountRepository, AccountObjectiveService accountObjectiveService) {
        this.accountRepository = accountRepository;
        this.accountObjectiveService = accountObjectiveService;
    }

    @Transactional
    public boolean createAccount(String email, String name) {
        try {
            Account account = new Account();
            account.setEmail(email);
            account.setName(name);

            accountRepository.save(account);
            accountObjectiveService.initializeAccountObjectives(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

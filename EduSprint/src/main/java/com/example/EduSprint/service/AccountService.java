package com.example.EduSprint.service;

import com.example.EduSprint.entity.Account;
import com.example.EduSprint.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long getAccountIdByEmail(String email) {
        return accountRepository.findAccountByEmail(email).get().getAccountId();
    }

    public boolean createAccount(String email, String name) {
        try {
            Account account = new Account();
            account.setEmail(email);
            account.setName(name);
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

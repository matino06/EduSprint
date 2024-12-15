package com.example.EduSprint.service;

import com.example.EduSprint.entity.Account;
import com.example.EduSprint.entity.AccountObjective;
import com.example.EduSprint.entity.LearningObjective;
import com.example.EduSprint.repository.AccountObjectiveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class AccountObjectiveService {

    public final AccountObjectiveRepository accountObjectiveRepository;
    public final LearningObjectiveService learningObjectiveService;

    public AccountObjectiveService(AccountObjectiveRepository accountObjectiveRepository, LearningObjectiveService learningObjectiveService) {
        this.accountObjectiveRepository = accountObjectiveRepository;
        this.learningObjectiveService = learningObjectiveService;
    }

    @Transactional
    public boolean initializeAccountObjectives(Account account) {
        try {
            List<LearningObjective> objectives = learningObjectiveService.findAll();
            for (LearningObjective objective : objectives) {
                AccountObjective accountObjective = new AccountObjective();
                accountObjective.setAccount(account);
                accountObjective.setObjective(objective);
                accountObjective.setEf(BigDecimal.valueOf(2.5));
                accountObjective.setI((short) 0);
                accountObjective.setN((short) 0);
                accountObjective.setLastSolvedDate(Instant.now());

                accountObjectiveRepository.save(accountObjective);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

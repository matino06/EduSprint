package com.example.EduSprint.controller;

import com.example.EduSprint.repository.TaskRepository;
import com.example.EduSprint.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;
    private final AccountService accountService;

    public TaskController(TaskRepository taskRepository, AccountService accountService) {
        this.taskRepository = taskRepository;
        this.accountService = accountService;
    }

    @GetMapping("/{email}")
    Long getTask(@PathVariable String email) {
        return accountService.getAccountIdByEmail(email);
    }
}

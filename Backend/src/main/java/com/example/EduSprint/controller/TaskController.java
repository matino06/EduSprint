package com.example.EduSprint.controller;

import com.example.EduSprint.entity.Account;
import com.example.EduSprint.entity.LearningObjective;
import com.example.EduSprint.entity.Task;
import com.example.EduSprint.repository.TaskRepository;
import com.example.EduSprint.service.AccountObjectiveService;
import com.example.EduSprint.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;
    private final AccountService accountService;
    private final AccountObjectiveService accountObjectiveService;

    public TaskController(TaskRepository taskRepository, AccountService accountService, AccountObjectiveService accountObjectiveService) {
        this.taskRepository = taskRepository;
        this.accountService = accountService;
        this.accountObjectiveService = accountObjectiveService;
    }

    @GetMapping("/get-new-task")
    public ResponseEntity getNewTask(@RequestParam String email) {
        Account account = accountService.getAccount(email);

        LearningObjective nextLearningObjective = accountObjectiveService.getNextLearningObjective(account);

        if (nextLearningObjective == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(nextLearningObjective);
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

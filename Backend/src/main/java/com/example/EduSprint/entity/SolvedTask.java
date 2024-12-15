package com.example.EduSprint.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "solved_task")
public class SolvedTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "q", nullable = false)
    private Short q;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "solved_date", nullable = false)
    private LocalDateTime solvedDate;

    public SolvedTask() {
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Short getQ() {
        return q;
    }

    public void setQ(Short q) {
        this.q = q;
    }

    public LocalDateTime getSolvedDate() {
        return solvedDate;
    }

    public void setSolvedDate(LocalDateTime solvedDate) {
        this.solvedDate = solvedDate;
    }

    @Override
    public String toString() {
        return "SolvedTask{" +
                "id=" + id +
                ", account=" + account +
                ", task=" + task +
                ", q=" + q +
                ", solvedDate=" + solvedDate +
                '}';
    }
}
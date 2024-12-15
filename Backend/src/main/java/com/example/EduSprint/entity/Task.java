package com.example.EduSprint.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", unique = true, nullable = false)
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "objective_id", nullable = false)
    private LearningObjective objective;

    @Column(name = "task_text_1", nullable = false)
    private String taskText1;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "task_text_2")
    private String taskText2;

    @Column(name = "solution", nullable = false)
    private String solution;

    public Task() {
    }

    public Integer getId() {
        return taskId;
    }

    public LearningObjective getObjective() {
        return objective;
    }

    public void setObjective(LearningObjective objective) {
        this.objective = objective;
    }

    public String getTaskText1() {
        return taskText1;
    }

    public void setTaskText1(String taskText1) {
        this.taskText1 = taskText1;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTaskText2() {
        return taskText2;
    }

    public void setTaskText2(String taskText2) {
        this.taskText2 = taskText2;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", objective=" + objective +
                ", taskText1='" + taskText1 + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", taskText2='" + taskText2 + '\'' +
                ", solution='" + solution + '\'' +
                '}';
    }
}
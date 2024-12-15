package com.example.EduSprint.service;

import com.example.EduSprint.entity.LearningObjective;
import com.example.EduSprint.repository.LearningObjectiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningObjectiveService {

    public final LearningObjectiveRepository learningObjectiveRepository;

    public LearningObjectiveService(LearningObjectiveRepository learningObjectiveRepository) {
        this.learningObjectiveRepository = learningObjectiveRepository;
    }

    public final List<LearningObjective> findAll() {
        return learningObjectiveRepository.findAll();
    }
}

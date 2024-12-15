package com.example.EduSprint.repository;

import com.example.EduSprint.entity.FieldOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudy, Long> {
}

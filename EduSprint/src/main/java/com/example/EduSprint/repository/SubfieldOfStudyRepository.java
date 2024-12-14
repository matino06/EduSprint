package com.example.EduSprint.repository;

import com.example.EduSprint.entity.SubfieldOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubfieldOfStudyRepository extends JpaRepository<SubfieldOfStudy, Long> {
}

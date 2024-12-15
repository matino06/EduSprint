package com.example.EduSprint.repository;

import com.example.EduSprint.entity.AccountObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountObjectiveRepository extends JpaRepository<AccountObjective, Long> {
}

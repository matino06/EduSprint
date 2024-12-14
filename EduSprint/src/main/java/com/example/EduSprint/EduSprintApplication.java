package com.example.EduSprint;

import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.EduSprint.repository.LearningObjectiveRepository;


@SpringBootApplication
public class EduSprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduSprintApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LearningObjectiveRepository repository) {
		return args -> {

			System.out.println(repository.findById(Long.valueOf(3)));
		};
	}
}

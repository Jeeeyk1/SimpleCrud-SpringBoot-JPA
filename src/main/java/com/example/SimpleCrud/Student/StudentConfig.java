package com.example.SimpleCrud.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			StudentModel jake = new StudentModel(1L, "Jake", "jake@yahoo.com", 21, LocalDate.of(2001, 06, 05));
			StudentModel abby = new StudentModel(1L, "Abby", "Abby@yahoo.com", 21, LocalDate.of(2001, 10, 15));
			repository.saveAll(List.of(jake, abby));
		};
	}
}

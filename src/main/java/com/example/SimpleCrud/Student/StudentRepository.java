package com.example.SimpleCrud.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

	@Query("select s from StudentModel s where s.email =?1")
	Optional<StudentModel> findStudentByEmail(String email);


}

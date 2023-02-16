package com.example.SimpleCrud.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public List<StudentModel> getStudents() {
		return studentRepository.findAll();
	}

	public void addStudent(StudentModel studentModel) {
		Optional<StudentModel> studentByEmail = studentRepository.findStudentByEmail(studentModel.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("Email Already exist");
		}
		studentRepository.save(studentModel);
	}

	public void deleteStudent(Long id) {
		Boolean isExist = studentRepository.existsById(id);

		if (!isExist) {
			throw new IllegalStateException("User with id number " + id + " not found");

		}
		studentRepository.deleteById(id);
	}
	@Transactional
	public void updateStudent(Long id, String name, String email) {
		StudentModel student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("student with id "+ id + " not found"  ));
		
		if(name !=null&& name.length()>0 && !Objects.equals(name, student.getName())) {
			student.setName(name);
			
		}
		if(email !=null && email.length()> 0 && !Objects.equals(student.getEmail(), email)) {
			student.setEmail(email);
		}
		
		
	}
}

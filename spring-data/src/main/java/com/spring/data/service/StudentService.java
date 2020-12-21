package com.spring.data.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.entities.Student;
import com.spring.data.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void updateStudent(Integer studentId, Student student) {
		Optional<Student> studentResult = studentRepository.findById(studentId);
		if (studentResult.isPresent()) {
			student.setId(studentId);
			studentRepository.save(student);
		}
	}
	
	public void registerStudent(Student student) {
		studentRepository.save(student);
	}

}

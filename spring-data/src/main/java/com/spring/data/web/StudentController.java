package com.spring.data.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.entities.Student;
import com.spring.data.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PutMapping("/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId")Integer id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		studentService.registerStudent(student);
		return new ResponseEntity<String>("Created", HttpStatus.CREATED);
	}
}

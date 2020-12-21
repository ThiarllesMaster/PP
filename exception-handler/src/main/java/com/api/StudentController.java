package com.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.exception.ControlAdviceException;
import com.exception.StudentException;
import com.model.StudentModel;
import com.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController extends ControlAdviceException {
	
	@Autowired
	StudentService studentService;

	@GetMapping
	public ResponseEntity<StudentModel> getStudent() throws StudentException {
		return new ResponseEntity<>(studentService.getStudent(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> registerStudent(@Valid @RequestBody StudentModel student) {
		return new ResponseEntity<String>("Deu certo", HttpStatus.OK);
	}
	

}

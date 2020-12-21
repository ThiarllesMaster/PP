package com.service;

import org.springframework.stereotype.Service;

import com.exception.StudentException;
import com.model.StudentModel;

@Service
public class StudentService {

	public StudentModel getStudent() throws StudentException {
		StudentModel studentModel = new StudentModel();
		studentModel.setName("Student Name");
		
		if (studentModel.getName().equals("Student Name")) {
			try {
				long x = 10 / 0;
			} catch (Exception e) {
				throw new StudentException("Erro ao calcular a nota", e);
			}
		}
		
		return studentModel;
	}
}

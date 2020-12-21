package com.model;

import javax.validation.constraints.NotNull;

public class StudentModel {
	
	@NotNull(message = "O nome não pode ser nulo")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

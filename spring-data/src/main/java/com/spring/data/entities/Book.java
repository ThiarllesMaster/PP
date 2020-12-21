package com.spring.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	String title;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
	
	@PostPersist
	public void postPersist() {
		System.out.println("Registo feito");
	}
}

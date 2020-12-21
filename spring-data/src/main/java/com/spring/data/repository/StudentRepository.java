package com.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.data.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "select st from Student st inner join st.books b where b.student.nameStudent = ?1")
	public List<Student> findBooksByStudentName(String studentName);
}

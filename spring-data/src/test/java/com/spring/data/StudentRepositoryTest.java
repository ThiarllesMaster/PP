package com.spring.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.data.entities.Book;
import com.spring.data.entities.Student;
import com.spring.data.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	void test() {
		Student student = new Student();
		student.setNameStudent("Rafinha");

		Book book = new Book();
		book.setTitle("Livro do Aluno");
		book.setStudent(student);
		
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		
		student.setBooks(books);
		
		entityManager.persist(student);
		
		List<Student> students = studentRepository.findBooksByStudentName(student.getNameStudent());
		System.out.println(students.size());
		
		
	}

}

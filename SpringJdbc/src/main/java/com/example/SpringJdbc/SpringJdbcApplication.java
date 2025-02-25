package com.example.SpringJdbc;

import com.example.SpringJdbc.model.Student;
import com.example.SpringJdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(SpringJdbcApplication.class, args);

		Student s=context.getBean(Student.class);
		s.setRollno(1);
		s.setName("Dhruvik");
		s.setMarks(90);

		StudentService ss=context.getBean(StudentService.class);
            ss.addStudent(s);

		List<Student> s1=ss.getStudents();
		System.out.println(s1);


	}

}

package com.example.springDataJPA;

import com.example.springDataJPA.model.Student;
import com.example.springDataJPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);

		StudentRepo studentRepo=context.getBean(StudentRepo.class);

		//save the data
//		Student student=context.getBean(Student.class);
//		Student student1=context.getBean(Student.class);
//		Student student2=context.getBean(Student.class);
//
//		student.setName("Amit");
//		student.setMarks(90);
//		student.setRollno(101);
//		student1.setName("Raj");
//		student1.setMarks(80);
//		student1.setRollno(102);
//		student2.setName("Meet");
//		student2.setMarks(70);
//		student2.setRollno(103);
//
//		studentRepo.save(student);
//		studentRepo.save(student1);
//		studentRepo.save(student2);

		//find all
//		studentRepo.findAll().forEach(System.out::println);
//		System.out.println(studentRepo.findAll());

		//find by id(Return optional object)

//     	Optional<Student> s=studentRepo.findById(101);
//		System.out.println(s.orElse(new Student()));


//		System.out.println(studentRepo.findById(101));
//		System.out.println(studentRepo.findById(102));
//		System.out.println(studentRepo.findById(103));

        //search by name
//		studentRepo.findByName("Dhruvik");
//		studentRepo.findByMarks(90);
//		studentRepo.findByMarksGreaterThan(80);

		//update and delete
		//updated
//		studentRepo.save(student2);
//      studentRepo.delete(student2);





	}

}

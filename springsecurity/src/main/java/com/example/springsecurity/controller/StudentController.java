package com.example.springsecurity.controller;

import com.example.springsecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

  List<Student> students=new ArrayList<>(List.of(
          new Student(1,"dhruvik","Java"),
          new Student(2,"yuval","Electronics"),
          new Student(3,"meril","python")
  ));

  @GetMapping("csrf-token")
  public CsrfToken getCsrfToken(HttpServletRequest req){
       return (CsrfToken) req.getAttribute("_csrf");
  }

  @GetMapping("students")
  public List<Student> getStudents(){
      return students;
  }

  @PostMapping("students")
  public void addStudent(@RequestBody Student student){
      students.add(student);
  }

}

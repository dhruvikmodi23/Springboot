package com.example.SpringJdbc.service;

import com.example.SpringJdbc.model.Student;
import com.example.SpringJdbc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
     private StudentRepo sr;

    public StudentRepo getSr() {
        return sr;
    }

    @Autowired
    public void setSr(StudentRepo sr) {
        this.sr = sr;
    }

    public void addStudent(Student s) {
       System.out.println("Student added successfully");
       sr.save(s);
    }

    public List<Student> getStudents() {
        return sr.findall();
    }
}

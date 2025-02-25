package com.example.SpringJdbc.repo;

import com.example.SpringJdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s) {
        System.out.println("Student saved successfully in database");
//        String sql="insert into student (rollno, name, marks) values(?,?,?)";
//        int rows=jdbcTemplate.update(sql,s.getRollno(),s.getName(),s.getMarks());
//        System.out.println("rows affected: "+rows);
    }

    public List<Student> findall() {

         String sql="select * from student";
        RowMapper<Student> s1=new RowMapper<Student>() {
            @Override
            public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Student s=new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };
        return jdbcTemplate.query(sql, s1);

    }
}

package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Student student = new Student();
        student.setStudentFName(rs.getString("FNAME"));
        student.setStudentLName(rs.getString("LNAME"));
        return student;
    }
}

package com.example.demo.dao;

import com.example.demo.model.StudentClassCount;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCountMapper implements RowMapper<StudentClassCount> {
    @Override
    public StudentClassCount mapRow(ResultSet rs, int index) throws SQLException {
        StudentClassCount count = new StudentClassCount();
        count.setCourseName(rs.getString("COURSENAME"));
        count.setStudentCount(rs.getInt("NUMSTUDENTS"));
        return count;
    }
}

package com.example.demo.dao;

import com.example.demo.model.Course;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int index) throws SQLException {
        Course course = new Course();
        course.setCourseName(rs.getString("COURSENAME"));
        course.setCourseDesc(rs.getString("COURSEDESC"));
        return course;
    }
}

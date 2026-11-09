package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolDaoImpl implements SchoolDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SchoolDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> allStudents() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE

        return jdbcTemplate.query(sql, new StudentMapper());    }

    @Override
    public List<Course> csCourses() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        return jdbcTemplate.query(sql, new CourseMapper());
    }

    @Override
    public List<TeacherCount> teacherCountByDept() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        return jdbcTemplate.query(sql, new TeacherCountMapper());
    }

    @Override
    public List<StudentClassCount> studentsPerClass() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        return jdbcTemplate.query(sql, new StudentCountMapper());
    }


    @Override
    public void addStudent() {
        // YOUR CODE STARTS HERE
        // give student ID of 10

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        System.out.println(jdbcTemplate.update(sql));

    }

    @Override
    public void addStudentToClass() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        jdbcTemplate.update(sql);
    }

    @Override
    public void editCourseDescription() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteTeacher() {
        // YOUR CODE STARTS HERE

        String sql = """
        
        """;

        // YOUR CODE ENDS HERE
        jdbcTemplate.update(sql);
    }

    
    // DO NOT CHANGE THE FOLLOWING QUERIES

    @Override
    public List<Teacher> listAllTeachers() {
        String sql = "Select * from Teacher;";
        return jdbcTemplate.query(sql, new TeacherMapper());
    }

    @Override
    public List<Student> studentsCS148() {
        String sql = """
                select fname, lname
                from student s\s
                join course_student cs on s.sid = cs.student_id
                where course_id = 1;""";
        return jdbcTemplate.query(sql, new StudentMapper());
    }
}

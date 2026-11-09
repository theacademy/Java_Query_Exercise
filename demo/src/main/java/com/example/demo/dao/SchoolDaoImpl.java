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

        String sql = "select fname, lname from student\n" +
                "order by lName, fname;";

        // YOUR CODE ENDS HERE

        return jdbcTemplate.query(sql, new StudentMapper());    }

    @Override
    public List<Course> csCourses() {
        // YOUR CODE STARTS HERE

        String sql = "select courseName, courseDesc "
                + "from course "
                + "where courseName like 'CS%'";

        // YOUR CODE ENDS HERE
        return jdbcTemplate.query(sql, new CourseMapper());
    }

    @Override
    public List<TeacherCount> teacherCountByDept() {
        // YOUR CODE STARTS HERE

        String sql = """
                select dept, count(dept) as teacherCount
                from teacher
                group by dept;""";

        // YOUR CODE ENDS HERE
        return jdbcTemplate.query(sql, new TeacherCountMapper());
    }

    @Override
    public List<StudentClassCount> studentsPerClass() {
        // YOUR CODE STARTS HERE

        String sql = """
                select courseName, count(course_id) as numStudents
                from student s
                join course_student cs on s.sid = cs.student_id
                join course c on cs.course_id = c.cid
                group by courseName
                order by courseName;""";

        // YOUR CODE ENDS HERE
        return jdbcTemplate.query(sql, new StudentCountMapper());
    }


    @Override
    public void addStudent() {
        // YOUR CODE STARTS HERE
        // give student ID of 10

        String sql = "insert into student(sid, fname, lname) values(10, 'Robert', 'Dylan');";

        // YOUR CODE ENDS HERE
        System.out.println(jdbcTemplate.update(sql));

    }

    @Override
    public void addStudentToClass() {
        // YOUR CODE STARTS HERE

        String sql = "insert into course_student(student_id, course_id) values (10,1);";

        // YOUR CODE ENDS HERE
        jdbcTemplate.update(sql);
    }

    @Override
    public void editCourseDescription() {
        // YOUR CODE STARTS HERE

        String sql = "update course set courseDesc = 'Advanced Python with Flask' where cid = 4;";

        // YOUR CODE ENDS HERE
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteTeacher() {
        // YOUR CODE STARTS HERE

        String sql = "delete from teacher where tid = 7;";

        // YOUR CODE ENDS HERE
        jdbcTemplate.update(sql);
    }

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

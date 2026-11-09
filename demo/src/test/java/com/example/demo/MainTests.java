package com.example.demo;

import com.example.demo.dao.SchoolDao;
import com.example.demo.dao.SchoolDaoImpl;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentClassCount;
import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class MainTests {

    private final SchoolDao dao;

    @Autowired
    public MainTests(JdbcTemplate jdbcTemplate) {
        dao = new SchoolDaoImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Test if Robert Dylan was added to course CS148")
    void addStudentToCourse() {
        dao.addStudent();
        dao.addStudentToClass();

        List<Student> students = dao.studentsCS148();
        assertEquals(7, students.size());

        boolean foundDylan = students.stream()
                .anyMatch(student -> "Dylan".equals(student.getStudentLName()));

        assertTrue(foundDylan);
    }

    @Test
    @DisplayName("Test student count by class")
    void testStudentCounts() {
        List<StudentClassCount> studentCounts = dao.studentsPerClass();

        assertEquals(7, studentCounts.size());

        for (StudentClassCount sc : studentCounts) {
            if ("CS305".equals(sc.getCourseName().trim())) {
                assertEquals(4, sc.getStudentCount());
            }
            if ("CS148".equals(sc.getCourseName().trim())) {
                assertEquals(6, sc.getStudentCount());
            }
        }
    }

    @Test
    @DisplayName("Test for all students sorted by last name")
    void ReturnAllStudentTests() {
        List<Student> students = dao.allStudents();

        assertEquals(8, students.size());
        assertEquals("Brown", students.get(0).getStudentLName());
    }

    @Test
    @DisplayName("Test for all Computer Science Courses")
    void GetAllComputerSciCourses() {
        List<Course> courses = dao.csCourses();

        assertEquals(9, courses.size());
    }

    @Test
    @DisplayName("Test correct number of departments")
    void GetTeacherCountByDept() {
        List<TeacherCount> tc = dao.teacherCountByDept();

        assertEquals(2, tc.size());
    }

    @Test
    @DisplayName("Test correct Departments")
    void GetTeacherCountByDept2() {
        List<TeacherCount> tc = dao.teacherCountByDept();

        boolean hasEnglish = tc.stream()
                .anyMatch(x -> x.getDept() != null && x.getDept().contains("English"));
        boolean hasComputerScience = tc.stream()
                .anyMatch(x -> x.getDept() != null && x.getDept().contains("Computer Science"));

        assertTrue(hasEnglish);
        assertTrue(hasComputerScience);
    }

    @Test
    @DisplayName("Test if teacher (Carroll) still exists and RecordSet decreased by 1")
    void deleteTeacher() {
        dao.deleteTeacher();

        List<Teacher> teachers = dao.listAllTeachers();
        assertEquals(9, teachers.size());
        assertFalse(teachers.stream().anyMatch(ts -> "Carroll".equalsIgnoreCase(ts.getTeacherLName())));
    }

    @Test
    @DisplayName("Test if name updated to Advanced Python with Flask for CS305")
    void editCourseName() {
        dao.editCourseDescription();

        List<Course> courses = dao.csCourses();
        assertTrue(courses.stream().anyMatch(course ->
                course.getCourseDesc() != null && course.getCourseDesc().contains("Advanced Python with Flask")));
        assertTrue(courses.stream().anyMatch(course -> "CS305".equals(course.getCourseName())));
    }
}


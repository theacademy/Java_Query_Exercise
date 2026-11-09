package com.example.demo.dao;

import com.example.demo.model.Teacher;
import org.springframework.jdbc.core.RowMapper;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Teacher teacher = new Teacher();
        teacher.setTeacherFName(rs.getString("TFNAME"));
        teacher.setTeacherLName(rs.getString("TLNAME"));
        return teacher;
    }
}

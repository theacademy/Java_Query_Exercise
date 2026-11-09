package com.example.demo.dao;

import com.example.demo.model.TeacherCount;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherCountMapper implements RowMapper<TeacherCount> {

    @Override
    public TeacherCount mapRow(ResultSet rs, int rowNum) throws SQLException {
        TeacherCount count = new TeacherCount();
        count.setDept(rs.getString("DEPT"));
        count.setCount(rs.getInt("TEACHERCOUNT"));
        return count;
    }
}

package com.xiaoxin.dao.impl;

import com.xiaoxin.dao.StudentDao;
import com.xiaoxin.domain.Student;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类，Spring jdbcTemplate方式实现
 * @author xiaoxin Liao
 * @date 2018/2/9
 */
@Component
public class StudentDaoSpringJdbcImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        String sql = "SELECT id,name,age FROM spring_data";
        final List<Student> list = new ArrayList<Student>();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                list.add(student);
            }
        });
        return list;
    }

    @Override
    public int save(Student student) {
        String sql = "INSERT INTO spring_data(name,age) VALUE(?,?)";
        int num = jdbcTemplate.update(sql,new java.lang.Object[]{student.getName(),student.getAge()});
        return num;
    }
}

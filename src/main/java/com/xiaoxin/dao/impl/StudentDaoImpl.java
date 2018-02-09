package com.xiaoxin.dao.impl;

import com.xiaoxin.dao.StudentDao;
import com.xiaoxin.domain.Student;
import com.xiaoxin.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类，传统jdbc方式实现
 * @author xiaoxin Liao
 * @date 2018/2/9
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> queryAll() {
        List<Student> list = new ArrayList<Student>();
        Connection connection = JDBCUtil.getConnection();
        if (connection != null) {
            String sql = "SELECT id,name,age FROM spring_data";
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                Student student = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setAge(age);
                    list.add(student);
                }
                return list;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.release(resultSet, preparedStatement, connection);
            }
        }
        return list;
    }

    @Override
    public int save(Student student) {
        Connection connection = JDBCUtil.getConnection();
        if (connection != null) {
            String sql = "INSERT INTO spring_data(name,age) VALUE(?,?)";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                int effectedNum = preparedStatement.executeUpdate();
                return effectedNum;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.release(null, preparedStatement, connection);
            }
        }
        return 0;
    }
}

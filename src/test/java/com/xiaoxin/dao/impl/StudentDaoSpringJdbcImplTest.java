package com.xiaoxin.dao.impl;

import com.xiaoxin.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xiaoxin Liao
 * @date 2018/2/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class StudentDaoSpringJdbcImplTest {

    @Autowired
    private StudentDaoSpringJdbcImpl studentDao;
    @Test
    public void queryAll() throws Exception {
         List<Student> studentList = studentDao.queryAll();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
        Assert.assertTrue(studentList.size()>0);
    }

    @Test
    public void save() throws Exception {
        Student student  = new Student();
        student.setName("LUBAN");
        student.setAge(16);
        int num = studentDao.save(student);
        Assert.assertEquals(1,num);
    }

}
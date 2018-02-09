package com.xiaoxin.dao.impl;

import com.xiaoxin.dao.StudentDao;
import com.xiaoxin.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xiaoxin Liao
 * @date 2018/2/9
 */
public class StudentDaoImplTest {
    @Test
    public void save() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("GUANYU");
        student.setAge(18);
        int effectedNum =  studentDao.save(student);
        System.out.println("Num:" + effectedNum);
        assertEquals(1,effectedNum);
    }

    @Test
    public void queryAll() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.queryAll();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
        Assert.assertTrue(studentList.size()>0);
    }


}
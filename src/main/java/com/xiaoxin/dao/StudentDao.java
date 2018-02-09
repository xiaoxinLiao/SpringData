package com.xiaoxin.dao;

import com.xiaoxin.domain.Student;

import java.util.List;

/**
 * StudentDao 访问接口
 *
 * @author xiaoxin Liao
 * @date 2018/2/9
 */
public interface StudentDao {
    /**
     * 查询所有Student
     *
     * @return
     */
    List<Student> queryAll();

    /**
     * 保存学生
     * @param student
     * @return 1：保存成功， 0: 保存失败
     */
    int save(Student student);
}

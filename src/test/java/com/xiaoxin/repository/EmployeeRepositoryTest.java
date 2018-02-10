package com.xiaoxin.repository;

import com.xiaoxin.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-data.xml")
public class EmployeeRepositoryTest {
    @Test
    public void findAll() throws Exception {
        List<Employee> employeeList = repository.findAllByNameIsNotNullOrderByAge();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size()>0);
    }


    @Autowired
    private EmployeeRepository repository;

    @Test
    public void findByName() throws Exception {
        Employee employee = repository.findByName("LUBAN");
        System.out.println(employee);
        Assert.assertNotNull(employee);
    }

}
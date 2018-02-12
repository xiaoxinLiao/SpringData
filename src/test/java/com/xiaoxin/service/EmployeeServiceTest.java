package com.xiaoxin.service;

import com.xiaoxin.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-data.xml")
public class EmployeeServiceTest {
    @Test
    public void pageAndSortAndAgeLessThan() throws Exception {
        service.pageAndSortAndAgeLessThan();
    }

    @Test
    public void exist() throws Exception {
        Assert.assertTrue(service.exist(1));
    }

    @Test
    public void findById() throws Exception {
        List<Employee> employees = service.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Assert.assertNotNull(employees);
    }

    @Test
    public void pageAndSort() throws Exception {
        service.pageAndSort();
    }

    @Test
    public void page() throws Exception {
        service.page();
    }

    @Test
    public void saveAll() throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setAge(18 + i);
            employee.setName("page" + i);
            employees.add(employee);
        }

        service.saveAll(employees);
    }

    @Autowired
    private EmployeeService service;

    @Test
    public void updateAgeById() throws Exception {
        boolean success = service.updateAgeById(1, 10);
        System.out.println(success);
        assertEquals(true, success);
    }

}
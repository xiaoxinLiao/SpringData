package com.xiaoxin.repository;

import com.xiaoxin.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-data.xml")
public class EmployeeRepositoryTest {

    @Test
    public void getCount() throws Exception {
        long count = repository.getCount();
        System.out.println("count=" + count);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void queryLike2() throws Exception {
        List<Employee> employeeList = repository.queryLike2("test1");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);

    }

    @Test
    public void queryLike1() throws Exception {
        List<Employee> employeeList = repository.queryLike1("test");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);
    }

    @Test
    public void queryParams2() throws Exception {
        List<Employee> employeeList = repository.queryParams2("LUBAN", 18);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);

    }

    @Test
    public void queryParams1() throws Exception {
        List<Employee> employeeList = repository.queryParams1("test2", 20);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);
    }

    @Test
    public void getEmployeeByMaxId() throws Exception {
        Employee employee = repository.getEmployeeByMaxId();
        System.out.println(employee);
        Assert.assertNotNull(employee);

    }

    @Test
    public void findByNameInOrAgeLessThan() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("test16");
        list.add("LUBAN");
        list.add("DIRENJIE");
        List<Employee> employeeList = repository.findByNameInOrAgeLessThan(list, 20);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() throws Exception {
        List<Employee> employeeList = repository.findByNameStartingWithAndAgeLessThan("test", 20);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);
    }

    @Test
    public void findAll() throws Exception {
        List<Employee> employeeList = repository.findAllByNameIsNotNullOrderByAge();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        Assert.assertTrue(employeeList.size() > 0);
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
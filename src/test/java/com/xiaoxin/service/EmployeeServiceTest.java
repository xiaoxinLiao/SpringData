package com.xiaoxin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-data.xml")
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService service;

    @Test
    public void updateAgeById() throws Exception {
        boolean success = service.updateAgeById(1,10);
        System.out.println(success);
        assertEquals(true,success);
    }

}
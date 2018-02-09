package com;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ("classpath:beans.xml")
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;
    @Test
    public void dataSourceTest() {
        Assert.assertNotNull(dataSource);

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTemplateTest() {
        Assert.assertNotNull(jdbcTemplate);

    }
}

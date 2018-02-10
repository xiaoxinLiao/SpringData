package com.xiaoxin.service;

import com.xiaoxin.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(rollbackOn = RuntimeException.class)
    public boolean updateAgeById(Integer id, Integer age) {
        boolean success = false;
        try {
            if (id == null || id <= 0) {
                throw new RuntimeException("Id 不合法");
            }
            if (age == null || age <= 0) {
                throw new RuntimeException("年龄错误！！");
            }
            int effectedNum = repository.updateById(id, age);
            if (effectedNum == 1) {
                success =  true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return success;
    }
}

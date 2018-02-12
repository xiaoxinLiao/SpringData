package com.xiaoxin.repository;

import com.xiaoxin.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * JpaRepository,JpaSpecificationExecutor 接口使用详解
 * @author xiaoxin Liao
 * @date 2018/2/11
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee> {

}

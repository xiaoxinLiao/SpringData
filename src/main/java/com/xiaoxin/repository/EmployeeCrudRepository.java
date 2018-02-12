package com.xiaoxin.repository;

import com.xiaoxin.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * CrudRepository应用接口
 * @author xiaoxin Liao
 * @date 2018/2/11
 */
public interface EmployeeCrudRepository extends PagingAndSortingRepository<Employee,Integer> {

}

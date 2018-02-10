package com.xiaoxin.repository;

import com.xiaoxin.domain.Employee;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * Repository<T,ID> : T:Target目标类 ID: 主键类型
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository {
    /**
     * 根据名称查询
     * @param name 要查询的名字
     * @return
     */
    Employee findByName(String name);

    /**
     * 查询所有Employee
     * @return
     */
    
    List<Employee> findAllByNameIsNotNullOrderByAge();

}

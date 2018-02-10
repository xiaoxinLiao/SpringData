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
     * @return 返回查询到的Employee对象
     */
    Employee findByName(String name);

    /**
     * 查询所有Employee
     * @return 返回所有Employee 姓名不为空
     */
    List<Employee> findAllByNameIsNotNullOrderByAge();

    /**
     *  where name like ?% and age < ?
     * @param startWith 名字以startWith 开头
     * @param lessThan 年龄小于 lessThan
     * @return 满足查询条件的结果
     */
    List<Employee> findByNameStartingWithAndAgeLessThan(String startWith, Integer lessThan);

    /**
     *  where name in(?,?...) or age < ?
     *  查询在指定姓名集或者年龄不小于指定值的{@link Employee}
     * @param names 指定的姓名集合
     * @param age 指定的年龄
     * @return 满足查询条件的结果
     */
    List<Employee> findByNameInOrAgeLessThan(List<String> names,Integer age);
}

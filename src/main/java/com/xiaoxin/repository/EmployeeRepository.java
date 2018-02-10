package com.xiaoxin.repository;

import com.xiaoxin.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository<T,ID> : T:Target目标类 ID: 主键类型
 *
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {
    /**
     * 根据名称查询
     *
     * @param name 要查询的名字
     * @return 返回查询到的Employee对象
     */
    Employee findByName(String name);

    /**
     * 查询所有Employee
     *
     * @return 返回所有Employee 姓名不为空
     */
    List<Employee> findAllByNameIsNotNullOrderByAge();

    /**
     * where name like ?% and age < ?
     *
     * @param startWith 名字以startWith 开头
     * @param lessThan  年龄小于 lessThan
     * @return 满足查询条件的结果
     */
    List<Employee> findByNameStartingWithAndAgeLessThan(String startWith, Integer lessThan);

    /**
     * where name in(?,?...) or age < ?
     * 查询在指定姓名集或者年龄不小于指定值的{@link Employee}
     *
     * @param names 指定的姓名集合
     * @param age   指定的年龄
     * @return 满足查询条件的结果
     */
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    /**
     * 查询ID 最大的 {@link Employee}
     *
     * @return 返回id最大的Employee
     */
    @Query("select e from Employee e where id=(select max(id) from Employee e1)")
    Employee getEmployeeByMaxId();

    /**
     * 带占位符的索引参数查询
     *
     * @param name 第1个索引参数，name
     * @param age  第2个索引参数，age
     * @return 满足条件的结果
     */
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    List<Employee> queryParams1(String name, Integer age);


    /**
     * 命名参数的查询
     * o.name=:name , @Param("name") String name
     * :后面的参数名要和@Param("name")的value对应
     *
     * @param name 第1个命名参数，name
     * @param age  第2个命名参数，age
     * @return 满足条件的结果
     */
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 索引参数的模糊查询
     *
     * @param name 匹配的姓名
     * @return 匹配到的 Employee
     */
    @Query(value = "select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    /**
     * 命名参数的模糊查询
     *
     * @param name 匹配的姓名
     * @return 匹配到的 Employee
     */
    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    /**
     * 原生查询方法，使用表查询 将nativeQuery属性置为True
     *
     * @return 条数
     */
    @Query(nativeQuery = true, value = "SELECT count(1) FROM employee")
    long getCount();

    /**
     * 根据Id更新数据
     * 必须添加注解 @Modifying
     * @param id 更新条件
     * @param age 更新的字段
     * @return 影响的行数
     */
    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    int updateById(@Param("id") Integer id, @Param("age") Integer age);
}




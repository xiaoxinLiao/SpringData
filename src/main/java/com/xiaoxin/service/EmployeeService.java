package com.xiaoxin.service;

import com.xiaoxin.domain.Employee;
import com.xiaoxin.repository.EmployeeCrudRepository;
import com.xiaoxin.repository.EmployeeJpaRepository;
import com.xiaoxin.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author xiaoxin Liao
 * @date 2018/2/10
 */
@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository repository;


    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

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
                success = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return success;
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public void saveAll(List<Employee> employeeList) {
        employeeCrudRepository.saveAll(employeeList);
    }

    public void page() {
        //参数：page 下标从0开始，表示查询第几页，size: 每页显示的条数
        Pageable pageable = PageRequest.of(0, 5);
        Page<Employee> page = employeeCrudRepository.findAll(pageable);
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前第几页：" + page.getNumber());
        System.out.println("当前页面的集合" + page.getContent());
        for (Employee employee : page.getContent()) {
            System.out.println(employee);
        }
        System.out.println("当前页面条数：" + page.getNumberOfElements());

    }


    public void pageAndSort() {
        Order order = Order.desc("id");
        Sort sort = Sort.by(order);
        //参数：page 下标从0开始，表示查询第几页，size: 每页显示的条数
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Employee> page = employeeCrudRepository.findAll(pageable);
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的集合" + page.getContent());
        for (Employee employee : page.getContent()) {
            System.out.println(employee);
        }
        System.out.println("当前页面条数：" + page.getNumberOfElements());
    }

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> findAll() {
        return employeeJpaRepository.findAll();

    }

    public boolean exist(Integer id) {
        return employeeJpaRepository.existsById(id);
    }

    /**
     * 1)page
     * 2)sort
     * 3)查询条件 age>100
     */
    public void pageAndSortAndAgeLessThan() {
        Order order = Order.asc("id");
        Sort sort = Sort.by(order);
        //参数：page 下标从0开始，表示查询第几页，size: 每页显示的条数
        Pageable pageable = PageRequest.of(0, 10, sort);

        Page<Employee> page = employeeJpaRepository.findAll(new Specification<Employee>() {
            /**
             *
             * @param root 可以获取属性值 root.get("属性值") 返回{@link Path} root->Employee->age
             * @param query 添加查询条件 having,groupBy,orderBy ...
             * @param criteriaBuilder 构造 Predicate
             * @return Predicate
             */
            @Nullable
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Path path = root.get("age");
                return criteriaBuilder.gt(path, 100);
            }
        }, pageable);

        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的集合" + page.getContent());
        for (Employee employee : page.getContent()) {
            System.out.println(employee);
        }
        System.out.println("当前页面条数：" + page.getNumberOfElements());
    }

}

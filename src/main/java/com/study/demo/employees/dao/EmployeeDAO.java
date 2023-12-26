package com.study.demo.employees.dao;

import com.study.demo.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

     Employee findByEmployeeId(int id);

     Employee save(Employee employee);

     void deleteById(int id);
}

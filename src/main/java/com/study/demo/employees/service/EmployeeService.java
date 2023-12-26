package com.study.demo.employees.service;

import com.study.demo.employees.dao.EmployeeDAO;
import com.study.demo.employees.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> findAll();


    Employee findByEmployeeId(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}

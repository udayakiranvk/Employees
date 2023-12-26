package com.study.demo.employees.service.impl;

import com.study.demo.employees.dao.EmployeeDAO;
import com.study.demo.employees.entity.Employee;
import com.study.demo.employees.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    /**
     * @return
     */

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Employee findByEmployeeId(int id) {
       return employeeDAO.findByEmployeeId(id);
    }

    /**
     * @param employee
     * @return
     */
    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}

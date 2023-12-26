package com.study.demo.employees.dao.impl;

import com.study.demo.employees.dao.EmployeeDAO;
import com.study.demo.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @return List<Employee>
     */
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);

        List<Employee> employees;
        employees = query.getResultList();

        return employees;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Employee findByEmployeeId(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }



    /**
     * @param employee
     * @return
     */
    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);

        return employee;
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }


}

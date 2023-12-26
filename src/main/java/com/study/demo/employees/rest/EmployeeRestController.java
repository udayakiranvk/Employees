package com.study.demo.employees.rest;


import com.study.demo.employees.dao.EmployeeDAO;
import com.study.demo.employees.entity.Employee;
import com.study.demo.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findByEmployeeId(employeeId);
        if (employee==null)
        {
            throw new RuntimeException("Employee Id Not Found "+ employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);



        /*if(newEmployee == null)
        {
            throw new RuntimeException("Unable to add Employee"+employee.toString());
        }*/
        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public List<Employee> deleteEmployee(@PathVariable int employeeId)
    {
        employeeService.deleteById(employeeId);

        return employeeService.findAll();
    }
}

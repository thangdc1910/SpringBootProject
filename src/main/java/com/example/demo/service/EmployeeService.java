package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployee(Integer empNo);
    public int saveEmployee(Employee employee);
    public int updateEmployee(Employee employee);
    public int deleteEmployee(Integer empNo);
}

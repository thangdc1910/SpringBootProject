package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDAO.getALlEmployees();
    }

    @Override
    public Employee getEmployee(Integer empNo) {
        return employeeDAO.getEmployee(empNo);
    }

    @Override
    public int saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(Integer empNo) {
        return employeeDAO.deleteEmployee(empNo);
    }
}

package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class TestClass {

    @Autowired
    EmployeeService employeeService;

    @org.junit.jupiter.api.Test
    public void testX() {
        employeeService.updateEmployee(Employee.builder().empName("LOANLOAN").position("MANAGER").empNo(6).build());
        System.out.println("XXXXXX");
    }
}

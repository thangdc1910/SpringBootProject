package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cm")
@Slf4j
public class CamelController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello Spring Camel";
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<Employee> getEmployees(){
        log.info("get all employees");
        return employeeService.getAllEmployee();
    }

}

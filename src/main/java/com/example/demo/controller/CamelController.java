package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cm")
@Slf4j
public class CamelController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello Spring Camel";
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<Employee> getEmployees(@RequestParam(name = "empNo", required = false) Integer empNo) {
        log.info("get all employees");
        if (empNo != null) {
            Employee employee = employeeService.getAllEmployee().stream().filter(e -> empNo.equals(e.getEmpNo())).findAny().orElse(null);
            List list = new ArrayList<Employee>();
            list.add(employee);
            return list;
        }
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/employee/{empNo}")
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") Integer empNo) {
        return employeeService.getEmployee(empNo);
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<Employee> getOneEmployee() {
        // return new ResponseEntity<>(employeeService.getEmployee(1), HttpStatus.BAD_REQUEST);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/employee")
    public int saveEmployee(@RequestBody Employee employee) {
        log.info("Adding Employee: " + employee.getEmpNo());
        return employeeService.saveEmployee(employee);
    }

    @PutMapping(value = "/employee")
    public int updateEmployee(@RequestBody Employee employee) {
        log.info("Update Employee: " + employee.getEmpNo());
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value ="/employee")
    public int deleteEmployee(@RequestParam(name = "empNo",required = true) Integer empNo){
        log.info("Delete Employee: "+ employeeService.deleteEmployee(empNo));
        return employeeService.deleteEmployee(empNo);
    }


}

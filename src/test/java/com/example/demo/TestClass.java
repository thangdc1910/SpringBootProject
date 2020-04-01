package com.example.demo;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestClass {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();

/*    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void testGetEmployeeById() {
        Employee employeeTest = Employee.builder().empNo(1).empName("Thang").position("Dev").build();
        when(employeeDAO.getEmployee(1)).thenReturn(employeeTest);

        Employee employee = employeeService.getEmployee(1);
        verify(employeeDAO,times(1)).getEmployee(1);
        assertEquals("Thang", employee.getEmpName());
        assertEquals("Dev",employee.getPosition());
        assertEquals(1,employee.getEmpNo().intValue());
    }

    @Test
    public void testSaveEmployee(){
        Employee employeeTest = Employee.builder().empNo(1).empName("Thang").position("Dev").build();
        employeeService.saveEmployee(employeeTest);
        verify(employeeDAO,times(1)).saveEmployee(employeeTest);
    }

    @Test
    public void testUpdateEmployee(){
        Employee employeeTest = Employee.builder().empNo(1).empName("Thang").position("Dev").build();
        when(employeeDAO.updateEmployee(employeeTest)).thenReturn(1);
        Integer i = employeeService.updateEmployee(employeeTest);
        assertEquals(1,1);
        verify(employeeDAO).updateEmployee(employeeTest);
    }

    @Test
    public void testGetALlEmployees(){
        Employee employee1 = Employee.builder().empNo(1).empName("Thang").position("Dev").build();
        Employee employee2 = Employee.builder().empNo(2).empName("Thang").position("Dev").build();
        Employee employee3 = Employee.builder().empNo(3).empName("Thang").position("Dev").build();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        when(employeeDAO.getALlEmployees()).thenReturn(employeeList);

        List<Employee> employees = employeeService.getAllEmployee();

        assertEquals(3,employees.size());
        verify(employeeDAO,times(1)).getALlEmployees();

    }

}

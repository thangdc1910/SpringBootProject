package com.example.demo.dao;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    @Qualifier("mysqlJdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getALlEmployees() {
        String query = "SELECT * FROM Employee";
        return jdbcTemplate.query(query, new EmployeeMapper());
    }

    public Employee getEmployee(Integer empNo) {
        String query = "SELECT * FROM Employee WHERE empNo = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{empNo}, new EmployeeMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int saveEmployee(Employee employee) {
        String query = "INSERT INTO EMPLOYEE(EmpName,Position) VALUES('" + employee.getEmpName() + "','" + employee.getPosition() + "')";
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Employee employee) {
        String query = "UPDATE EMPLOYEE SET EmpName = '" + employee.getEmpName() + "', Position = '" + employee.getPosition() + "' " +
                "WHERE EmpNo = '" + employee.getEmpNo() + "'";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Integer empNo) {
        String query = "Delete from EMPLOYEE WHERE EmpNo = '" + empNo + "'";
        return jdbcTemplate.update(query);
    }
}
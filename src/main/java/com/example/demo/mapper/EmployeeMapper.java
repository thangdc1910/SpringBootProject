package com.example.demo.mapper;

import com.example.demo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        return Employee.builder().empNo(resultSet.getInt("EmpNo"))
                .empName(resultSet.getString("EmpName"))
                .position(resultSet.getString("Position")).build();
    }
}

package com.example.demo.dao;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    @Qualifier("mysqlJdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getALlEmployees(){
        String query ="SELECT * FROM Employee";
        return jdbcTemplate.query(query,new EmployeeMapper());
    }
}

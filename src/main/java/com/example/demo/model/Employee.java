package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Employee {

    private Integer empNo;
    private String empName;
    private String position;

    public Employee() {

    }
}


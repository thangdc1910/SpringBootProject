package com.example.demo.model;


import com.example.demo.entity.BankAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankAccountDto {
    private Long id;
    private String fullName;
    private double balance;

    public BankAccountDto() {

    }

    public BankAccountDto(Long id, String fullName, double balance) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
    }
}

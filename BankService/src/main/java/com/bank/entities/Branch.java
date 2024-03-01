package com.bank.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Branch {

    private String ifscCode;
    private String micrCode;
    private String branchName;
    private String branchAddress;
    private String branchTelephone;
    private String branchEmail;
    private String bankCode;

    private List<Customer> customers;
}

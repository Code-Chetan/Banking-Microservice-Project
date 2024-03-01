package com.branch.Entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bank {

    private String bankCode;
    private String bankName;

    private List<Branch> branches;


    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Branch> getBranches() {
        return this.branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

}

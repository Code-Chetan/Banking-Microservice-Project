package com.branch.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Branch {

    @Id
    private String ifscCode;
    private String micrCode;
    private String branchName;
    private String branchAddress;
    private String branchTelephone;
    private String branchEmail;

    private String bankCode;
    transient private List<Customer> customers;
}

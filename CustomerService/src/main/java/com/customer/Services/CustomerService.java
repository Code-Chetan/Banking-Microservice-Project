package com.customer.Services;

import java.util.List;

import com.customer.Entities.Customer;

public interface CustomerService {

    Customer add(Customer customer);
    Customer getOne(Long custAccNo);
    List<Customer> getAll();
    void delete(Long custAccNo);
    Customer update(Customer customer,Long custAccNo);
    public List<Customer> getCustomersOfBranch(String ifscCode);
}

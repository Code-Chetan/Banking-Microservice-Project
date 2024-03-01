package com.customer.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entities.Customer;
import com.customer.Repositories.CustomerRepository;
import com.customer.Services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getOne(Long custAccNo) {
        return customerRepository.findById(custAccNo).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long custAccNo) {
        customerRepository.deleteById(custAccNo);
    }

    @Override
    public Customer update(Customer customer, Long custAccNo) {
        Customer c= customerRepository.findById(custAccNo).orElseThrow(() -> new RuntimeException("Customer not found"));
        c.setCustAccNumber(customer.getCustAccNumber());
        c.setCustName(customer.getCustName());
        c.setIfscCode(customer.getIfscCode());
        c.setIfscCode(customer.getIfscCode());
        return customerRepository.save(c);
    }

    @Override
    public List<Customer> getCustomersOfBranch(String ifscCode){
        return customerRepository.findByIfscCode(ifscCode);
    }
}

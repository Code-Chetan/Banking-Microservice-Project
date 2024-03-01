package com.customer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entities.Customer;
import com.customer.Services.Impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping()
    public Customer addCustomer(@RequestBody Customer customer){
        return customerServiceImpl.add(customer);
    }

    @GetMapping("/get/{custAccNumber}")
    public Customer getCustomer(@PathVariable Long custAccNumber){
        return customerServiceImpl.getOne(custAccNumber);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomer(){
        return customerServiceImpl.getAll();
    }

    @DeleteMapping("/delete/{custAccNumber}")
    public void deleteCustomer(@PathVariable Long custAccNumber){
        customerServiceImpl.delete(custAccNumber);
    }

    @PutMapping("/modify/{custAccNumber}")
    public Customer modifyCustomer(@RequestBody Customer customer, @PathVariable Long custAccNumber){
        return customerServiceImpl.update(customer, custAccNumber);
    }

    @GetMapping("/getc/{ifscCode}")
    public List<Customer> getCustomersOfBranch(@PathVariable String ifscCode){
        return customerServiceImpl.getCustomersOfBranch(ifscCode);
    }
}

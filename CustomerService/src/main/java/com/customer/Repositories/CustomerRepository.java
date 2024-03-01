package com.customer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entities.Customer;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>  {

    public List<Customer> findByIfscCode(String ifscCode);
}


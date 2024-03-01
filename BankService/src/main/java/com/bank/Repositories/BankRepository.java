package com.bank.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,String> {
}

package com.bank.Services;

import java.util.List;

import com.bank.entities.Bank;

public interface BankService {

    Bank add(Bank bank);
    Bank getOne(String bankCode);
    List<Bank> getAll();
    void deleteOne(String bankCode);
    Bank update(Bank bank,String bankCode);

}

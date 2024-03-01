package com.bank.Services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repositories.BankRepository;
import com.bank.Services.BankService;
import com.bank.Services.BranchClient;
import com.bank.Services.CustomerClient;
import com.bank.entities.Bank;
import com.bank.entities.Branch;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BranchClient branchClient;

    @Autowired
    private CustomerClient customerClient;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank add(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank getOne(String bankCode) {
        Bank b=bankRepository.findById(bankCode).orElseThrow( () -> new RuntimeException("Bank not found"));

        b.setBranches(branchClient.getBranchesOfBank(b.getBankCode()));

             List<Branch> branchList=b.getBranches();
             List<Branch> branchs=branchList.stream().map(branch -> {
                 branch.setCustomers(customerClient.getCustomersOfBranch(branch.getIfscCode()));
                 return branch;
             }).collect(Collectors.toList());

        b.setBranches(branchs);
        return b;
    }

    @Override
    public List<Bank> getAll() {
        List<Bank> banks=bankRepository.findAll();

        return banks;
    }

    @Override
    public void deleteOne(String bankCode) {
        bankRepository.deleteById(bankCode);
    }

    @Override
    public Bank update(Bank bank, String bankCode) {
        Optional<Bank> op=bankRepository.findById(bankCode);

        Bank b=op.orElseThrow(() -> new RuntimeException("Bank not found"));
        b.setBankCode(bank.getBankCode());
        b.setBankName(bank.getBankName());
        b.setBranches(bank.getBranches());

        return bankRepository.save(b);
    }
}

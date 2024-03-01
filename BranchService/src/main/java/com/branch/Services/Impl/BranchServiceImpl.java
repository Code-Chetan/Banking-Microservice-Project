package com.branch.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.branch.Entities.Branch;
import com.branch.Repositories.BranchRepository;
import com.branch.Services.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch add(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch getOne(String ifscCode) {
        return branchRepository.findById(ifscCode).orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public void delete(String ifscCode) {
        branchRepository.deleteById(ifscCode);
    }

    @Override
    public Branch update(Branch branch, String ifscCode) {
        Branch b=branchRepository.findById(ifscCode).orElseThrow(() -> new RuntimeException("Branch not found"));

        b.setIfscCode(branch.getIfscCode());
        b.setMicrCode(branch.getMicrCode());
        b.setBranchName(branch.getBranchName());
        b.setBranchAddress(branch.getBranchAddress());
        b.setBranchTelephone(branch.getBranchTelephone());
        b.setBranchEmail(branch.getBranchEmail());
        b.setBankCode(branch.getBankCode());

        return branchRepository.save(b);
    }

    @Override
    public List<Branch> getBranchesOfBank(String bankCode){
        return branchRepository.findByBankCode(bankCode);
    }
}

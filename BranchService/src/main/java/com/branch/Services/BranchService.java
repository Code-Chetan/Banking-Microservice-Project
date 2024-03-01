package com.branch.Services;

import java.util.List;

import com.branch.Entities.Branch;

public interface BranchService {
     Branch add(Branch branch);
     Branch getOne(String ifscCode);
     List<Branch> getAll();
     void delete(String ifscCode);
     Branch update(Branch branch, String ifscCode);
     public List<Branch> getBranchesOfBank(String bankCode);
}

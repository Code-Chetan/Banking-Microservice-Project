package com.branch.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.branch.Entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,String> {

    List<Branch> findByBankCode(String bankCode);
}

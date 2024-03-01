package com.branch.Controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.branch.Entities.Branch;
import com.branch.Services.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping()
    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
        Branch b=branchService.add(branch);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(b);
    }

    @GetMapping("/get/{ifscCode}")
    public ResponseEntity<Branch> getBranch(@PathVariable String ifscCode){
        Branch b=branchService.getOne(ifscCode);
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(b);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Branch>> getAllBranches(){
        List<Branch> branches=branchService.getAll();
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(branches);
    }

    @DeleteMapping("/delete/{ifscCode}")
    public void deleteBranch(@PathVariable String ifscCode){
        branchService.delete(ifscCode);
    }

    @PutMapping("/modify/{ifscCode}")
    public ResponseEntity<Branch> modifyBranch(@RequestBody Branch branch, @PathVariable String ifscCode){
        Branch br=branchService.update(branch, ifscCode);
        return ResponseEntity.status(HttpStatus.SC_OK).body(br);
    }

    @GetMapping("/getb/{bankCode}")
    public ResponseEntity<List<Branch>> getBranchesOfBank(@PathVariable String bankCode){
        List<Branch> branches=branchService.getBranchesOfBank(bankCode);
        return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(branches);
    }
}

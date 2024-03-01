package com.bank.Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.entities.Branch;

@FeignClient(url = "http://localhost:8086", value = "branch-client")
public interface BranchClient {

    @GetMapping("/branch/getb/{bankCode}")
    List<Branch> getBranchesOfBank(@PathVariable String bankCode);
}
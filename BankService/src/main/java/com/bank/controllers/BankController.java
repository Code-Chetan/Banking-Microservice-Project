package com.bank.controllers;

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

import com.bank.Services.Impl.BankServiceImpl;
import com.bank.entities.Bank;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankServiceImpl bankServiceImpl;

    @PostMapping()
    public ResponseEntity<Bank> addBank(@RequestBody Bank bank ){
        Bank result=bankServiceImpl.add(bank);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(result);
    }

    @GetMapping("/get/{bankCode}")
    public ResponseEntity<Bank> getBank(@PathVariable String bankCode){
        Bank result=bankServiceImpl.getOne(bankCode);
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Bank>> getAllBank(){
        List<Bank> list =bankServiceImpl.getAll();
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(list);
    }

    @DeleteMapping("/delete/{bankCode}")
    public void deleteBank(@PathVariable String bankCode){
        bankServiceImpl.deleteOne(bankCode);
    }

    @PutMapping("/modify/{bankCode}")
    public ResponseEntity<Bank> modifyBank(@PathVariable String bankCode,@RequestBody Bank bank){
        Bank resultBank =bankServiceImpl.update(bank, bankCode);
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(resultBank);
    }
}

package com.fis.spring.demoaccountspringjpa.controller;

import com.fis.spring.demoaccountspringjpa.entity.Account;
import com.fis.spring.demoaccountspringjpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @GetMapping("/delete/{accountId}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long accountId){
        accountService.deleteById(accountId);
        return ResponseEntity.ok("Done!");
    }

    @GetMapping("/getById/{accountId}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable Long accountId){
        return ResponseEntity.ok(accountService.getById(accountId));
    }

    @GetMapping("/getByFullname/{fullname}")
    @ResponseBody
    public ResponseEntity<?> getByFullname(@PathVariable String fullname){
        return ResponseEntity.ok(accountService.getByFullName(fullname));
    }
}
